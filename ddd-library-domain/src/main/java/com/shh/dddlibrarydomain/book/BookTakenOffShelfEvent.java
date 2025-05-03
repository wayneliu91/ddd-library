package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookTakenOffShelfEvent implements DomainEvent {
  private String bookId;
}
