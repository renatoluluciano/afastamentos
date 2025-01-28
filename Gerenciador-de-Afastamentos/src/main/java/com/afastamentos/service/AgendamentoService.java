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
import com.afastamentos.model.UserModel;
import com.afastamentos.repository.AgendamentoRepository;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public AgendamentoDTO cadastrarAgendamento(AgendamentoDTO agendamentoDTO, Long id) {

        UserDTO usuario = userService.listarPorId(id);

        if (usuario == null) {

            return null;
        }

        AgendamentoModel agendamento = modelMapper.map(agendamentoDTO, AgendamentoModel.class);       

        UserModel usuarioModel = modelMapper.map(usuario, UserModel.class);

        agendamento.setIdUser(usuarioModel);

        //System.out.println(agendamento.getDataAgendamento());

        boolean respostaVerificacao = verificaAgendamento(agendamento.getDataAgendamento(), agendamento.getIdUser());

        System.out.println(respostaVerificacao);

        if(respostaVerificacao == true){
            
        return null;

        }

        System.out.println(agendamento.getDataAgendamento());
        System.out.println(usuario.getUserName());

        agendamentoRepository.save(agendamento);   

        

        return modelMapper.map(agendamento, AgendamentoDTO.class);

        }

        

    public Page<AgendamentoDTO> listarAgendamentos(Pageable paginacao) {

        return agendamentoRepository.findAll(paginacao).map(p -> modelMapper.map(p, AgendamentoDTO.class));

    }

    public List<AgendamentoModel> bucarPorData(LocalDate date) {

        List<AgendamentoModel> agendamento = agendamentoRepository.findByDate(date);
        

        return agendamento;

    }

    public boolean verificaAgendamento(LocalDate date, UserModel idUser){
          
        List<AgendamentoModel> agendamentos = bucarPorData(date);

        for(AgendamentoModel agendamento : agendamentos){
            Long idVerificar = agendamento.getIdUser().getIdUser();
            if(idVerificar == idUser.getIdUser()){
                return true;
            }
        }

        return false;
    }

    public AgendamentoDTO alterarAgendamento(Long id, AgendamentoDTO agendamentoDTO){

        AgendamentoModel agendamento = modelMapper.map(agendamentoDTO, AgendamentoModel.class);

        agendamento.setIdAgendamento(id);

        agendamento = agendamentoRepository.save(agendamento);

        return modelMapper.map(agendamento, AgendamentoDTO.class);

    }



    public void excluirAgendamento(@NotNull Long id) {

        agendamentoRepository.deleteById(id);

       
    }

}
