package com.afastamentos.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import com.afastamentos.repository.Agendamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="agendamentos_previo")
@Getter
@Setter
@DynamicUpdate
public class AgendamentoPrevio extends Agendamento{
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_afastamento")
    private TipoAfastamento tipoAfastamento;
    @Column(name="confirmado")  
    private boolean confirmado;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel idUser;
    
}
