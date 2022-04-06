package com.sandbox.project.dto;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Creator;
import com.sandbox.project.domain.Share_contract;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShareContractResponseDto {

    private String contractID;

    private Channel channel;

    private Creator creator;

    private double profitrate;

    public static ShareContractResponseDto from(Share_contract shareContract){
        if(null == shareContract) return null;

        return ShareContractResponseDto.builder()
                .contractID(shareContract.getContractID())
                .channel(shareContract.getChannel())
                .creator(shareContract.getCreator())
                .profitrate(shareContract.getProfitrate())
                .build();
    }

}
