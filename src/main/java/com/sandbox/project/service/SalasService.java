package com.sandbox.project.service;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Channel_sales;
import com.sandbox.project.dto.*;
import com.sandbox.project.repository.ChannelRepository;
import com.sandbox.project.repository.ChannelSalesRepository;
import com.sandbox.project.repository.ChannelSalesRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SalasService {

    private final ChannelSalesRepository channelSalesRepository;

    private final ChannelRepository channelRepository;

    private final ChannelSalesRepositoryImpl channelSalesRepositoryCustom;

    @Transactional
    public SalesResponseDto setChannelSalasInfo(String channelID,SalesRequestDto salesRequestDto){

        Channel channel=channelRepository.findByChannelID(channelID).get();

        Channel_sales channel_sales=Channel_sales.builder()
                        .channel(channel).profit(salesRequestDto.getSalas_profit()).build();
        return SalesResponseDto.from(channelSalesRepository.save(channel_sales));
    }

    public SalesResponseDto getChannelSalasInfo(long salesID){
        return SalesResponseDto.from(channelSalesRepository.getById(salesID));
    }

    public List<ChannelSalasDto> getChannelSalesList(String channelID,String yearMM){
        return channelSalesRepositoryCustom.findByChannel_ChannelID(channelID,yearMM);
    }

    public Map<String,CreatorResponseSalasDto> getCreatorSalesMap(String creatorID,String yearMM){
        return channelSalesRepositoryCustom.findByCreator_Sales(creatorID,yearMM);
    }

    public Map<Integer, List<TotalSalesDto>> getTotalSalesMap(String yearMM){
        return channelSalesRepositoryCustom.findBySalesChannel(yearMM);
    }

}
