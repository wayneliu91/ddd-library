package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.book.BookTakenOffShelfEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CancelWhenTakeOffBookPolicy {

  private final CancelReservationCmdHandler cancelReservationCmdHandler;
  private final ReservationRepository reservationRepository;

  @EventListener
  public void onEvent(BookTakenOffShelfEvent event) {
    Reservation reservation = reservationRepository.findEffectiveByBookId(event.getBookId());
    if (reservation == null) {
      return;
    }
    cancelReservationCmdHandler.handle(new CancelReservationCmd(reservation.getId()));
  }
}
