package com.afastamentos.service;


import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afastamentos.dto.UserDTO;
import com.afastamentos.model.UserModel;
import com.afastamentos.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserDTO cadastrarUsuario(UserDTO userDTO){

        UserModel usuario = modelMapper.map(userDTO, UserModel.class);

        userRepository.save(usuario);

        return modelMapper.map(usuario, UserDTO.class);

    }

    public UserDTO listarPorId(long idUser){

        UserModel usuario = userRepository.findById(idUser).orElseThrow(() -> new EntityNotFoundException());


        return modelMapper.map(usuario, UserDTO.class);

    }

    public Page<UserDTO> listarTodos(Pageable paginacao){

         return userRepository.findAll(paginacao).map(p -> modelMapper.map(p, UserDTO.class));

    }

    





}
