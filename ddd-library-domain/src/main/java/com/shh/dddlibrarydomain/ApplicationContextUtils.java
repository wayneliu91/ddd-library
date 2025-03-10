package com.shh.dddlibrarydomain;

import com.shh.dddlibrarydomain.availablebooks.AvailableBooksRepository;
import com.shh.dddlibrarydomain.book.BookRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

  private static ApplicationContext spring;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    ApplicationContextUtils.spring = context;
  }

  public static AvailableBooksRepository availableBooksRepository() {
    if (spring == null) {
      throw new IllegalStateException("Spring ApplicationContext is not initialized.");
    }
    return spring.getBean(AvailableBooksRepository.class);
  }

  public static BookRepository bookRepository() {
    if (spring == null) {
      throw new IllegalStateException("Spring ApplicationContext is not initialized.");
    }
    return spring.getBean(BookRepository.class);
  }

  public static DomainEventPublisher eventPublisher() {
    if (spring == null) {
      throw new IllegalStateException("Spring ApplicationContext is not initialized.");
    }
    return spring.getBean(DomainEventPublisher.class);
  }
}
