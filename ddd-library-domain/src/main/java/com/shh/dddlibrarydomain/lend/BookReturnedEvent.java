package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookReturnedEvent implements DomainEvent {

  private LendId lendId;
  private String bookId;
  private UserId lendOutUser;
  private boolean bookLostBeforeReturn;
}
