package com.shh.dddlibrarydomain.occupybooks;

import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyUserOccupyBooksCmd {
  private final UserId userId;
  private final int increment;
}
