package com.obision.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obision.web.models.Release;

@Repository
public interface ReleasesRepository extends JpaRepository<Release, Long> {
    Release findFirstByOrderByIdDesc();
    List<Release> findAllByOrderByIdDesc();
}
