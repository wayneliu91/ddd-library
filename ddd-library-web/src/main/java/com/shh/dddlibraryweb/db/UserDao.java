package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.user.User;
import com.shh.dddlibrarydomain.user.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, UserId> {}
