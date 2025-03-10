package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BookLentOutEvent implements DomainEvent {
  private final LendId lendId;
  private final String bookId;
  private final UserId lendOutUserId;
  private final LocalDateTime lendOutTime;
  private final LocalDateTime dueDate;
}
