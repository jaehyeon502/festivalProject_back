package com.festival.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festival.back.entity.FreeBoardCommentEntity;

@Repository
public interface FreeBoardCommentRepository extends JpaRepository <FreeBoardCommentEntity, Integer> {
    
}
