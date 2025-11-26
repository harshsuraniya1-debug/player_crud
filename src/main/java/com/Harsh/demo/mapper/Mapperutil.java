package com.Harsh.demo.mapper;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.entity.Player;

public class Mapperutil {

    public static Player toEntity (PlayerDto playerDto){
        Player player = new Player();
        //player.setId(playerDto.getId());
        player.setTeam(playerDto.getTeam());
        player.setName(playerDto.getName());
        player.setJersey(playerDto.getJersey());
        player.setAge(playerDto.getAge());
        return player;
    }

    public static PlayerDto toDto(Player player){
        PlayerDto playerDto =new PlayerDto();
        playerDto.setAge(player.getAge());
        playerDto.setId(player.getId());
        playerDto.setTeam(player.getTeam());
        playerDto.setJersey(player.getJersey());
        playerDto.setName(player.getName());
        return playerDto;
    }
}
