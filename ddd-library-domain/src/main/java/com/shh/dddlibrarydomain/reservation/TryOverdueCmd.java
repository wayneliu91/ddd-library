package com.shh.dddlibrarydomain.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TryOverdueCmd {

  private ReservationId id;
}
