package com.sandbox.project.repository;

import com.sandbox.project.domain.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {

    Optional<Creator> findByCreatorID(String creatorId);
}
