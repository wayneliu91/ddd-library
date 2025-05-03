package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.common.DomainException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReserveCmdHandler {

  private final ReservationFactory reservationFactory;
  private final ReservationRepository reservationRepository;

  public void handle(ReserveCmd cmd) throws DomainException {
    Reservation reservation = this.reservationFactory.create(cmd);
    this.reservationRepository.save(reservation);
  }
}
