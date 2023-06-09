package com.festival.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festival.back.entity.FreeBoardEntity;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Integer> {
    
    public FreeBoardEntity findByBoardNumber(int boardNumber);
    public List<FreeBoardEntity> findByOrderByBoardWriteDatetimeDesc ();
    public List<FreeBoardEntity> findByBoardTitleContainsOrBoardContentContainsOrderByBoardWriteDatetimeDesc(String boardTitle,String boardContent);
    
}