package com.shh.dddlibrarydomain.lend;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReportLostCmd {
  private LendId lendId;
}
