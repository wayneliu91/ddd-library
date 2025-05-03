package com.shh.dddlibraryweb.domain.user;

import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibrarydomain.user.User;
import com.shh.dddlibrarydomain.user.UserId;
import com.shh.dddlibrarydomain.user.UserRepository;
import com.shh.dddlibraryweb.db.UserDao;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserDao userDao;

  @Override
  public User findByIdOrError(UserId userId) throws DomainException {

    Optional<User> optional = userDao.findById(userId);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new DomainException("找不到用户");
  }

  @Override
  public void save(User user) {
    userDao.save(user);
  }
}
