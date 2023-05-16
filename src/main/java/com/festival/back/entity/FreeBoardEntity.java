package com.festival.back.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.festival.back.dto.request.freeboard.PostFreeBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Freeboard")
@Table(name = "Freeboard")
public class FreeBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int freeBoardNumber;
    private String freeBoardTitle;
    private String freeBoardContent;
    private String freeBoardImgUrl;
    private String freeBoardWriteDatetime;
    private int viewCount;
    private int recommendCount;
    private int commentCount;
    private String writerId;
    private String writerProfileUrl;
    private String writerNickname;
    
    public FreeBoardEntity(UserEntity userEntity, PostFreeBoardRequestDto postFreeBoardRequestDto){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.freeBoardTitle = postFreeBoardRequestDto.getFreeBoardTitle();
        this.freeBoardContent = postFreeBoardRequestDto.getFreeBoardContent();
        this.freeBoardImgUrl = postFreeBoardRequestDto.getFreeBoradImgUrl();
        this.freeBoardWriteDatetime = simpleDateFormat.format(now);
        this.writerId = userEntity.getUserId();
        this.writerProfileUrl = userEntity.getProfileUrl();
        this.writerNickname = userEntity.getNickname();
        this.viewCount = 0;
        this.recommendCount = 0;
        this.commentCount = 0;
    }
}
