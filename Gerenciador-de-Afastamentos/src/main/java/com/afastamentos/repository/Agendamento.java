package com.afastamentos.repository;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
public abstract class Agendamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_agendamento")
    private Long idAgendamento;
   
    

}
