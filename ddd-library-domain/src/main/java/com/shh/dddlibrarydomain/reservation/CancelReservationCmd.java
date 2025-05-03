package com.shh.dddlibrarydomain.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelReservationCmd {
  private final ReservationId reservationId;
}
