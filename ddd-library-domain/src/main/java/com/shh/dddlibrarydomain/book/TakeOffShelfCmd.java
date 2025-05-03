package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TakeOffShelfCmd {
  private String bookId;
}
