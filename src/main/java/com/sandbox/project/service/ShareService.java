package com.sandbox.project.service;

import com.sandbox.project.domain.Channel;
import com.sandbox.project.domain.Creator;
import com.sandbox.project.domain.Share_contract;
import com.sandbox.project.dto.ShareContractRequestDto;
import com.sandbox.project.dto.ShareContractResponseDto;
import com.sandbox.project.repository.ChannelRepository;
import com.sandbox.project.repository.ContractRepository;
import com.sandbox.project.repository.CreatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ShareService {


    private final ContractRepository contractRepository;

    private final ChannelRepository channelRepository;

    private final CreatorRepository creatorRepository;


    @Transactional
    public ShareContractResponseDto setShareContractInfo(ShareContractRequestDto shareContractRequestDto){

        Channel channel=channelRepository.findByChannelID(shareContractRequestDto.getChannelID()).get();

        Creator creator=creatorRepository.findByCreatorID(shareContractRequestDto.getCreatorID()).get();

        Share_contract shareContract=Share_contract.builder()
                        .contractID(shareContractRequestDto.getContractID())
                                .profitrate(shareContractRequestDto.getProfitrate())
                                        .channel(channel).creator(creator).build();

        return ShareContractResponseDto.from(contractRepository.save(shareContract));

    }

    public ShareContractResponseDto getShareContractInfo(String contractID){
        Share_contract shareContract=contractRepository.findByContractID(contractID).get();
        return ShareContractResponseDto.from(shareContract);
    }

}
