package com.sandbox.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class TotalSalesDto {

    private int sum;
    private int profit_sum;
    private String channelID;
}
