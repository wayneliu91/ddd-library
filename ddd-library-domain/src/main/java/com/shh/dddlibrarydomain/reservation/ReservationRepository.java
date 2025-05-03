package com.shh.dddlibrarydomain.reservation;

public interface ReservationRepository {
  Reservation findByIdOrError(ReservationId id);

  Reservation findEffectiveByBookId(String bookId);

  void save(Reservation reservation);
}
