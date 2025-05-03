package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.availablebooks.AvailableBooks;
import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import com.shh.dddlibrarydomain.user.UserId;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Entity(name = "Reservation")
@Table(name = "t_reservation")
@AttributeOverrides({
  @AttributeOverride(name = "reserveUserId.value", column = @Column(name = "reserveUserId"))
})
@NoArgsConstructor
public class ReservationImpl implements Reservation {

  @EmbeddedId private ReservationId id;
  private LocalDateTime reserveTime;
  @Embedded private UserId reserveUserId;
  private String bookId;
  private boolean effective;

  public ReservationImpl(
      ReservationId id,
      LocalDateTime reserveTime,
      UserId reserveUserId,
      String bookId,
      boolean effective) {
    this.id = id;
    this.reserveTime = reserveTime;
    this.reserveUserId = reserveUserId;
    this.bookId = bookId;
    this.effective = effective;
  }

  @Override
  public void tryOverdue() {
    if (!effective) {
      return;
    }
    if (reserveTime.plusHours(24).isBefore(LocalDateTime.now())) {
      this.effective = false;
      ApplicationContextUtil.eventPublisher()
          .publish(new ReservationOverdueEvent(id, bookId, reserveUserId));
    }
  }

  @Override
  public void cancel(CancelReservationCmd cmd) {
    if (!effective) {
      return;
    }
    this.effective = false;
    ApplicationContextUtil.eventPublisher()
        .publish(new ReservationCanceledEvent(id, bookId, reserveUserId));
    AvailableBooks availableBooks =
        ApplicationContextUtil.availableBooksRepository()
            .findById(ApplicationContextUtil.bookRepository().findByIdOrError(bookId).getIsbn());
    availableBooks.add(bookId);
    ApplicationContextUtil.availableBooksRepository().save(availableBooks);
  }

  @Override
  public ReservationId getId() {
    return id;
  }

  @Override
  public UserId getReserveUserId() {
    return reserveUserId;
  }

  @Override
  public String getBookId() {
    return bookId;
  }

  @Override
  public LocalDateTime getReserveTime() {
    return reserveTime;
  }
}
