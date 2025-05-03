package com.shh.dddlibrarydomain.availablebooks;

import com.shh.dddlibrarydomain.book.Book;
import com.shh.dddlibrarydomain.book.BookPutOnShelfEvent;
import com.shh.dddlibrarydomain.book.BookRepository;
import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibrarydomain.common.DomainEventListener;
import com.shh.dddlibrarydomain.lend.BookReturnedEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddToAvailablePolicy implements DomainEventListener {

  private final AddToAvailableCmdHandler addToAvailableCmdHandler;
  private final BookRepository bookRepository;

  @Override
  public void onDomainEvent(DomainEvent event) {
    if (event instanceof BookReturnedEvent bookReturnedEvent) {

      Book book = bookRepository.findByIdOrError(bookReturnedEvent.getBookId());
      AddToAvailableCmd cmd = new AddToAvailableCmd(book.getIsbn(), bookReturnedEvent.getBookId());
      addToAvailableCmdHandler.handle(cmd);

    } else if (event instanceof BookPutOnShelfEvent bookPutOnShelfEvent) {

      Book book = bookRepository.findByIdOrError(bookPutOnShelfEvent.getBookId());
      AddToAvailableCmd cmd =
          new AddToAvailableCmd(book.getIsbn(), bookPutOnShelfEvent.getBookId());
      addToAvailableCmdHandler.handle(cmd);
    }
  }
}
