package com.shh.dddlibraryweb.domain.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.dddlibrarydomain.book.Book;
import com.shh.dddlibrarydomain.book.BookStockedInEvent;
import com.shh.dddlibrarydomain.common.DomainEvent;
import com.shh.dddlibraryweb.db.EventRecord;
import com.shh.dddlibraryweb.db.EventRecordDao;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventStoreListener {

  private final EventRecordDao eventRecordDao;
  private final ObjectMapper objectMapper;

  @EventListener
  public void onDomainEvent(DomainEvent domainEvent) throws JsonProcessingException {
    if (domainEvent instanceof BookStockedInEvent) {

      EventRecord eventRecord =
          new EventRecord()
              .setEventType(BookStockedInEvent.class.getName())
              .setAggregateType(Book.class.getName())
              .setAggregateId(((BookStockedInEvent) domainEvent).getBookId())
              .setContent(objectMapper.writeValueAsString(domainEvent));
      eventRecordDao.save(eventRecord);
    }
  }
}
