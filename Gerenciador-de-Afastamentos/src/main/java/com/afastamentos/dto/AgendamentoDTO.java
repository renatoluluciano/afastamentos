package com.afastamentos.dto;

import java.time.LocalDate;

import com.afastamentos.model.TipoAfastamento;
import com.afastamentos.model.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoDTO {
    
    private Long idAgendamento;
    @JsonFormat(pattern="yyyy-MM-dd")    
    private LocalDate dataAgendamento;
    @Enumerated(EnumType.STRING)    
    private TipoAfastamento tipoAfastamento;
    private boolean confirmado;
    private UserDTO idUser;
    
    
}
