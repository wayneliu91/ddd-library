package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.user.UserId;
import java.time.LocalDateTime;

public interface Reservation {
  void tryOverdue();

  void cancel(CancelReservationCmd cmd);

  ReservationId getId();

  UserId getReserveUserId();

  String getBookId();

  LocalDateTime getReserveTime();
}
