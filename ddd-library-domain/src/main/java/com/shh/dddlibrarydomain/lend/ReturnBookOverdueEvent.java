package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReturnBookOverdueEvent implements DomainEvent {
  private LendId lendId;
  private String bookId;
  private UserId lendOutUser;
}
