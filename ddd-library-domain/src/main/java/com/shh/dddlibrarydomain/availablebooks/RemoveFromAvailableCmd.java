package com.shh.dddlibrarydomain.availablebooks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveFromAvailableCmd {
  private String isbn;
  private String bookId;
}
