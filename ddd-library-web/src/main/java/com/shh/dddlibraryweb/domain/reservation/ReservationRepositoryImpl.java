package com.shh.dddlibraryweb.domain.reservation;

import com.shh.dddlibrarydomain.reservation.Reservation;
import com.shh.dddlibrarydomain.reservation.ReservationId;
import com.shh.dddlibrarydomain.reservation.ReservationImpl;
import com.shh.dddlibrarydomain.reservation.ReservationRepository;
import com.shh.dddlibraryweb.db.ReservationDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {

  private final ReservationDao reservationDao;

  @Override
  public Reservation findByIdOrError(ReservationId id) {
    return reservationDao.findById(id).orElse(null);
  }

  @Override
  public Reservation findEffectiveByBookId(String bookId) {
    return reservationDao.findByBookIdAndEffective(bookId, true);
  }

  @Override
  public void save(Reservation reservation) {
    if (!(reservation instanceof ReservationImpl)) {
      throw new IllegalArgumentException();
    }
    reservationDao.save(reservation);
  }
}
