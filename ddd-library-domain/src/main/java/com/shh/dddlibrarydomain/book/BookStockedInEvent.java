package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookStockedInEvent implements DomainEvent {
  private String bookId;
  private String isbn;
  private String name;
  private String picture;
  private String description;
}
