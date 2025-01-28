package com.afastamentos.controller;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.afastamentos.dto.AgendamentoDTO;
import com.afastamentos.service.AgendamentoPrevioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/preagendamento")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Transactional
public class AgendamentoPrevioController {

   AgendamentoPrevioService agendamentoPrevioService;

@PostMapping(value = "/novo/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AgendamentoDTO> novoAgendamento(@RequestBody @Valid AgendamentoDTO agendamentoDTO,  @PathVariable Long idUser,  
    UriComponentsBuilder uriBuilder){       

        AgendamentoDTO agendamento = agendamentoPrevioService.cadastrarAgendamentoPrevio(agendamentoDTO, idUser);

    if(agendamento != null){

        URI endereco = uriBuilder.path("/preagendamento/{id}").buildAndExpand(agendamento.getIdAgendamento()).toUri();

        return ResponseEntity.created(endereco).body(agendamento);
    }
        return ResponseEntity.internalServerError().build();
    

    }

}
