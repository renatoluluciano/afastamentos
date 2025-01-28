package com.afastamentos.repository;

import java.io.Serializable;
import java.time.LocalDate;



import com.afastamentos.model.TipoAfastamento;
import com.afastamentos.model.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Agendamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_agendamento")
    private Long idAgendamento;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_afastamento")
    private TipoAfastamento tipoAfastamento;
    

}
