package com.sandbox.project.dto;

import lombok.*;

import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesRequestDto {

//    private long salasID;

    private int salas_profit;

    private String channelID;

    private LocalDateTime register_date;

}
