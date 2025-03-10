package com.shh.dddlibrarydomain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserId {

  @Column(name = "id")
  private String value;
}
