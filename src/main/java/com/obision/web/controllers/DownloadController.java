package com.obision.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obision.web.models.Download;
import com.obision.web.repositories.DownloadsRepository;

import java.io.File;
import java.io.FileInputStream;


@RestController
@RequestMapping("/downloads")
@CommonsLog
public class DownloadController {
    @Value("${downloads.path}")
    private String downloadsPath;
    
    private final DownloadsRepository downloadsRepository;

    public DownloadController(DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }

    @GetMapping("/{version}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String version, HttpServletRequest request) throws Exception {
        Download download = new Download();

        try {
            download.setIp(request.getRemoteAddr());
            download.setVersion(version);

            downloadsRepository.save(download);
        } catch (Exception e) {
            log.warn("Can't save download to database", e);
        }

        File downloadFile = new File(downloadsPath + "/obision-" + version + ".iso");
        // InputStreamResource resource = new InputStreamResource(new FileInputStream(downloadFile));
        FileSystemResource resource = new FileSystemResource(downloadFile); 

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + downloadFile.getName());

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(downloadFile.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
