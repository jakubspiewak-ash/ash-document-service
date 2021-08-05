package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static com.jakubspiewak.ashdocumentservice.service.DocumentTestHelper.createApiDocumentCreateRequest;
import static com.jakubspiewak.ashdocumentservice.service.DocumentTestHelper.createDocumentEntity;
import static com.jakubspiewak.ashdocumentservice.service.DocumentType.EXPENSE;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mapstruct.factory.Mappers.getMapper;

@RequiredArgsConstructor
class DocumentMapperTest {

    private final DocumentMapper documentMapper = getMapper(DocumentMapper.class);

    @Test
    void fromCreateRequestToEntity() {
        // given
        var request = createApiDocumentCreateRequest();

        var expected = createDocumentEntity();
        expected.setId(null);
        expected.setFileId(null);

        // when
        var mapped = documentMapper.fromCreateRequestToEntity(request);

        // then
        assertEquals(expected, mapped);
    }
}
