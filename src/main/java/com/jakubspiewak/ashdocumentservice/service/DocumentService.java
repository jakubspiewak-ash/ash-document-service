package com.jakubspiewak.ashdocumentservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface DocumentService {
    void save(Object request);
    void delete(UUID id);
    void get(UUID id);
    Page<DocumentEntity> get(PageRequest request);
}
