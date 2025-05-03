package com.shh.dddlibrarydomain.user;

public interface UserRepository {
  User findByIdOrError(UserId userId);

  void save(User user);
}
