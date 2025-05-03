package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.availablebooks.AvailableBooks;
import com.shh.dddlibrarydomain.availablebooks.AvailableBooksRepository;
import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibrarydomain.occupybooks.OccupyBooksRepository;
import com.shh.dddlibrarydomain.user.User;
import com.shh.dddlibrarydomain.user.UserRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationFactory {

  private final ReservationIdGenerator reservationIdGenerator;
  private final UserRepository userRepository;
  private final AvailableBooksRepository availableBooksRepository;
  private final OccupyBooksRepository occupyBooksRepository;

  public Reservation create(ReserveCmd reserveCmd) throws DomainException {
    User reserveUser = this.userRepository.findByIdOrError(reserveCmd.getReserveUser());
    if (reserveUser.isSuspended()) {
      throw new DomainException("预定人账户已禁用，不可预定书");
    }

    AvailableBooks availableBooks = this.availableBooksRepository.findById(reserveCmd.getIsbn());
    if (availableBooks.isEmpty()) {
      throw new DomainException("没有可预订的书了");
    }

    if (this.occupyBooksRepository.findById(reserveCmd.getReserveUser()).countOfOccupiedBooks()
        >= 3) {
      throw new DomainException("每个用户最多占用3本书，你已达到限制，不能再预定啦");
    }

    String bookToReserve = availableBooks.chooseBookRandomly();

    Reservation reservation =
        new ReservationImpl(
            reservationIdGenerator.nextReservationId(),
            LocalDateTime.now(),
            reserveCmd.getReserveUser(),
            bookToReserve,
            true);

    ApplicationContextUtil.eventPublisher()
        .publish(
            new BookReservedEvent(
                ((ReservationImpl) reservation).getId(),
                ((ReservationImpl) reservation).getBookId(),
                ((ReservationImpl) reservation).getReserveUserId(),
                ((ReservationImpl) reservation).getReserveTime()));

    return reservation;
  }
}
