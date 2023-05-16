package com.festival.back.dto.response.freeboard;

import java.util.ArrayList;
import java.util.List;

import com.festival.back.entity.FreeBoardCommentEntity;
import com.festival.back.entity.FreeBoardEntity;
import com.festival.back.entity.FreeBoardRecommendEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFreeBoardResponseDto {
    @ApiModelProperty(value="게시물 Entity", required=true)
    private FreeBoardEntity freeBoard;

    @ApiModelProperty(value="댓글 Entity List", required=true)
    private List<FreeBoardCommentEntity> freeBoardCommentList;

    @ApiModelProperty(value="좋아요 Entity List", required=true)
    private List<FreeBoardRecommendEntity> freeBoardRecommendList;

    public PostFreeBoardResponseDto(FreeBoardEntity freeBoard){
        this.freeBoard = freeBoard;
        this.freeBoardRecommendList = new ArrayList<>();
        this.freeBoardCommentList=new ArrayList<>();
    }
}