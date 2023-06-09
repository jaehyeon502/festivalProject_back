package com.festival.back.dto.response.auth;

import java.util.ArrayList;
import java.util.List;

import com.festival.back.entity.InterestedFestivalEntity;
import com.festival.back.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="로그인 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {

    @ApiModelProperty(value="사용자 아이디", example="qwer1234", required=true)
    private String userId;

    @ApiModelProperty(value="사용자 닉네임", example="홍길동", required=true)
    private String nickname;

    @ApiModelProperty(value="사용자 프로필 사진 URL", example="http://~", required=true)
    private String profileUrl;

    @ApiModelProperty(value="사용자 휴대전화번호", example="010-1234-5678", required=true)
    private String telNumber;

    @ApiModelProperty(value="JWT", example="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxd2VAcXdlLmNvbSIsImlhdCI6MTY3OTU1MDM0MiwiZXhwIjoxNjc5NTUzOTQyfQ.Cvdm7jpRfAKdst99Elo35yW-XLygzI2kMBz5VfwtJf0", required=true)
    private String token;

    @ApiModelProperty(value="토큰 만료 기간", example="3600000", required=true)
    private int expiredTime;
    
    private List<String> interestedFestival;

    public SignInResponseDto(UserEntity userEntity, List<InterestedFestivalEntity> interestedFestivalEntity , String token) {
    //? 새로운 리스트 생성
        List<String> interestedFestivalList = new ArrayList<>();
        for (InterestedFestivalEntity interestedFestivalEntityList : interestedFestivalEntity) {
            String dto = interestedFestivalEntityList.getInterestedFestivalType();
            interestedFestivalList.add(dto);
        }
        
        this.userId = userEntity.getUserId();
        this.nickname = userEntity.getNickname();
        this.profileUrl = userEntity.getProfileUrl();
        this.telNumber = userEntity.getTelNumber();
        this.token = token;
        this.expiredTime = 14400000;
        this.interestedFestival = interestedFestivalList;
    }
}
