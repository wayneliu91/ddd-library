package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TakeOffShelfCmdHandler {
  private final BookRepository bookRepository;

  public void handle(TakeOffShelfCmd cmd) {
    Book book = this.bookRepository.findByIdOrError(cmd.getBookId());
    book.takeOffShelf();
    bookRepository.save(book);
  }
}
