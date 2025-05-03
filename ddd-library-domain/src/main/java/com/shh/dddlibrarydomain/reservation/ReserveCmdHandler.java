package com.shh.dddlibrarydomain.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReserveCmdHandler {

  private final ReservationFactory reservationFactory;
  private final ReservationRepository reservationRepository;

  public void handle(ReserveCmd cmd) {
    Reservation reservation = this.reservationFactory.create(cmd);
    this.reservationRepository.save(reservation);
  }
}
