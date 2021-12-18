package ba.academy.game.services;


import ba.academy.game.dto.LevelDto;

import java.util.List;

public interface LevelService {
    List<LevelDto> getAll();

    LevelDto getById(Integer id);

    LevelDto create(LevelDto dto);

    LevelDto deleteById(Integer id);

    LevelDto updateById(Integer id, LevelDto dto);
}
