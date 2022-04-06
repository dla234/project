package com.sandbox.project.dto;

import com.sandbox.project.domain.Channel;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto {

    private String channelID;

    private String name;

    public static ChannelDto from(Channel channel){
        if(null == channel) return null;

        return ChannelDto.builder()
                .channelID(channel.getChannelID())
                .name(channel.getName())
                .build();
    }

}
