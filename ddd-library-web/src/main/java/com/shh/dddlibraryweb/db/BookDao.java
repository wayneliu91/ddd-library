package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, String> {}
