package com.sandbox.project.repository;

import com.sandbox.project.dto.ChannelSalasDto;
import com.sandbox.project.dto.CreatorResponseSalasDto;
import com.sandbox.project.dto.TotalSalesDto;

import java.util.List;
import java.util.Map;

public interface ChannelSalesRepositoryCustom {
    List<ChannelSalasDto> findByChannel_ChannelID(String Channel,String yearMM);
    Map<String, CreatorResponseSalasDto> findByCreator_Sales(String creatorID,String yearMM);
    Map<Integer, List<TotalSalesDto>>findBySalesChannel(String yearMM);
}
