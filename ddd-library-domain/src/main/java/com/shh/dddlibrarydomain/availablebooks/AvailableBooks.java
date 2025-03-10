package com.shh.dddlibrarydomain.availablebooks;

public interface AvailableBooks {
  // 检查是否包含指定 ID 的书籍
  boolean containsBook(String bookId);

  // 向可用书籍列表中添加一本指定 ID 的书籍
  void add(String bookId);

  // 从可用书籍列表中移除一本指定 ID 的书籍
  void remove(String bookId);

  // 检查可用书籍列表是否为空
  boolean isEmpty();

  // 随机选择一本可用书籍并返回其 ID
  String chooseBookRandomly();
}
