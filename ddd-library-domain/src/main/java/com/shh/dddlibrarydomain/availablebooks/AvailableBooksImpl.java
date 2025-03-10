package com.shh.dddlibrarydomain.availablebooks;

import com.shh.dddlibrarydomain.ApplicationContextUtils;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Random;
import java.util.Set;
import lombok.AllArgsConstructor;

@Entity(name = "AvailableBooks")
@Table(name = "t_available_books")
@AllArgsConstructor
public class AvailableBooksImpl implements AvailableBooks {

  @Id private String isbn;

  @ElementCollection private Set<String> bookIds;

  public AvailableBooksImpl() {}

  public AvailableBooksImpl(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public boolean containsBook(String bookId) {
    return bookIds.contains(bookId);
  }

  @Override
  public void add(String bookId) {
    if (bookIds.contains(bookId)) {
      return;
    }
    bookIds.add(bookId);
    ApplicationContextUtils.eventPublisher().publish(new BookAvailableEvent(isbn, bookId));
  }

  @Override
  public void remove(String bookId) {
    if (!bookIds.contains(bookId)) {
      return;
    }
    bookIds.remove(bookId);
    ApplicationContextUtils.eventPublisher().publish(new BookUnavailableEvent(isbn, bookId));
  }

  @Override
  public boolean isEmpty() {
    return bookIds.isEmpty();
  }

  @Override
  public String chooseBookRandomly() {
    if (bookIds.isEmpty()) {
      throw new IllegalStateException("No books available to choose from.");
    }
    int randomIndex = new Random().nextInt(bookIds.size());
    int currentIndex = 0;
    for (String bookId : bookIds) {
      if (currentIndex == randomIndex) {
        return bookId;
      }
      currentIndex++;
    }
    // This line should never be reached.
    throw new AssertionError("Failed to choose a random book.");
  }
}
