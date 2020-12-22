package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();

    //List<Memo> findByStartDateBetween(LocalDateTime modifiedAt, LocalDateTime );

    @Query("select Memo from Memo a where a.modifiedAt between :toDay and :lastDay")
    List<Memo> findAllByOrderByModifiedAtDesc(@Param("toDay") LocalDateTime start, @Param("lastDay") LocalDateTime end);
}