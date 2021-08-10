package com.jakubspiewak.ashdocumentservice.service;

import com.jakubspiewak.ashapimodellib.model.file.ApiFileCreateRequest;
import com.jakubspiewak.ashapimodellib.model.file.ApiFileGetResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient("ash-file-service")
public interface FileService {

    @PostMapping
    UUID save(@RequestBody final ApiFileCreateRequest request);

    @GetMapping("/{id}")
    ApiFileGetResponse get(@PathVariable final UUID id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable final UUID id);

}
