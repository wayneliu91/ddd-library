package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class BookLentOutEvent implements DomainEvent {
  private final LendId lendId;
  private final String bookId;
  private final UserId lendOutUserId;
  private final LocalDateTime lendOutTime;
  private final LocalDateTime dueDate;
}
