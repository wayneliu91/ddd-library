package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class StockInBookCmd {
  private String bookId;
  private String isbn;
  private String name;
  private String picture;
  private String description;
}
