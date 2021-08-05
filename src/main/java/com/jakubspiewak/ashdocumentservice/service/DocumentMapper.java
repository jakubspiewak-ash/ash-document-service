package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
interface DocumentMapper {
    @Mapping(target = "type", qualifiedByName = "typeMapping")
    DocumentEntity fromCreateRequestToEntity(ApiDocumentCreateRequest source);

    @Named("typeMapping")
    default DocumentType typeMapping(String source) {
        return DocumentType.valueOf(source);
    }
}
