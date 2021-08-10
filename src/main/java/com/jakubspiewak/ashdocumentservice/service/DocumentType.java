package com.jakubspiewak.ashdocumentservice.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
enum DocumentType {
  EXPENSE("EXPENSE"),
  ;

  private final String name;

  @Override
  public String toString() {
    return name;
  }
}
