package com.Harsh.demo.controller;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

 @Autowired
private PlayerService playerService;

 @GetMapping
public List<PlayerDto> getAllPlayers (PlayerDto playerDto){
     return playerService.getAllPlayers();
}

@GetMapping("/{id}")
public PlayerDto playerById(@PathVariable("id") long playerid){
     return playerService.playerById(playerid);
}

@PostMapping
public PlayerDto createPlayer( @RequestBody PlayerDto playerDto){
    return playerService.createPlayer(playerDto);

}

@PutMapping("/{id}")
public PlayerDto updatePlayer(@RequestBody PlayerDto playerDto,@PathVariable("id") long playerid){
  return playerService.updatePlayer(playerDto,playerid);

}

@DeleteMapping
public void deleteAllPlayer(){
     playerService.deleteAllPlayer();

}

@DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long playerid ){
    playerService.deleteById(playerid);
}
}
