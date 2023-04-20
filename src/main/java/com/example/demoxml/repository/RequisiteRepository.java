package com.example.demoxml.repository;

import com.example.demoxml.model.entity.Requisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RequisiteRepository extends JpaRepository<Requisite, Long> {

    Optional<Requisite> findByAccount(Long account);
}
