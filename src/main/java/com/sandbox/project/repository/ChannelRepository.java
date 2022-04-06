package com.sandbox.project.repository;


import com.sandbox.project.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {

    Optional<Channel> findByChannelID(String id);
}
