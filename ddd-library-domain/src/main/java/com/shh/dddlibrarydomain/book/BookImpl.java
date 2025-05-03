package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.ApplicationContextUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_book")
@NoArgsConstructor
public class BookImpl implements Book {
  @Id private String bookId;
  private String isbn;
  private boolean onShelf;

  public BookImpl(String bookId, String isbn, boolean onShelf) {
    this.bookId = bookId;
    this.isbn = isbn;
    this.onShelf = onShelf;
  }

  public String getBookId() {
    return bookId;
  }

  public String getIsbn() {
    return isbn;
  }

  @Override
  public void putOnShelf() {
    if (onShelf) {
      return;
    }
    this.onShelf = true;
    ApplicationContextUtil.eventPublisher().publish(new BookPutOnShelfEvent(bookId));
  }

  @Override
  public void takeOffShelf() {
    if (!onShelf) {
      return;
    }
    this.onShelf = false;
    ApplicationContextUtil.eventPublisher().publish(new BookTakenOffShelfEvent(bookId));
  }

  @Override
  public boolean isOnShelf() {
    return this.onShelf;
  }
}
