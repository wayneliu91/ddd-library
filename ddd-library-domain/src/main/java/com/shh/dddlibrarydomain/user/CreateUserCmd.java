package com.shh.dddlibrarydomain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCmd {

  private UserId userId;
  private String name;
}
