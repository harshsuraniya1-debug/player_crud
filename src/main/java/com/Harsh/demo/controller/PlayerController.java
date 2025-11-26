package com.Harsh.demo.controller;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.repository.PlayerRepository;
import com.Harsh.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PlayerController {

 @Autowired
private PlayerService playerService;

 @GetMapping
public List<PlayerDto> getAllPlayers (PlayerDto playerDto){


}

@GetMapping("/{id}")
public PlayerDto playerById(long id){

}

@PostMapping
@ResponseBody
public PlayerDto createPlayer( PlayerDto playerDto){

}

@PutMapping
public PlayerDto updatePlayer(PlayerDto playerDto,long id){


}

@DeleteMapping
public void deleteAll(){

}

@DeleteMapping("/{id}")
    public void deleteById(long id ){

}
}
