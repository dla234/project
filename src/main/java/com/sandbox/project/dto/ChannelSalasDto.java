package com.sandbox.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Builder
@ToString
@Getter
@Setter
public class ChannelSalasDto {

    private String channelID;
    private int date_group;
    private int profit;

    private List<Map<String,Integer>> creator_profit;
}
