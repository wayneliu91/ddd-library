package com.shh.dddlibrarydomain;

public interface DomainEventPublisher {
  void publish(DomainEvent event);
}
