package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.document.ApiDocumentCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> save(@RequestBody ApiDocumentCreateRequest request) {
        log.info("POST: [{}]", request);
        if (request.getFile() == null) return ResponseEntity.status(OK).build();
        if (request.getFile().length == 0) return ResponseEntity.status(OK).build();

        log.info("Saving [{}]", request);
        documentService.save(request);

        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping(produces = "application/pdf")
    public ResponseEntity<Object> get(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        var pageable = PageRequest.of(page,size, DESC, "date");
        final var entity = documentService.get(pageable);

        return ResponseEntity.status(OK).body(entity);
    }
}