package com.shh.dddlibrarydomain.occupybooks;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OccupyBooksChangedEvent implements DomainEvent {
  private final UserId userId;
  private final int newOccupyCount;
  private final int oldOccupyCount;
}
