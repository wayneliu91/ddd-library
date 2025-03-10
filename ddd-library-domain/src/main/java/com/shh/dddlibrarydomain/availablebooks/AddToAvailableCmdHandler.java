package com.shh.dddlibrarydomain.availablebooks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddToAvailableCmdHandler {

  private final AvailableBooksRepository availableBooksRepository;

  /** 处理 AddToAvailableCmd 命令的方法 */
  public void handle(AddToAvailableCmd cmd) {
    // 根据命令中的 ISBN 从仓库中查找可用书籍
    AvailableBooks availableBooks = availableBooksRepository.findById(cmd.getIsbn());
    // 向可用书籍中添加指定 ID 的书籍
    availableBooks.add(cmd.getBookId());
    // 将更新后的可用书籍保存到仓库中
    availableBooksRepository.save(availableBooks);
  }
}
