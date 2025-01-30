package com.afastamentos.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {


    private Long idUser;
    @NotBlank
    private String userNameCompleto;
    @NotBlank
    private String userName;    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate userNascimento;    
    private boolean userType;
    
    

    
}
