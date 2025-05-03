package com.shh.dddlibrarydomain.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CancelReservationCmdHandler {

  private final ReservationRepository reservationRepository;

  public void handle(CancelReservationCmd cmd) {
    Reservation reservation = this.reservationRepository.findByIdOrError(cmd.getReservationId());
    reservation.cancel(cmd);
    this.reservationRepository.save(reservation);
  }
}
