package com.shh.dddlibrarydomain.occupybooks;

import com.shh.dddlibrarydomain.user.UserId;

public interface OccupyBooksRepository {
  OccupyBooks findById(UserId userId);

  void save(OccupyBooks occupyBooks);
}
