package com.shh.dddlibraryweb.domain.availablebooks;

import com.shh.dddlibrarydomain.availablebooks.AddToAvailablePolicy;
import com.shh.dddlibrarydomain.book.BookPutOnShelfEvent;
import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.lend.BookReturnedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddToAvailableListener {

  private final AddToAvailablePolicy addToAvailablePolicy;

  @EventListener({BookReturnedEvent.class, BookPutOnShelfEvent.class})
  public void onEvent(DomainEvent event) {
    addToAvailablePolicy.onDomainEvent(event);
  }
}
