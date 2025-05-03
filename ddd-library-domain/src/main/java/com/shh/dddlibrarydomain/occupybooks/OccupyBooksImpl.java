package com.shh.dddlibrarydomain.occupybooks;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import com.shh.dddlibrarydomain.user.UserId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_occupy_books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OccupyBooksImpl implements OccupyBooks {
  @EmbeddedId private UserId userId;

  private int occupyCount;

  @Override
  public void modify(int increment) {
    int oldOccupyCount = this.occupyCount;
    this.occupyCount += increment;
    if (this.occupyCount < 0) {
      this.occupyCount = 0;
    }
    ApplicationContextUtil.eventPublisher()
        .publish(new OccupyBooksChangedEvent(userId, occupyCount, oldOccupyCount));
  }

  @Override
  public int countOfOccupiedBooks() {
    return occupyCount;
  }

  public void setOccupyCount(int occupyCount) {
    this.occupyCount = occupyCount;
  }
}
