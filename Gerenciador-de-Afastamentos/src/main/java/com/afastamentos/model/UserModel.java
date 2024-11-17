package com.afastamentos.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long idUser;
    @Column(name="user_name_completo")    
    private String userNameCompleto;
    @Column(name="user_name")  
    private String userName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="user_nascimento")  
    private LocalDate userNascimento;
    @Column(name="user_type")  
    private boolean userType;

}
