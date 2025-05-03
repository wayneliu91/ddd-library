package com.shh.dddlibrarydomain.occupybooks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModifyUserOccupyBooksCmdHandler {

  private final OccupyBooksRepository occupyBooksRepository;

  public void handle(ModifyUserOccupyBooksCmd cmd) {
    OccupyBooks occupyBooks = this.occupyBooksRepository.findById(cmd.getUserId());
    occupyBooks.modify(cmd.getIncrement());
    this.occupyBooksRepository.save(occupyBooks);
  }
}
