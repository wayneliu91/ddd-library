package com.shh.dddlibrarydomain.availablebooks;

import com.shh.dddlibrarydomain.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookUnavailableEvent implements DomainEvent {
  private String isbn;
  private String bookId;
}
