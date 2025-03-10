package com.shh.dddlibrarydomain.book;

public interface BookRepository {
  /**
   * 根据书籍 ID 查找书籍，如果未找到则抛出异常
   *
   * @param bookId 书籍 ID
   * @return 找到的书籍对象
   */
  Book findByIdOrError(String bookId);

  /**
   * 根据书籍 ID 查找书籍，可能返回 null
   *
   * @param bookId 书籍 ID
   * @return 找到的书籍对象，如果未找到则返回 null
   */
  Book findByBookId(String bookId);

  /**
   * 保存书籍对象
   *
   * @param book 要保存的书籍对象
   */
  void save(Book book);
}
