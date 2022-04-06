package com.sandbox.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Channel extends BaseTimeEntry{

    @Id
    private String channelID;

    private String name;

    @OneToMany
    private List<Share_contract> channelContract;

    @OneToMany
    private List<Channel_sales> channel_sales;

}
