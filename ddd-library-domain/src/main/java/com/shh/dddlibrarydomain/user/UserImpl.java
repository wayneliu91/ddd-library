package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "t_user")
@NoArgsConstructor
public class UserImpl implements User {

  @EmbeddedId private UserId userId;
  private int overdueTimes;
  private boolean suspended;

  public UserImpl(UserId userId, int overdueTimes, boolean suspended) {
    this.userId = userId;
    this.overdueTimes = overdueTimes;
    this.suspended = suspended;
  }

  @Override
  public void increaseOverdueTimes() {
    this.overdueTimes++;
    ApplicationContextUtil.eventPublisher().publish(new UserReturnBookOverdueEvent(this.userId));
    if (this.overdueTimes == 3 && !this.suspended) {
      this.suspended = true;
      ApplicationContextUtil.eventPublisher().publish(new UserSuspendedEvent(this.userId));
    }
  }

  @Override
  public void enable() {
    if (!this.suspended) {
      return;
    }
    this.suspended = false;
    this.overdueTimes = 0;
    ApplicationContextUtil.eventPublisher().publish(new UserEnabledEvent(this.userId));
  }

  @Override
  public boolean isSuspended() {
    return suspended;
  }
}
