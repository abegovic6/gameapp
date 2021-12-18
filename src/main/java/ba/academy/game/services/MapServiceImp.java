package ba.academy.game.services;

import ba.academy.game.dto.MapDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MapServiceImp implements MapService{
    @Override
    public List<MapDto> getAll() {
        return null;
    }

    @Override
    public MapDto getById(Integer id) {
        return null;
    }

    @Override
    public MapDto create(MapDto dto) {
        return null;
    }

    @Override
    public MapDto deleteById(Integer id) {
        return null;
    }

    @Override
    public MapDto updateById(Integer id, MapDto dto) {
        return null;
    }
}
