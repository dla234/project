package com.sandbox.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Channel_sales extends BaseTimeEntry{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salesID;

    private int profit;

    private LocalDateTime register_date;

    @ManyToOne
    @JoinColumn(name = "channelID", nullable = false)
    private Channel channel;


}
