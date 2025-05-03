package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.occupybooks.OccupyBooksImpl;
import com.shh.dddlibrarydomain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupyBooksDao extends JpaRepository<OccupyBooksImpl, UserId> {}
