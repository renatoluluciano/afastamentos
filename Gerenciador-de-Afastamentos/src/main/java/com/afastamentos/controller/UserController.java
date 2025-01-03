package com.afastamentos.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.afastamentos.dto.UserDTO;
import com.afastamentos.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;







@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class UserController {

    private final UserService userService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UserDTO> cadastrar(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder){
        
        UserDTO userDTOControler = userService.cadastrarUsuario(userDTO);

        URI endereco = uriComponentsBuilder.path("/cadastrar/{id}").buildAndExpand(userDTOControler.getIdUser()).toUri();

        return ResponseEntity.created(endereco).body(userDTOControler);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UserDTO> listarUsuarioId(@PathVariable @NotNull Long id) {

        UserDTO usuarioDTO = userService.listarPorId(id);


        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Page<UserDTO>> listarTodos(@PageableDefault(size = 10) Pageable paginacao){

        Page<UserDTO> pageUserDTO = userService.listarTodos(paginacao);

        return ResponseEntity.ok(pageUserDTO);

    }
    


}
