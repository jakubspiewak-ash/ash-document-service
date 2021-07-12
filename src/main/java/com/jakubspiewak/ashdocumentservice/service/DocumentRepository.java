package com.jakubspiewak.ashdocumentservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<UUID, DocumentEntity> {
    Page<DocumentEntity> findAll(PageRequest request);
}
