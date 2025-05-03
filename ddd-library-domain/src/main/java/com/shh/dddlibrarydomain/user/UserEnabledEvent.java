package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.DomainEvent;

public class UserEnabledEvent implements DomainEvent {
  private final UserId userId;

  public UserEnabledEvent(UserId userId) {
    this.userId = userId;
  }

  public UserId getUserId() {
    return userId;
  }
}
