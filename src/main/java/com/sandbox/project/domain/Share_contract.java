package com.sandbox.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Share_contract extends BaseTimeEntry{

    @Id
    private String contractID;

    @ManyToOne
    @JoinColumn(name = "creatorID" , nullable = false)
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "channelID", nullable = false)
    private Channel channel;

    private double profitrate;

}
