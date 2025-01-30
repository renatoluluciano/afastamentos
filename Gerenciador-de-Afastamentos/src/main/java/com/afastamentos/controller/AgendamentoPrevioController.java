package com.afastamentos.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.afastamentos.dto.AgendamentoDTO;

import com.afastamentos.model.AgendamentoPrevio;
import com.afastamentos.service.AgendamentoPrevioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

@GetMapping("/{date}")
public ResponseEntity<List<AgendamentoPrevio>> buscarPorData(@PathVariable @NotNull LocalDate date){

       List<AgendamentoPrevio> agendamentoDTO = agendamentoPrevioService.bucarAgendamentoPrevioData(date);

        return ResponseEntity.ok(agendamentoDTO);

    }
    
@PutMapping("/alterar/{id}")
public ResponseEntity<AgendamentoDTO> alterarPreAgendamento(@PathVariable @NotNull Long id, @RequestBody @Valid AgendamentoDTO agendamentoDTO) {
        
        AgendamentoDTO agendamentoAtual = agendamentoPrevioService.alterarAgendamento(id, agendamentoDTO);
        
        
        return ResponseEntity.ok(agendamentoAtual);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirPreAgendamento(@PathVariable Long id) {
        
        agendamentoPrevioService.excluirPreAgendamento(id);
        
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
