package com.shh.dddlibrarydomain.lend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ReturnBookCmd {
  private String bookId;
}
