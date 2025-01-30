package com.afastamentos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afastamentos.dto.AgendamentoDTO;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/agendamentos")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Transactional
public class AgendamentoAutorizadoController {

    @PostMapping("/confirm")
    public ResponseEntity<AgendamentoDTO> confirmarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        
        
        return null;
    }
    

}
