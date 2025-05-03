package com.shh.dddlibrarydomain.user;

import com.shh.dddlibrarydomain.common.DomainException;

public interface UserRepository {
  User findByIdOrError(UserId userId) throws DomainException;

  void save(User user);
}
