package com.afastamentos.model;

import com.afastamentos.repository.Agendamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="agendamentos_previo")
@Getter
@Setter
public class AgendamentoPrevio extends Agendamento{
    @Column(name="confirmado")  
    private boolean confirmado;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel idUser;
    
}
