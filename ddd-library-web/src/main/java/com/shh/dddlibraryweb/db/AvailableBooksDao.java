package com.shh.dddlibraryweb.db;

import com.shh.dddlibrarydomain.availablebooks.AvailableBooksImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableBooksDao extends JpaRepository<AvailableBooksImpl, String> {}
