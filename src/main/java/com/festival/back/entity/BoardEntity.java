package com.festival.back.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.festival.back.dto.request.PostReviewBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Board")
@Table(name = "Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImgUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private int recommendCount;
    private int commentCount;
    private String writerId;
    private String writerProfileUrl;
    private String writerNickname;
    private int festivalNumber;
    
    public BoardEntity(UserEntity userEntity,PostReviewBoardRequestDto reviewBoardRquestDto,FestivalEntity festivalEntity){
        Date  now= new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.boardTitle=reviewBoardRquestDto.getBoardTitle();
        this.boardContent=reviewBoardRquestDto.getBoardContent();
        this.boardImgUrl=reviewBoardRquestDto.getBoradImgUrl();
        this.boardWriteDatetime=simpleDateFormat.format(now);
        this.writerId=userEntity.getUserId();
        this.writerProfileUrl=userEntity.getProfileUrl();
        this.writerNickname=userEntity.getNickname();
        this.festivalNumber=festivalEntity.getFestivalNumber();
        this.viewCount=0;
        this.recommendCount=0;
        this.commentCount=0;



    }


    
}
