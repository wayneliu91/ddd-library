package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookReservedEvent implements DomainEvent {
  private final ReservationId reservationId;
  private final String bookId;
  private final UserId reserveUserId;
  private final LocalDateTime reserveTime;
}
