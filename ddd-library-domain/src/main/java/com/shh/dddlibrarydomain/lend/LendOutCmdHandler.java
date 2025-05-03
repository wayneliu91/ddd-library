package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.common.DomainException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LendOutCmdHandler {
  private final LendFactory lendFactory;
  private final LendRepository lendRepository;

  public void handle(LendOutCmd cmd) throws DomainException {
    Lend lend = lendFactory.create(cmd);
    this.lendRepository.save(lend);
  }
}
