package com.shh.dddlibrarydomain.availablebooks;

import com.shh.dddlibrarydomain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookAvailableEvent implements DomainEvent {
  private String isbn;
  private String bookId;
}
