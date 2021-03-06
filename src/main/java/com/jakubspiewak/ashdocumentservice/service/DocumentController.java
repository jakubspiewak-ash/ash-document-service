package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentGetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DocumentController {

  private final DocumentService documentService;

  @PostMapping
  public ResponseEntity<UUID> save(@RequestBody ApiDocumentCreateRequest request) {
    final var id = documentService.save(request);

    return ResponseEntity.status(CREATED).body(id);
  }

  @GetMapping
  public ResponseEntity<Page<ApiDocumentGetResponse>> get(
      @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
    log.info("Getting documents page...");
    var pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 1, DESC, "date");
    final var responses = documentService.get(pageable);
    return ResponseEntity.status(OK).body(responses);
  }
}