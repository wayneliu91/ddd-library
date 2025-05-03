package com.shh.dddlibrarydomain.user;

// 定义 User 接口
public interface User {
  // 增加逾期次数的方法
  void increaseOverdueTimes();

  // 启用用户的方法
  void enable();

  // 获取用户是否被暂停的状态
  boolean isSuspended();
}
