package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.reservation.Reservation;
import com.shh.dddlibrarydomain.reservation.ReservationId;
import com.shh.dddlibrarydomain.reservation.ReservationImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, ReservationId> {

  ReservationImpl findByBookIdAndEffective(String bookId, Boolean b);
}
