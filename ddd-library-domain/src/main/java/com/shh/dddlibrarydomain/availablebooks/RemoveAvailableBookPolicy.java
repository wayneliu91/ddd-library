package com.shh.dddlibrarydomain.availablebooks;

import com.shh.dddlibrarydomain.DomainEvent;
import com.shh.dddlibrarydomain.DomainEventListener;
import com.shh.dddlibrarydomain.book.Book;
import com.shh.dddlibrarydomain.book.BookRepository;
import com.shh.dddlibrarydomain.book.BookTakenOffShelfEvent;
import com.shh.dddlibrarydomain.lend.BookLentOutEvent;
import com.shh.dddlibrarydomain.reservation.BookReservedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveAvailableBookPolicy implements DomainEventListener {

  private BookRepository bookRepository;
  private RemoveFromAvailableCmdHandler removeFromAvailableCmdHandler;

  @EventListener(classes = BookTakenOffShelfEvent.class)
  @Override
  public void onDomainEvent(DomainEvent event) {
    if (event instanceof BookReservedEvent) {
      removeFromAvailableBooks(((BookReservedEvent) event).getBookId());
    } else if (event instanceof BookTakenOffShelfEvent) {
      removeFromAvailableBooks(((BookTakenOffShelfEvent) event).getBookId());
    } else if (event instanceof BookLentOutEvent) {
      removeFromAvailableBooks(((BookLentOutEvent) event).getBookId());
    }
  }

  private void removeFromAvailableBooks(String bookId) {
    Book book = bookRepository.findByIdOrError(bookId);
    RemoveFromAvailableCmd cmd = new RemoveFromAvailableCmd(book.getIsbn(), bookId);
    removeFromAvailableCmdHandler.handle(cmd);
  }
}
