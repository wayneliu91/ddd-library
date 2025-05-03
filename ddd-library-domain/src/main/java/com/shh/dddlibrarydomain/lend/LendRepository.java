package com.shh.dddlibrarydomain.lend;

public interface LendRepository {
  void save(Lend lend);

  void update(Lend lend);

  Lend findLatestByBookIdOrError(String bookId);

  Lend findByIdOrError(LendId lendId);
}
