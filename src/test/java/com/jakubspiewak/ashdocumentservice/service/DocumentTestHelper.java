package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public final class DocumentTestHelper {

    public static final UUID UUID_0 = new UUID(0L, 0L);
    public static final UUID UUID_1 = new UUID(0L, 1L);
    public static final Date DATE_0 = Date.from(Instant.ofEpochMilli(10000000000L));
    public static final String DOCUMENT_TYPE_STR = "EXPENSE";
    public static final byte[] FILE_0 = "THIS IS SUPPOSED TO BE FILE".getBytes();

    public static ApiDocumentCreateRequest createApiDocumentCreateRequest() {
        return ApiDocumentCreateRequest.builder()
                .type(DOCUMENT_TYPE_STR)
                .date(DATE_0)
                .referenceId(UUID_0)
                .file(FILE_0)
                .build();
    }

    public static DocumentEntity createDocumentEntity() {
        return DocumentEntity.builder()
                .id(UUID_0)
                .referenceId(UUID_0)
                .fileId(UUID_0)
                .type(DocumentType.EXPENSE)
                .date(DATE_0)
                .build();
    }
}
