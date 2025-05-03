package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class BookPutOnShelfEvent implements DomainEvent {
  private String bookId;
}
