package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface DocumentService {
    UUID save(ApiDocumentCreateRequest request);

    void delete(UUID id);

    Page<DocumentEntity> get(PageRequest request);
}
