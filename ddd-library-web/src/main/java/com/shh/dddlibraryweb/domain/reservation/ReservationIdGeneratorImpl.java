package com.shh.dddlibraryweb.domain.reservation;

import com.shh.dddlibrarydomain.reservation.ReservationId;
import com.shh.dddlibrarydomain.reservation.ReservationIdGenerator;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class ReservationIdGeneratorImpl implements ReservationIdGenerator {

  private final AtomicLong counter = new AtomicLong();

  @Override
  public ReservationId nextReservationId() {
    long count = counter.incrementAndGet();
    return new ReservationId(Long.toString(count));
  }
}
