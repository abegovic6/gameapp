package ba.academy.game.services;

import ba.academy.game.dto.DungeonDto;

import java.util.List;

public interface DungeonService {
    List<DungeonDto> getAll();

    DungeonDto getById(Integer id);

    DungeonDto create(DungeonDto dto);

    DungeonDto deleteById(Integer id);

    DungeonDto updateById(Integer id, DungeonDto dto);
}
