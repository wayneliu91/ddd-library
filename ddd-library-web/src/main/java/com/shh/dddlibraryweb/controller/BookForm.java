package com.shh.dddlibraryweb.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookForm {
  private String bookId;
  private String isbn;
  private String name;
  private String picture;
  private String description;
}
