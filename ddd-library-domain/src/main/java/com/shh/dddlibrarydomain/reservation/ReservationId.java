package com.shh.dddlibrarydomain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ReservationId {

  @Column(name = "id")
  private String value;
}
