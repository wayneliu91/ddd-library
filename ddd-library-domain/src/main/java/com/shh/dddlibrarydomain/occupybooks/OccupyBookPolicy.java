package com.shh.dddlibrarydomain.occupybooks;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.lend.BookLentOutEvent;
import com.shh.dddlibrarydomain.lend.BookLostEvent;
import com.shh.dddlibrarydomain.lend.BookReturnedEvent;
import com.shh.dddlibrarydomain.reservation.BookReservedEvent;
import com.shh.dddlibrarydomain.reservation.ReservationCanceledEvent;
import com.shh.dddlibrarydomain.reservation.ReservationOverdueEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OccupyBookPolicy {

  private final ModifyUserOccupyBooksCmdHandler modifyUserOccupyBooksCmdHandler;

  public void onDomainEvent(DomainEvent event) {
    if (event instanceof BookReservedEvent bookReservedEvent) {

      ModifyUserOccupyBooksCmd cmd =
          new ModifyUserOccupyBooksCmd(bookReservedEvent.getReserveUserId(), 1);
      modifyUserOccupyBooksCmdHandler.handle(cmd);

    } else if (event instanceof BookLentOutEvent bookLentOutEvent) {

      ModifyUserOccupyBooksCmd cmd =
          new ModifyUserOccupyBooksCmd(bookLentOutEvent.getLendOutUserId(), 1);
      modifyUserOccupyBooksCmdHandler.handle(cmd);

    } else if (event instanceof BookReturnedEvent bookReturnedEvent) {
      modifyUserOccupyBooksCmdHandler.handle(
          new ModifyUserOccupyBooksCmd(bookReturnedEvent.getLendOutUser(), -1));
    } else if (event instanceof ReservationCanceledEvent reservationCanceledEvent) {
      modifyUserOccupyBooksCmdHandler.handle(
          new ModifyUserOccupyBooksCmd(reservationCanceledEvent.getReserveUserId(), -1));
    } else if (event instanceof ReservationOverdueEvent reservationOverdueEvent) {
      modifyUserOccupyBooksCmdHandler.handle(
          new ModifyUserOccupyBooksCmd(reservationOverdueEvent.getReserveUserId(), -1));
    } else if (event instanceof BookLostEvent bookLostEvent) {
      modifyUserOccupyBooksCmdHandler.handle(
          new ModifyUserOccupyBooksCmd(bookLostEvent.getLendOutUser(), -1));
    }
  }
}
