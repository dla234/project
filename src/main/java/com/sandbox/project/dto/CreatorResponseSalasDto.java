package com.sandbox.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Builder
@ToString
@Getter
@Setter
public class CreatorResponseSalasDto {

    private Map<String,Integer> channel_profit;

}
