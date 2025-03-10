package com.shh.dddlibrarydomain.lend;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class LendId {
  @Column(name = "id")
  private String value;
}
