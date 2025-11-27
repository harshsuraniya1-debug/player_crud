package com.Harsh.demo.service;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.entity.Player;
import com.Harsh.demo.mapper.MapperUtil;
import com.Harsh.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDto> getAllPlayers() {
        List<Player> playerList = playerRepository.findAll();

        List<PlayerDto> playerDtoList = new ArrayList<>();
        for (Player p : playerList) {
            PlayerDto playerDto = MapperUtil.toDto(p);
            playerDtoList.add(playerDto);

        }
        return playerDtoList;

    }

    public PlayerDto playerById(long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            return MapperUtil.toDto(player.get());
        }
        throw new RuntimeException("player id is not present : " + id);
    }

    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = MapperUtil.toEntity(playerDto);
        Player savedplayer = playerRepository.save(player);

        return MapperUtil.toDto(savedplayer);
    }

    public PlayerDto updatePlayer(PlayerDto playerDto, long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {

            Player tempPlayer = player.get();
            tempPlayer.setAge(playerDto.getAge());
            tempPlayer.setName(playerDto.getName());
            tempPlayer.setJersey(playerDto.getJersey());
            tempPlayer.setTeam(playerDto.getTeam());

            Player upplayer = playerRepository.save(tempPlayer);

            return MapperUtil.toDto(upplayer);

        }

        throw new RuntimeException("player is not is the records with this id : " + id);

    }


        public void deleteAllPlayer(){
            playerRepository.deleteAll();
        }

        public void deleteById(long id){
            playerRepository.deleteById(id);
        }

    }





