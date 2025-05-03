package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.lend.BookReturnedEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PutOnShelfWhenReturnPolicy {

  private final PutOnShelfCmdHandler putOnShelfCmdHandler;

  public void onEvent(BookReturnedEvent event) {
    if (event.isBookLostBeforeReturn()) {
      putOnShelfCmdHandler.handle(new PutOnShelfCmd(event.getBookId()));
    }
  }
}
