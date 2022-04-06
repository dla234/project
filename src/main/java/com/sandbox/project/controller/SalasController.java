package com.sandbox.project.controller;

import com.sandbox.project.dto.*;
import com.sandbox.project.service.SalasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalasController {

    private final SalasService salasService;

    @RequestMapping(value = "/{channelID}", method = RequestMethod.POST)
    public ResponseEntity<SalesResponseDto> setSalasInfo(@PathVariable String channelID,@RequestBody SalesRequestDto salesRequestDto){
        return ResponseEntity.ok(salasService.setChannelSalasInfo(channelID,salesRequestDto));
    }

    @RequestMapping(value = "/{salasID}", method = RequestMethod.GET)
    public ResponseEntity<SalesResponseDto> getSalasInfo(@PathVariable long salasID){
        return ResponseEntity.ok(salasService.getChannelSalasInfo(salasID));
    }

    @RequestMapping(value = "/{channelID}/list/{yearMM}",method = RequestMethod.GET)
    public ResponseEntity<List<ChannelSalasDto>> getChannelSalesList(
            @PathVariable String channelID,
            @PathVariable String yearMM){
        return ResponseEntity.ok(salasService.getChannelSalesList(channelID,yearMM));
    }
    @RequestMapping(value = "/{channelID}/list",method = RequestMethod.GET)
    public ResponseEntity<List<ChannelSalasDto>> getChannelSalesList(@PathVariable String channelID){
        return ResponseEntity.ok(salasService.getChannelSalesList(channelID,null));
    }
    @RequestMapping(value = "/{creatorID}/map",method = RequestMethod.GET)
    public ResponseEntity<Map<String, CreatorResponseSalasDto>> getCreatorSalesMap(@PathVariable String creatorID){
        return ResponseEntity.ok(salasService.getCreatorSalesMap(creatorID,null));
    }

    @RequestMapping(value = "/{creatorID}/map/{yearMM}",method = RequestMethod.GET)
    public ResponseEntity<Map<String, CreatorResponseSalasDto>> getCreatorSalesMap(
            @PathVariable String creatorID,
            @PathVariable String yearMM){
        return ResponseEntity.ok(salasService.getCreatorSalesMap(creatorID,yearMM));
    }

    @RequestMapping(value = "/total/{yearMM}",method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, List<TotalSalesDto>>> getTotalSalesMap(@PathVariable String yearMM){
        return ResponseEntity.ok(salasService.getTotalSalesMap(yearMM));
    }

    @RequestMapping(value = "/total",method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, List<TotalSalesDto>>> getTotalSalesMap(){
        return ResponseEntity.ok(salasService.getTotalSalesMap(null));
    }
}
