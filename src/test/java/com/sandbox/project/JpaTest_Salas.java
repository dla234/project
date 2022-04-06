package com.sandbox.project;

import com.sandbox.project.domain.Channel_sales;
import com.sandbox.project.repository.ChannelRepository;
import com.sandbox.project.repository.ChannelSalesRepository;
import com.sandbox.project.repository.CreatorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@EnableJpaAuditing
@DataJpaTest
public class JpaTest_Salas {

    LocalDateTime now = LocalDateTime.of(2020, 2, 1, 0, 0, 0);

    /*
    1.채널 수익 전체 조회
    2.채널 수익 합계
    3.크리에이터 정산 기록 조회
    4.1년 단위로 정산 기록 조회
    5. 몰라
     */



    @Autowired
    CreatorRepository creatorRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ChannelSalesRepository channelSalesRepository;

    @BeforeEach
    @Sql({"classpath:data.sql"})
    public void setup_data(){
        System.out.println("success all data save");
    }

    @Test
    @DisplayName("채널 수익 전체 조회")
    public void getAllSalasList(){

        //given

        //when
        List<Channel_sales> channel_sales_list=channelSalesRepository.findAll();
        //then
        for(Channel_sales channel_sales:channel_sales_list){
            System.out.println("***************************");
            System.out.println(channel_sales.getSalesID());
            System.out.println(channel_sales.getChannel().getName());
            System.out.println(channel_sales.getProfit());
            System.out.println(channel_sales.getCreate_date());
            System.out.println("***************************");
        }

    }

    @Test
    @DisplayName("특정 채널 수익 조회")
    public void getSalas(){

        //given
        String channelID="channel1";
        //when
        List<Channel_sales> channel_sales_list=channelSalesRepository.findByChannel_ChannelID(channelID).get();
        //then
        for(Channel_sales channel_sales:channel_sales_list){
            System.out.println("***************************");
            System.out.println(channel_sales.getSalesID());
            System.out.println(channel_sales.getChannel().getName());
            System.out.println(channel_sales.getProfit());
            System.out.println(channel_sales.getCreate_date());
            System.out.println("***************************");
        }

    }


}
