package com.festival.back.dto.response.board;

import java.util.List;

import com.festival.back.entity.BoardEntity;
import com.festival.back.entity.CommentEntity;
import com.festival.back.entity.RecommendEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="특정 댓글 삭제 Response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCommentResponseDto {
    @ApiModelProperty(value="게시물 Entity", required=true)
    private BoardEntity board;

    @ApiModelProperty(value="추천 EntityList", required=true)
    private List<RecommendEntity> recommendList;

    @ApiModelProperty(value="댓글 EntityList", required=true)
    private List<CommentEntity> commentList;
}