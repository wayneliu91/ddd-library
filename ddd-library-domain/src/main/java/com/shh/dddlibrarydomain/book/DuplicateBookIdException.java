package com.shh.dddlibrarydomain.book;

import com.shh.dddlibrarydomain.common.DomainException;

public class DuplicateBookIdException extends DomainException {
  public DuplicateBookIdException() {
    super("书名重复了");
  }
}
