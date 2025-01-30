package com.afastamentos.model;

import com.afastamentos.repository.Agendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="agendamentos_autorizados")
@Getter
@Setter
public class AgendamentoAutorizado extends Agendamento{

    @ManyToOne
    @JoinColumn(name = "id_agendamento_previo")
    private AgendamentoPrevio idAgendamentoPrevio;

}
