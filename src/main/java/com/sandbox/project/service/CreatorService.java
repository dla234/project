package com.sandbox.project.service;

import com.sandbox.project.domain.Creator;
import com.sandbox.project.dto.CreatorDto;
import com.sandbox.project.repository.CreatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreatorService {

    private final CreatorRepository creatorRepository;

    public CreatorDto getCreatorInfo(String creatorID){
        Creator creator= creatorRepository.findByCreatorID(creatorID).get();
        return CreatorDto.from(creator);
    }

    @Transactional
    public CreatorDto setCreatorInfo(CreatorDto creatorDto){

        Creator creator=Creator.builder()
                        .creatorID(creatorDto.getCreatorID())
                                .name(creatorDto.getName())
                                        .build();

        return CreatorDto.from(creatorRepository.save(creator) );
    }

}
