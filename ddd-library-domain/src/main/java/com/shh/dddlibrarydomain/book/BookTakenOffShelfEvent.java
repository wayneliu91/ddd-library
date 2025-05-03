package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookTakenOffShelfEvent implements DomainEvent {
  private String bookId;
}
