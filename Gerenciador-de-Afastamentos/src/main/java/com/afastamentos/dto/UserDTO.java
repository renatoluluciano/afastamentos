package com.afastamentos.dto;

import com.afastamentos.model.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {


    private Long idUser;
    @NotBlank
    private String userName;
    private boolean userType;

    
}
