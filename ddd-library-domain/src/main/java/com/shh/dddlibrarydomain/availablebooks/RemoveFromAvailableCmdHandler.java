package com.shh.dddlibrarydomain.availablebooks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveFromAvailableCmdHandler {
  private AvailableBooksRepository availableBooksRepository;

  public void handle(RemoveFromAvailableCmd cmd) {
    AvailableBooks availableBooks = availableBooksRepository.findById(cmd.getIsbn());
    availableBooks.remove(cmd.getBookId());
    availableBooksRepository.save(availableBooks);
  }
}
