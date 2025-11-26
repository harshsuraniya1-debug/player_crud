package com.Harsh.demo.service;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.entity.Player;
import com.Harsh.demo.mapper.Mapperutil;
import com.Harsh.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

@Autowired
    private PlayerRepository playerRepository;

 public List<PlayerDto> getAllPlayers(){
     List<Player> playerList =playerRepository.findAll();

     List<PlayerDto> playerDtoList = new ArrayList<>();
     for (Player p: playerList){
         PlayerDto playerDto = Mapperutil.toDto(p);
         playerDtoList.add(playerDto);

     }
     return playerDtoList;

 }




}
