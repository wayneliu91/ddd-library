package com.shh.dddlibrarydomain.availablebooks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddToAvailableCmd {
  private String isbn;
  private String bookId;
}
