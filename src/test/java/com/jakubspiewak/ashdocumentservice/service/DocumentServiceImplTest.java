package com.jakubspiewak.ashdocumentservice.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static com.jakubspiewak.ashdocumentservice.service.DocumentTestHelper.UUID_0;
import static com.jakubspiewak.ashdocumentservice.service.DocumentTestHelper.createApiDocumentCreateRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DocumentServiceImplTest {

    private final DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);
    private final DocumentRepository documentRepository = mock(DocumentRepository.class);
    private final FileService fileService = mock(FileService.class);

    private final DocumentService documentService = new DocumentServiceImpl(
            documentRepository,
            documentMapper,
            fileService
    );

    @Test
    void save() {
        // given
        var request = createApiDocumentCreateRequest();

        // when
        documentService.save(request);

        // then
        verify(documentRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        // when
        documentService.delete(UUID_0);

        // then
        verify(documentRepository, times(1)).deleteById(any());
    }

    @Test
    void get() {
        // given
        var pageRequest = PageRequest.of(0, 2);

        // when
        when(documentRepository.findAll(pageRequest)).thenReturn(Page.empty(Pageable.ofSize(2)));
        var actualPageDocument = documentService.get(pageRequest);

        // then
        verify(documentRepository, times(1)).findAll(any(PageRequest.class));
        assertEquals(2, actualPageDocument.getSize());
    }
}