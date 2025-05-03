package com.shh.dddlibrarydomain.lend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportLostCmdHandler {
  private final LendRepository lendRepository;

  public void handle(ReportLostCmd cmd) {
    Lend lend = lendRepository.findByIdOrError(cmd.getLendId());
    lend.reportLost();
    lendRepository.update(lend);
  }
}
