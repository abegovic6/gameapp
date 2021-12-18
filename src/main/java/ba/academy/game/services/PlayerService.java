package ba.academy.game.services;


import ba.academy.game.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<PlayerDto> getAll();

    PlayerDto getById(Integer id);

    PlayerDto create(PlayerDto dto);

    PlayerDto deleteById(Integer id);

    PlayerDto updateById(Integer id, PlayerDto dto);
}
