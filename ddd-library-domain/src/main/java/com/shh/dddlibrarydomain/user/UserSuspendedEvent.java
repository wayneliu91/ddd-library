package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.DomainEvent;

public class UserSuspendedEvent implements DomainEvent {
  private final UserId userId;

  public UserSuspendedEvent(UserId userId) {
    this.userId = userId;
  }

  public UserId getUserId() {
    return userId;
  }
}
