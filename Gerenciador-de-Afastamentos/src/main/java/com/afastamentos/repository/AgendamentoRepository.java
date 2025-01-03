package com.afastamentos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.afastamentos.model.AgendamentoModel;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

    @Query(value = "SELECT * FROM agendamentos where data_agendamento = :dataAgendada", nativeQuery = true)
    List<AgendamentoModel> findByDate(LocalDate dataAgendada);



}
