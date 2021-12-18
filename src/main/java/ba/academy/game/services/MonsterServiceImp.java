package ba.academy.game.services;

import ba.academy.game.dto.MonsterDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MonsterServiceImp implements MonsterService{
    @Override
    public List<MonsterDto> getAll() {
        return null;
    }

    @Override
    public MonsterDto getById(Integer id) {
        return null;
    }

    @Override
    public MonsterDto create(MonsterDto dto) {
        return null;
    }

    @Override
    public MonsterDto deleteById(Integer id) {
        return null;
    }

    @Override
    public MonsterDto updateById(Integer id, MonsterDto dto) {
        return null;
    }
}
