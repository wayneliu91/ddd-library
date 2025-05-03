package com.shh.dddlibrarydomain.lend;

import java.time.LocalDateTime;

public interface Lend {
  void returnBack();

  void reportLost();

  void tryOverdue();

  LendId getId();

  LocalDateTime getLendOutTime();
}
