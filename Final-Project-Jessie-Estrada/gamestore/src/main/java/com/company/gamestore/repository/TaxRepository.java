package com.company.gamestore.repository;


import com.company.gamestore.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {

    Optional<Tax> findByState(String stateCode);
}

