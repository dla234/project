package com.sandbox.project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShareContractRequestDto {

    private String contractID;

    private String channelID;

    private String creatorID;

    private double profitrate;

}
