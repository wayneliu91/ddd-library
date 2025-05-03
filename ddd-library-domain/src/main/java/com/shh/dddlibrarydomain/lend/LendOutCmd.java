package com.shh.dddlibrarydomain.lend;

import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class LendOutCmd {
  private String bookId;
  private UserId lendOutUserId;
}
