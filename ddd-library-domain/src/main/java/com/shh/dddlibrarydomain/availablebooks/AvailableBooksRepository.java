package com.shh.dddlibrarydomain.availablebooks;

public interface AvailableBooksRepository {

  AvailableBooks findById(String isbn);

  void save(AvailableBooks availableBooks);
}
