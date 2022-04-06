package com.sandbox.project.dto;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Channel_sales;
import lombok.*;

import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesResponseDto {

    private long salasID;

    private int salas_profit;

    private Channel channel;

    private LocalDateTime register_date;

    public static SalesResponseDto from(Channel_sales channel_sales){

        if(null == channel_sales) return null;

        return SalesResponseDto.builder()
                .channel(channel_sales.getChannel())
                .salasID(channel_sales.getSalesID())
                .salas_profit(channel_sales.getProfit())
                .register_date(channel_sales.getRegister_date())
                .build();

    }

}
