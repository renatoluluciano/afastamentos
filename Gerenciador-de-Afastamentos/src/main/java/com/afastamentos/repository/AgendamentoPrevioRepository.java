package com.afastamentos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.afastamentos.model.AgendamentoPrevio;

@Repository
public interface AgendamentoPrevioRepository extends JpaRepository<AgendamentoPrevio, Long> {

    



}
