package com.obision.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obision.web.models.Download;

@Repository
public interface DownloadsRepository extends JpaRepository<Download, Long> {
}
