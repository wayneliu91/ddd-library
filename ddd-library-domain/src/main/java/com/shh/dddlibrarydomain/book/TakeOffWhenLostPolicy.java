package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.lend.BookLostEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TakeOffWhenLostPolicy {
  private final TakeOffShelfCmdHandler takeOffShelfCmdHandler;

  public void onEvent(BookLostEvent event) {
    takeOffShelfCmdHandler.handle(new TakeOffShelfCmd(event.getBookId()));
  }
}
