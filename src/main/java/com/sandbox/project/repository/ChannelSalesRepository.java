package com.sandbox.project.repository;

import com.sandbox.project.domain.Channel_sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelSalesRepository extends JpaRepository<Channel_sales,Long>{

    Optional<List<Channel_sales>> findByChannel_ChannelID(String channelID);
}
