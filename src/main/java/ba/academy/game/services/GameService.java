package ba.academy.game.services;

import ba.academy.game.dto.GameDto;

import java.util.List;

public interface GameService {
    List<GameDto> getAll();

    GameDto getById(Integer id);

    GameDto create(GameDto dto);

    GameDto deleteById(Integer id);

    GameDto updateById(Integer id, GameDto dto);
}
