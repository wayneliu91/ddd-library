package com.shh.dddlibraryweb.domain.common;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.common.DomainEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DomainEventPublisherSpringImpl implements DomainEventPublisher {

  private final ApplicationContext applicationContext;

  @Override
  public void publish(DomainEvent event) {
    applicationContext.publishEvent(event);
  }
}
