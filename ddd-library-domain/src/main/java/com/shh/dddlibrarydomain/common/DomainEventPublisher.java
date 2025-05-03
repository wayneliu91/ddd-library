package com.shh.dddlibrarydomain.common;

public interface DomainEventPublisher {
  void publish(DomainEvent event);
}
