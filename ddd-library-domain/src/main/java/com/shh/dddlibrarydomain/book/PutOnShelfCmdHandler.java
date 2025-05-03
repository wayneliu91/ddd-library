package com.shh.dddlibrarydomain.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PutOnShelfCmdHandler {

  private final BookRepository bookRepository;

  public void handle(PutOnShelfCmd cmd) {
    Book book = bookRepository.findByIdOrError(cmd.getBookId());
    book.putOnShelf();
    bookRepository.save(book);
  }
}
