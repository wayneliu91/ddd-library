package com.shh.dddlibraryweb.controller;

import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibrarydomain.reservation.*;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reserve")
@RestController
@AllArgsConstructor
public class ReserveMutationController {

  private final ReserveCmdHandler reserveBookCmdHandler;
  private final CancelReservationCmdHandler cancelReservationCmdHandler;

  private final TransactionTemplate transactionTemplate;

  @GetMapping("/")
  public String reserveBook(
      @RequestParam("isbn") String isbn, @RequestParam("userId") String userId) {
    transactionTemplate.execute(
        _ -> {
          try {
            reserveBookCmdHandler.handle(new ReserveCmd(isbn, new UserId(userId)));
          } catch (DomainException e) {
            throw new RuntimeException(e);
          }
          return null;
        });
    return "OK";
  }

  @GetMapping("/")
  public String cancelReservation(@RequestParam("reservationId") String reservationId) {
    transactionTemplate.execute(
        _ -> {
          cancelReservationCmdHandler.handle(
              new CancelReservationCmd(new ReservationId(reservationId)));
          return null;
        });
    return "OK";
  }
}
