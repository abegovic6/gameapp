package ba.academy.game.services;


import ba.academy.game.dto.MapDto;

import java.util.List;

public interface MapService {
    List<MapDto> getAll();

    MapDto getById(Integer id);

    MapDto create(MapDto dto);

    MapDto deleteById(Integer id);

    MapDto updateById(Integer id, MapDto dto);
}
