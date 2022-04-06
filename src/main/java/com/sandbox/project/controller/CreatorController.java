package com.sandbox.project.controller;

import com.sandbox.project.dto.CreatorDto;
import com.sandbox.project.service.CreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creator")
@RequiredArgsConstructor
public class CreatorController {

    private final CreatorService creatorService;

    @RequestMapping(value = "/{creatorID}",method = RequestMethod.GET)
    public ResponseEntity<CreatorDto> getCreatorInfo(@PathVariable String creatorID){
        return ResponseEntity.ok(creatorService.getCreatorInfo(creatorID));
    }

    @RequestMapping(value = "/{creatorID}" , method = RequestMethod.POST)
    public ResponseEntity<CreatorDto> setCreatorInfo(@RequestBody CreatorDto creatorDto){
        return ResponseEntity.ok(creatorService.setCreatorInfo(creatorDto));
    }
}
