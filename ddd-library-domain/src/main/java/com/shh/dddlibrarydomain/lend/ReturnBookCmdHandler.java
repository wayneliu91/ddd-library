package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.book.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReturnBookCmdHandler {

  private final BookRepository bookRepository;
  private final LendRepository lendRepository;

  public void handle(ReturnBookCmd cmd) {
    bookRepository.findByIdOrError(cmd.getBookId());
    Lend lend = lendRepository.findLatestByBookIdOrError(cmd.getBookId());
    lend.returnBack();
    lendRepository.update(lend);
  }
}
