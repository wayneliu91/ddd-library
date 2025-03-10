package com.shh.dddlibrarydomain.book;

// 定义 Book 接口
public interface Book {
    // 定义将书籍放在书架上的方法
    void putOnShelf();

    // 定义将书籍从书架上取下的方法
    void takeOffShelf();

    // 定义检查书籍是否在书架上的方法
    boolean isOnShelf();

    // 定义获取书籍 ISBN 的方法
    String getIsbn();
}