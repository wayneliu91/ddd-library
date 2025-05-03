package com.shh.dddlibrarydomain.lend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TryReturnBookOverdueCmdHandler {

  private final LendRepository lendRepository;

  public void handle(TryReturnBookOverdueCmd cmd) {
    Lend lend = lendRepository.findByIdOrError(cmd.getLendId());
    lend.tryOverdue();
    lendRepository.update(lend);
  }
}
