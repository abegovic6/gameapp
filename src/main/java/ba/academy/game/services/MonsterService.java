package ba.academy.game.services;


import ba.academy.game.dto.MonsterDto;

import java.util.List;

public interface MonsterService {
    List<MonsterDto> getAll();

    MonsterDto getById(Integer id);

    MonsterDto create(MonsterDto dto);

    MonsterDto deleteById(Integer id);

    MonsterDto updateById(Integer id, MonsterDto dto);
}
