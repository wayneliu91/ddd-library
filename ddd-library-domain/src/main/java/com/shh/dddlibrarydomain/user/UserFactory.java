package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFactory {

  public User create(CreateUserCmd cmd) {
    UserCreatedEvent event = new UserCreatedEvent(cmd.getUserId(), cmd.getName());
    ApplicationContextUtil.eventPublisher().publish(event);
    return new UserImpl(cmd.getUserId(), 0, false);
  }
}
