package com.sandbox.project.controller;

import com.sandbox.project.dto.ChannelDto;
import com.sandbox.project.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @RequestMapping(value = "/{channelID}", method = RequestMethod.GET)
    public ResponseEntity<ChannelDto> getChannelInfo(@PathVariable String channelID){

        return ResponseEntity.ok(channelService.getChannelInfo(channelID));
    }

    @RequestMapping(value = "/{channelID}", method = RequestMethod.POST)
    public ResponseEntity<ChannelDto> setChannelInfo(@RequestBody ChannelDto channelDto){
        return ResponseEntity.ok(channelService.setChannelInfo(channelDto));
    }

}
