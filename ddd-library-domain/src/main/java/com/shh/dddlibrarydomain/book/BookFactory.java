package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookFactory {
  private final BookRepository bookRepository;

  public Book create(StockInBookCmd cmd) throws DuplicateBookIdException {
    Book existingBookWithSameId = this.bookRepository.findByBookId(cmd.getBookId());
    if (existingBookWithSameId != null) {
      throw new DuplicateBookIdException();
    }

    Book newBook = new BookImpl(cmd.getBookId(), cmd.getIsbn(), false);

    BookStockedInEvent event =
        new BookStockedInEvent(
            cmd.getBookId(), cmd.getIsbn(), cmd.getName(), cmd.getPicture(), cmd.getDescription());
    ApplicationContextUtil.eventPublisher().publish(event);

    return newBook;
  }
}
