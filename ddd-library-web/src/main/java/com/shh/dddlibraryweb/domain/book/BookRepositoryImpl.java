package com.shh.dddlibraryweb.domain.book;

import com.shh.dddlibrarydomain.book.Book;
import com.shh.dddlibrarydomain.book.BookImpl;
import com.shh.dddlibrarydomain.book.BookRepository;
import com.shh.dddlibrarydomain.common.DomainException;
import com.shh.dddlibraryweb.db.BookDao;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

  private final BookDao bookDao;

  @Override
  public Book findByIdOrError(String bookId) throws DomainException {
    Optional<Book> optional = bookDao.findById(bookId);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new DomainException("找不到书");
  }

  @Override
  public Book findByBookId(String bookId) {
    return bookDao.findById(bookId).orElse(null);
  }

  @Override
  public void save(Book book) {
    if (!(book instanceof BookImpl)) {
      throw new IllegalArgumentException();
    }
    bookDao.save(book);
  }
}
