package com.shh.dddlibrarydomain.common;

public interface DomainEventListener {
  void onDomainEvent(DomainEvent event);
}
