package com.shh.dddlibrarydomain.availablebooks;

import lombok.Data;

@Data
public class AddToAvailableCmd {
  private String isbn;
  private String bookId;
}
