package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockInBookCmdHandler {
  private final BookRepository bookRepository;
  private final BookFactory bookFactory;

  public void handle(StockInBookCmd cmd) throws DuplicateBookIdException {
    Book book = this.bookFactory.create(cmd);
    bookRepository.save(book);
  }
}
