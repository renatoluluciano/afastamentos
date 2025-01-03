package com.afastamentos.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="agendamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id_agendamento")
    private Long idAgendamento;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="data_agendamento")
    private LocalDate dataAgendamento;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_afastamento")
    private TipoAfastamento tipoAfastamento;
    @ManyToOne
    @JoinColumn(name="id_user")    
    private UserModel idUser;

   

}
