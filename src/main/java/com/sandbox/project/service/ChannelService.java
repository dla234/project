package com.sandbox.project.service;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.dto.ChannelDto;
import com.sandbox.project.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelDto getChannelInfo(String channelID){
        Channel channel=channelRepository.findByChannelID(channelID).get();
        return ChannelDto.from(channel);
    }

    @Transactional
    public ChannelDto setChannelInfo(ChannelDto channelDto){

        Channel channel=Channel.builder()
                .channelID(channelDto.getChannelID())
                .name(channelDto.getName())
                .build();

        return  ChannelDto.from(channelRepository.save(channel));
    }

}
