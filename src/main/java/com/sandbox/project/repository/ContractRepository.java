package com.sandbox.project.repository;

import com.sandbox.project.domain.Share_contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Share_contract,Long> {

    Optional<Share_contract> findByContractID(String ContractID);

    ArrayList<Share_contract> findByChannel_ChannelID(String channelId);

    ArrayList<Share_contract> findByCreatorCreatorID(String creatorID);

}
