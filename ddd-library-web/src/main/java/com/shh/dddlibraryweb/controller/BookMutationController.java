package com.shh.dddlibraryweb.controller;

import com.shh.dddlibrarydomain.book.*;
import lombok.AllArgsConstructor;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/book")
@RestController
@AllArgsConstructor
public class BookMutationController {

  private final StockInBookCmdHandlerTx stockInBookCmdHandlerTx;

  private final PutOnShelfCmdHandler putOnShelfCmdHandler;
  private final TakeOffShelfCmdHandler takeOffShelfCmdHandler;

  private final TransactionTemplate transactionTemplate;

  @PostMapping("/")
  public String stockInBook(@RequestParam("book") BookForm bookForm)
      throws DuplicateBookIdException {
    StockInBookCmd cmd =
        new StockInBookCmd(
            bookForm.getBookId(),
            bookForm.getIsbn(),
            bookForm.getName(),
            bookForm.getPicture(),
            bookForm.getDescription());
    stockInBookCmdHandlerTx.handle(cmd);
    return "OK";
  }

  @GetMapping
  public String putOnShelf(@RequestParam("bookId") String bookId) {
    transactionTemplate.execute(
        _ -> {
          putOnShelfCmdHandler.handle(new PutOnShelfCmd(bookId));
          return null;
        });
    return "OK";
  }

  @GetMapping
  public String takeOffShelf(@RequestParam("bookId") String bookId) {
    transactionTemplate.execute(
        _ -> {
          takeOffShelfCmdHandler.handle(new TakeOffShelfCmd(bookId));
          return null;
        });
    return "OK";
  }
}
