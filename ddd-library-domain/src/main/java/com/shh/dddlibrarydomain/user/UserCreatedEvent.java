package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.DomainEvent;

public class UserCreatedEvent implements DomainEvent {
  private final UserId userId;
  private final String name;

  public UserCreatedEvent(UserId userId, String name) {
    this.userId = userId;
    this.name = name;
  }

  public UserId getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
}
