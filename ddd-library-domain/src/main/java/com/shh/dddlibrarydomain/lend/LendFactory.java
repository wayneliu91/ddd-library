package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.book.Book;
import com.shh.dddlibrarydomain.book.BookRepository;
import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibrarydomain.occupybooks.OccupyBooks;
import com.shh.dddlibrarydomain.occupybooks.OccupyBooksRepository;
import com.shh.dddlibrarydomain.reservation.Reservation;
import com.shh.dddlibrarydomain.reservation.ReservationRepository;
import com.shh.dddlibrarydomain.user.User;
import com.shh.dddlibrarydomain.user.UserRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class LendFactory {
  private final UserRepository userRepository;
  private final BookRepository bookRepository;
  private final ReservationRepository reservationRepository;
  private final OccupyBooksRepository occupyBooksRepository;
  private final LendIdGenerator lendIdGenerator;

  public LendFactory(
      UserRepository userRepository,
      BookRepository bookRepository,
      ReservationRepository reservationRepository,
      OccupyBooksRepository occupyBooksRepository,
      LendIdGenerator lendIdGenerator) {
    this.userRepository = userRepository;
    this.bookRepository = bookRepository;
    this.reservationRepository = reservationRepository;
    this.occupyBooksRepository = occupyBooksRepository;
    this.lendIdGenerator = lendIdGenerator;
  }

  public Lend create(LendOutCmd cmd) throws DomainException {
    User user = userRepository.findByIdOrError(cmd.getLendOutUserId());
    if (user.isSuspended()) {
      throw new DomainException("用户账户已暂停，不能借书");
    }

    Book book = bookRepository.findByIdOrError(cmd.getBookId());
    if (!book.isOnShelf()) {
      throw new DomainException("书已下架，不能借出");
    }

    Reservation reservation = this.reservationRepository.findEffectiveByBookId(cmd.getBookId());
    if (reservation != null && !reservation.getReserveUserId().equals(cmd.getLendOutUserId())) {
      throw new DomainException("书已被别人预定，不能借出");
    }

    OccupyBooks occupyBooks = this.occupyBooksRepository.findById(cmd.getLendOutUserId());
    if (occupyBooks.countOfOccupiedBooks() >= 3) {
      throw new DomainException("用户已经占用3本书，不能借出更多书");
    }

    Lend lend =
        new LendImpl(
            lendIdGenerator.nextLendId(),
            cmd.getBookId(),
            false,
            true,
            LocalDateTime.now(),
            cmd.getLendOutUserId());

    ApplicationContextUtil.eventPublisher()
        .publish(
            new BookLentOutEvent(
                lend.getId(),
                cmd.getBookId(),
                cmd.getLendOutUserId(),
                lend.getLendOutTime(),
                lend.getLendOutTime().plusDays(30)));

    return lend;
  }
}
