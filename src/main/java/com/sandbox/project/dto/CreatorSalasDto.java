package com.sandbox.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
public class CreatorSalasDto {

    private String name;

    private int profit;

    private int total_profit;

    private List<SalesRequestDto> salesRequestDtos;

}
