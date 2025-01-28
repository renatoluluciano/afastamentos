package com.afastamentos.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.afastamentos.dto.AgendamentoDTO;
import com.afastamentos.model.AgendamentoModel;
import com.afastamentos.service.AgendamentoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/agendamentos")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Transactional

public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping(value = "/novoagendamento/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgendamentoDTO> novoAgendamento(@RequestBody @Valid AgendamentoDTO agendamentoDTO,  @PathVariable Long idUser,  
    UriComponentsBuilder uriBuilder){       

    AgendamentoDTO agendamento = agendamentoService.cadastrarAgendamento(agendamentoDTO, idUser);

    if(agendamento != null){

        URI endereco = uriBuilder.path("/agendamentos/{id}").buildAndExpand(agendamento.getIdAgendamento()).toUri();

        return ResponseEntity.created(endereco).body(agendamento);
    }

    return ResponseEntity.internalServerError().build();

    }
    
    
    @GetMapping
    public ResponseEntity<Page<AgendamentoDTO>> listarAgendamentos(@PageableDefault(size = 10) Pageable paginacao){

        Page<AgendamentoDTO> agendamentoDTO = agendamentoService.listarAgendamentos(paginacao);

        return ResponseEntity.ok(agendamentoDTO);
        
    }
    
    @GetMapping("/{date}")
    public ResponseEntity<List<AgendamentoModel>> buscarPorData(@PathVariable @NotNull LocalDate date){

       List<AgendamentoModel> agendamentoDTO = agendamentoService.bucarPorData(date);

        return ResponseEntity.ok(agendamentoDTO);

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<AgendamentoDTO> alterarAgendamento(@PathVariable Long id, @RequestBody @Valid AgendamentoDTO agendamentoDTO) {
        
        AgendamentoDTO agendamentoAtual = agendamentoService.alterarAgendamento(id, agendamentoDTO);
        
        return ResponseEntity.ok(agendamentoAtual);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<AgendamentoDTO> deletarAgendamento(@PathVariable @NotNull Long id){

        agendamentoService.excluirAgendamento(id);

        return ResponseEntity.noContent().build();
    }



    
}
