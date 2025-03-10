package com.shh.dddlibrarydomain;

public interface DomainEventListener {
  void onDomainEvent(DomainEvent event);
}
