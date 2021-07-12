package com.jakubspiewak.ashdocumentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    @Override
    public void save(Object request) {
//        documentRepository.save();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void get(UUID id) {

    }

    @Override
    public Page<DocumentEntity> get(PageRequest request) {
        return documentRepository.findAll(request);
    }
}
