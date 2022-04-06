package com.sandbox.project;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Creator;
import com.sandbox.project.domain.Share_contract;
import com.sandbox.project.repository.ChannelRepository;
import com.sandbox.project.repository.ContractRepository;
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
public class JpaTest_share_contract {

    LocalDateTime now = LocalDateTime.of(2020, 2, 1, 0, 0, 0);

    @Autowired
    ContractRepository shareContractRepository;

    @Autowired
    CreatorRepository creatorRepository;

    @Autowired
    ChannelRepository channelRepository;

    @BeforeEach
    @Sql({"classpath:data.sql"})
    public void setup_data(){
        System.out.println("success all data save");
    }

    @Test
    @DisplayName("계약 정보 생성 및 조회")
    public void create_share_contract(){
        
        String channelId="channel21";
        String channelName="테스트 채널";
        
        String creatorId="creator21";
        String name="테스트 계정";

        String contract="contract21";

        //given
        creatorRepository.save(Creator.builder().name(name).creatorID(creatorId).build());
        channelRepository.save(Channel.builder().channelID(channelId).name(channelName).build());
        //when
        Channel channel=channelRepository.findByChannelID(channelId).get();
        Creator creator=creatorRepository.findByCreatorID(creatorId).get();

        shareContractRepository.save(
                Share_contract.builder().
                creator(creator).
                channel(channel).
                profitrate(50).
                contractID(contract).build());

        //then
        List<Share_contract> shareContracts_list =shareContractRepository.findAll();

        System.out.println("shareContracts_list size");
        System.out.println(shareContracts_list.size());
        //then
        for(Share_contract shareContract:shareContracts_list){
            System.out.println("****************************");
            System.out.println("result check");
            System.out.println(shareContract.getCreator().getCreatorID());
            System.out.println(shareContract.getChannel().getName());
            System.out.println(shareContract.getProfitrate());
            System.out.println(shareContract.getCreate_date());
            System.out.println(shareContract.getModified_date());
            System.out.println(shareContract.getContractID());
            System.out.println("****************************");
        }

    }

    @Test
    @DisplayName("채널 기준 계약 정보 조회")
    public void getShareList(){

        //given
        String channelId="channel1";
        //when
        List<Share_contract> shareContracts_list =shareContractRepository.findByChannel_ChannelID(channelId);
//        List<Share_contract> shareContracts_list =shareContractRepository.findAll();

        System.out.println("shareContracts_list size");
        System.out.println(shareContracts_list.size());
        //then
        for(Share_contract shareContract:shareContracts_list){
            System.out.println("****************************");
            System.out.println("result check");
            System.out.println(shareContract.getCreator().getCreatorID());
            System.out.println(shareContract.getChannel().getChannelID());
            System.out.println(shareContract.getProfitrate());
            System.out.println(shareContract.getCreate_date());
            System.out.println(shareContract.getModified_date());
            System.out.println(shareContract.getContractID());
            System.out.println("****************************");
        }

    }

}
