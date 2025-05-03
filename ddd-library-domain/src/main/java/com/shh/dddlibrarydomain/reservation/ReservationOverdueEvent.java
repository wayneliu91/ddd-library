package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationOverdueEvent implements DomainEvent {
  private final ReservationId id;
  private final String bookId;
  private final UserId reserveUserId;
}
