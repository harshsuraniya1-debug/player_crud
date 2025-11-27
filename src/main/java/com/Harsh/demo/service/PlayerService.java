package com.Harsh.demo.service;

import com.Harsh.demo.dto.PlayerDto;
import com.Harsh.demo.entity.Player;
import com.Harsh.demo.mapper.Mapperutil;
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
            PlayerDto playerDto = Mapperutil.toDto(p);
            playerDtoList.add(playerDto);

        }
        return playerDtoList;

    }

    public PlayerDto playerById(long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            return Mapperutil.toDto(player.get());
        }
        throw new RuntimeException("player id is not present : " + id);
    }

    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = Mapperutil.toEntity(playerDto);
        Player savedplayer = playerRepository.save(player);

        return Mapperutil.toDto(savedplayer);
    }

    public PlayerDto updatePlayer(PlayerDto playerDto, long id) {
        Optional<Player> allReadyPlayer = playerRepository.findById(id);

        if (allReadyPlayer.isPresent()) {

            Player tempPlayer = allReadyPlayer.get();

            tempPlayer.setAge(playerDto.getAge());
            tempPlayer.setName(playerDto.getName());
            tempPlayer.setJersey(playerDto.getJersey());
            tempPlayer.setTeam(playerDto.getTeam());

            Player upplayer = playerRepository.save(tempPlayer);

            return Mapperutil.toDto(upplayer);

        } else {
            throw new RuntimeException("player is not is the records with this id : " + id);
        }


        public void deleteAllPlayer () {
            playerRepository.deleteAll();
        }
        public void deleteById (long id){
            playerRepository.deleteById(id);
        }

    }
}




