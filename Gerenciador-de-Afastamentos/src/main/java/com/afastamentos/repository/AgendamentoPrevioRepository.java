package com.afastamentos.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.afastamentos.model.AgendamentoPrevio;
import java.util.List;
import java.time.LocalDate;


@Repository
public interface AgendamentoPrevioRepository extends JpaRepository<AgendamentoPrevio, Long> {

    List<AgendamentoPrevio> findByDataAgendamento(LocalDate dataAgendamento);


}


