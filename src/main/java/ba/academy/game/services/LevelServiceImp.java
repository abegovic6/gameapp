package ba.academy.game.services;

import ba.academy.game.dto.LevelDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class LevelServiceImp implements LevelService{
    @Override
    public List<LevelDto> getAll() {
        return null;
    }

    @Override
    public LevelDto getById(Integer id) {
        return null;
    }

    @Override
    public LevelDto create(LevelDto dto) {
        return null;
    }

    @Override
    public LevelDto deleteById(Integer id) {
        return null;
    }

    @Override
    public LevelDto updateById(Integer id, LevelDto dto) {
        return null;
    }
}
