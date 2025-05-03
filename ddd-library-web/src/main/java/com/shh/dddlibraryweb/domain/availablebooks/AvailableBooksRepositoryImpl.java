package com.shh.dddlibraryweb.domain.availablebooks;

import com.shh.dddlibrarydomain.availablebooks.AvailableBooks;
import com.shh.dddlibrarydomain.availablebooks.AvailableBooksImpl;
import com.shh.dddlibrarydomain.availablebooks.AvailableBooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AvailableBooksRepositoryImpl implements AvailableBooksRepository {

  private final AvailableBooksRepository availableBooksRepository;

  @Override
  public AvailableBooks findById(String isbn) {
    AvailableBooks availableBooks = availableBooksRepository.findById(isbn);
    if (availableBooks == null) {
      return new AvailableBooksImpl(isbn);
    } else {
      return availableBooks;
    }
  }

  @Override
  public void save(AvailableBooks availableBooks) {
    if (!(availableBooks instanceof AvailableBooksImpl)) {
      throw new IllegalArgumentException();
    }
    availableBooksRepository.save(availableBooks);
  }
}
