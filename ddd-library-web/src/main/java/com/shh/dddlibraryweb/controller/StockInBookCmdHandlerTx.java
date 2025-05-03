package com.shh.dddlibraryweb.controller;

import com.shh.dddlibrarydomain.book.DuplicateBookIdException;
import com.shh.dddlibrarydomain.book.StockInBookCmd;
import com.shh.dddlibrarydomain.book.StockInBookCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StockInBookCmdHandlerTx {
  private final StockInBookCmdHandler stockInBookCmdHandler;

  @Transactional
  public void handle(StockInBookCmd cmd) throws DuplicateBookIdException {
    stockInBookCmdHandler.handle(cmd);
  }
}
