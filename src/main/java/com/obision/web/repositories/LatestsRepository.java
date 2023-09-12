package com.obision.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obision.web.models.Latest;

@Repository
public interface LatestsRepository extends JpaRepository<Latest, Long> {
}
