package com.jakubspiewak.ashdocumentservice.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "document_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class DocumentEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "file_id")
    private UUID fileId;

    @Column(name = "member_of_id")
    private UUID referenceId;

    @Enumerated(STRING)
    @Column(name = "type")
    private DocumentType type;

    @Column(name = "date")
    private Date date;
}
