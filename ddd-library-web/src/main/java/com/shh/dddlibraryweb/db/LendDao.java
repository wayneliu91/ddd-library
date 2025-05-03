package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.lend.LendId;
import com.shh.dddlibrarydomain.lend.LendImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendDao extends JpaRepository<LendImpl, LendId> {
  LendImpl findFirst1ByBookIdOrderByLendOutTimeDesc(String bookId);
}
