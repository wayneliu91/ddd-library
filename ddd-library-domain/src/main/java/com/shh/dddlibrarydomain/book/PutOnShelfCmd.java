package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class PutOnShelfCmd {
  private String bookId;
}
