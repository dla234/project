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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Creator extends BaseTimeEntry{

    @Id
    private String creatorID;

    private String name;

    @OneToMany
    private List<Share_contract> creatorContract;


}
