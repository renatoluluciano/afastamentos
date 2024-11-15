package com.afastamentos.dto;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate userNAscimento;
    @NotBlank
    private boolean userType = false;

    
}
