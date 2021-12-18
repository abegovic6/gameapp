package ba.academy.game.services;

import ba.academy.game.dto.DungeonDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DungeonServiceImp implements DungeonService{
    @Override
    public List<DungeonDto> getAll() {
        return null;
    }

    @Override
    public DungeonDto getById(Integer id) {
        return null;
    }

    @Override
    public DungeonDto create(DungeonDto dto) {
        return null;
    }

    @Override
    public DungeonDto deleteById(Integer id) {
        return null;
    }

    @Override
    public DungeonDto updateById(Integer id, DungeonDto dto) {
        return null;
    }
}
