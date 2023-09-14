package com.obision.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.apachecommons.CommonsLog;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obision.web.models.Download;
import com.obision.web.repositories.DownloadsRepository;


@RestController
@RequestMapping("/downloads")
@CommonsLog
public class DownloadController {
    private final DownloadsRepository downloadsRepository;

    public DownloadController(DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }

    @GetMapping("/{version}")
    public ResponseEntity<String> downloadFile(@PathVariable String version, HttpServletRequest request) throws Exception {
        Download download = new Download();

        try {
            download.setIp(request.getRemoteAddr());
            download.setVersion(version);

            downloadsRepository.save(download);
        } catch (Exception e) {
            log.warn("Can't save download to database", e);
        }

        return ResponseEntity.ok().build();
    }
}
