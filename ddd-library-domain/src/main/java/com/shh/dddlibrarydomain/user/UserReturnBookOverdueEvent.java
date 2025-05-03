package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.DomainEvent;

public class UserReturnBookOverdueEvent implements DomainEvent {
  private final UserId userId;

  public UserReturnBookOverdueEvent(UserId userId) {
    this.userId = userId;
  }

  public UserId getUserId() {
    return userId;
  }
}
