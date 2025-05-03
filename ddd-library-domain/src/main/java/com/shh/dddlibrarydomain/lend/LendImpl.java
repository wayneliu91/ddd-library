package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibrarydomain.user.UserId;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity(name = "Lend")
@Table(name = "t_lend")
@AttributeOverride(name = "lendOutUser.value", column = @Column(name = "lend_user_id"))
@NoArgsConstructor
@Getter
@Slf4j
public class LendImpl implements Lend {

  @EmbeddedId private LendId id;
  private String bookId;
  private boolean reportedLost;
  private boolean waitReturn;
  private LocalDateTime lendOutTime;
  @Embedded private UserId lendOutUser;
  private boolean reportedOverdue;

  public LendImpl(
      LendId id,
      String bookId,
      boolean reportedLost,
      boolean waitReturn,
      LocalDateTime lendOutTime,
      UserId lendOutUser) {
    this.id = id;
    this.bookId = bookId;
    this.reportedLost = reportedLost;
    this.waitReturn = waitReturn;
    this.lendOutTime = lendOutTime;
    this.lendOutUser = lendOutUser;
    this.reportedOverdue = false;
  }

  @Override
  public void returnBack() {
    if (!waitReturn) {
      return;
    }
    this.waitReturn = false;
    ApplicationContextUtil.eventPublisher()
        .publish(new BookReturnedEvent(this.id, this.bookId, this.lendOutUser, this.reportedLost));
    doOverdue();
  }

  private boolean overdueNow() {
    return this.lendOutTime.plusMonths(1).isBefore(LocalDateTime.now());
  }

  @Override
  public void reportLost() {
    if (this.reportedLost) {
      return;
    }
    if (!waitReturn) {
      try {
        throw new DomainException("书已被归还，不能上报遗失");
      } catch (DomainException e) {
        log.error(e.getMessage());
      }
    }
    this.reportedLost = true;
    ApplicationContextUtil.eventPublisher()
        .publish(new BookLostEvent(this.id, this.bookId, this.lendOutUser));
  }

  @Override
  public void tryOverdue() {
    if (!waitReturn) {
      return;
    }
    doOverdue();
  }

  private void doOverdue() {
    if (!this.reportedOverdue && overdueNow()) {
      this.reportedOverdue = true;
      ApplicationContextUtil.eventPublisher()
          .publish(new ReturnBookOverdueEvent(this.id, this.bookId, this.lendOutUser));
    }
  }
}
