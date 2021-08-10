package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
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
    private final FileService fileService;

    @Override
    public UUID save(ApiDocumentCreateRequest request) {
        final var fileId = saveFile(request);

        final var entity = DocumentEntity.builder()
                .date(request.getDate())
                .fileId(fileId)
                .referenceId(request.getReferenceId())
                .type(DocumentType.valueOf(request.getType()))
                .build();

        final var createdEntity = documentRepository.save(entity);

        return createdEntity.getId();
    }

    @Override
    public void delete(final UUID id) {
        final var entity = documentRepository.findById(id).orElseThrow();
        fileService.delete(entity.getFileId());

        documentRepository.deleteById(id);
    }

    @Override
    public Page<DocumentEntity> get(final PageRequest request) {
        return documentRepository.findAll(request);
    }

    private UUID saveFile(final ApiDocumentCreateRequest request) {
        final var createFileRequest = createApiFileRequest(request);
        return fileService.save(createFileRequest);
    }

    private ApiFileCreateRequest createApiFileRequest(final ApiDocumentCreateRequest request) {
        final var fileName = String.format("%s.pdf", request.getDate().toString());
        return ApiFileCreateRequest.builder()
                .file(request.getFile())
                .fileName(fileName)
                .build();
    }
}
