package com.afastamentos.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.afastamentos.dto.AgendamentoDTO;
import com.afastamentos.dto.UserDTO;
import com.afastamentos.model.AgendamentoModel;
import com.afastamentos.model.AgendamentoPrevio;
import com.afastamentos.model.UserModel;
import com.afastamentos.repository.AgendamentoPrevioRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendamentoPrevioService {

    private final AgendamentoPrevioRepository agendamentoPrevioRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public AgendamentoDTO cadastrarAgendamentoPrevio(AgendamentoDTO agendamentoDTO, Long id){

        UserDTO usuario = userService.listarPorId(id);

        UserModel usuarioModel = modelMapper.map(usuario, UserModel.class);

        AgendamentoPrevio agendamentoPrevio = modelMapper.map(agendamentoDTO, AgendamentoPrevio.class);
        agendamentoPrevio.setIdUser(usuarioModel); 

        agendamentoPrevioRepository.save(agendamentoPrevio);

        return modelMapper.map(agendamentoPrevio, AgendamentoDTO.class);
    }

    public List<AgendamentoPrevio> bucarAgendamentoPrevioData(LocalDate date) {

        List<AgendamentoPrevio> agendamento = agendamentoPrevioRepository.findByDataAgendamento(date);
        

        return agendamento;

    }

    public AgendamentoDTO alterarAgendamento(Long id, AgendamentoDTO agendamentoDTO) {

        AgendamentoPrevio agendamento = modelMapper.map(agendamentoDTO, AgendamentoPrevio.class);

        agendamento.setIdAgendamento(id);

        
        agendamento = agendamentoPrevioRepository.save(agendamento);     

        return modelMapper.map(agendamento, AgendamentoDTO.class);
    }

    public void excluirPreAgendamento(Long id) {
        
        agendamentoPrevioRepository.deleteById(id);
       
    }

}
