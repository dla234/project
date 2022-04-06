package com.sandbox.project;

import com.sandbox.project.controller.CreatorController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class RestContollrtTest {

    private  MockMvc mockMvc;

    private final CreatorController creatorController;

    @BeforeEach
    @Sql({"classpath:data.sql"})
    public void setup_data(){
        mockMvc=MockMvcBuilders.standaloneSetup(creatorController).build();
        System.out.println("success all data save");
    }

    @Test
    @DisplayName("특정 크리에이터 정보 조회")
    public void getCreatorInfo() throws Exception{

        String url="/creator/creator1";

        mockMvc.perform(get(url))
                .andExpect(status().isOk());

    }
    
    @Test
    @DisplayName("특정 크리에이터 정보 입력")
    public void setCreatorInfo() throws Exception{

        MultiValueMap<String,String> info=new LinkedMultiValueMap<>();
        info.add("creatorID","creator21");
        info.add("name","test");

        String url="/creator/creator21";

        mockMvc.perform(post(url).params(info))
                .andExpect(status().isOk()).andDo(print());

    }

    @Test
    @DisplayName("channel1")
    public void geChannelSalesList() throws Exception{

        String url="/sales/channel1";

        mockMvc.perform(get(url))
                .andDo(print());

    }

}
