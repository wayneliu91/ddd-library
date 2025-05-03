package com.shh.dddlibrarydomain.reservation;

import com.shh.dddlibrarydomain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReserveCmd {
  private final String isbn;
  private final UserId reserveUser;
}
