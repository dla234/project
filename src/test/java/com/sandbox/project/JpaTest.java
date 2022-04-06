package com.sandbox.project;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Creator;
import com.sandbox.project.repository.ChannelRepository;
import com.sandbox.project.repository.CreatorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@Slf4j
@ExtendWith(SpringExtension.class)
@EnableJpaAuditing
@DataJpaTest
public class JpaTest {

    LocalDateTime now = LocalDateTime.of(2021, 2, 1, 0, 0, 0);

    /*
    1. 크레이터 조회
    2. 채널 조회
    3. 채널에 포함되는 크레이터 조회
    4. 크레이터가 속한 채널 조회
    5. 채널 기준 수익 조회 - 전체 크레이터 조회 - 오늘 부터 기본 30일 자료 조회
    6. 채널 기준 수익 조회 - 특정 크레이터 조회(다수 인원 대상)
    7. 크레이터 기준 결산 조회 - 전체 채널
    8. 크레이터 기준 결산 조회 - 특정 크레이터
    9. 날짜 기준 조회
     */

    @Autowired
    CreatorRepository creatorRepository;

    @Autowired
    ChannelRepository channelRepository;

//    @AfterEach
//    public void cleanUp(){
//        log.info("deleteAll");
//        creatorRepository.deleteAll();
//        channelRepository.deleteAll();
//    }

    @Test
    @DisplayName("크레이터 정보 생성 및 확인 테스트")
    public void getCreator(){

        //given
        String creatorId="creator10";
        String name="테스트계정";

        //when
        Creator creator=creatorRepository.save(Creator.builder().name(name).creatorID(creatorId).build());
        //then
        Assertions.assertEquals(name,creator.getName());
        Assertions.assertEquals(creatorId,creator.getCreatorID());
        Assertions.assertTrue(creator.getCreate_date().isAfter(now));
        Assertions.assertTrue(creator.getModified_date().isAfter(now));

    }
    
    @Test
    @DisplayName("채널 정보 생성 및 확인 테스트")
    public void getChannel(){

        //given
        String channelId="channel21";
        String channelName="테스트 채널";

        //when
        channelRepository.save(Channel.builder().channelID(channelId).name(channelName).build());
        Channel channel=channelRepository.findByChannelID(channelId).get();

        //then
        Assertions.assertEquals(channelId,channel.getChannelID());
        Assertions.assertEquals(channelName,channel.getName());
        Assertions.assertTrue(channel.getCreate_date().isAfter(now));
        Assertions.assertTrue(channel.getModified_date().isAfter(now));
    }



}
