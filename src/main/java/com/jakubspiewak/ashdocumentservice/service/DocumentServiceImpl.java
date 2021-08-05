package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void save(ApiDocumentCreateRequest request) {
        final var entity = documentMapper.fromCreateRequestToEntity(request);

        documentRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        documentRepository.deleteById(id);
    }

    @Override
    public Page<DocumentEntity> get(PageRequest request) {
        return documentRepository.findAll(request);
    }
}
