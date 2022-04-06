package com.sandbox.project.dto;


import com.sandbox.project.domain.Creator;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatorDto {

    private String creatorID;

    private String name;

    public static CreatorDto from(Creator creator){
        if(null== creator)return null;

        return CreatorDto.builder()
                .creatorID(creator.getCreatorID())
                .name(creator.getName())
                .build();
    }
}
