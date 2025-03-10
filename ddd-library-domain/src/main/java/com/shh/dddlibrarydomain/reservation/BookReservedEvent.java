package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BookReservedEvent implements DomainEvent {
  private final ReservationId reservationId;
  private final String bookId;
  private final UserId reserveUserId;
  private final LocalDateTime reserveTime;
}
