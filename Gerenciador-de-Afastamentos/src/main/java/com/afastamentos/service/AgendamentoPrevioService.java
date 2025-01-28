package com.afastamentos.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.afastamentos.dto.AgendamentoDTO;
import com.afastamentos.dto.UserDTO;
import com.afastamentos.model.AgendamentoPrevio;
import com.afastamentos.model.UserModel;
import com.afastamentos.repository.AgendamentoPrevioRepository;


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

}
