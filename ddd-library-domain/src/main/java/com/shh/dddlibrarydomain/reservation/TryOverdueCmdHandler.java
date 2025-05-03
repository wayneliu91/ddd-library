package com.shh.dddlibrarydomain.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TryOverdueCmdHandler {
  private final ReservationRepository reservationRepository;

  public void handle(TryOverdueCmd cmd) {
    Reservation reservation = this.reservationRepository.findByIdOrError(cmd.getId());
    reservation.tryOverdue();
    this.reservationRepository.save(reservation);
  }
}
