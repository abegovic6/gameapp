package ba.academy.game.services;

import ba.academy.game.dto.GameDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class GameServiceImp implements GameService{

    @Override
    public List<GameDto> getAll() {
        return null;
    }

    @Override
    public GameDto getById(Integer id) {
        return null;
    }

    @Override
    public GameDto create(GameDto dto) {
        return null;
    }

    @Override
    public GameDto deleteById(Integer id) {
        return null;
    }

    @Override
    public GameDto updateById(Integer id, GameDto dto) {
        return null;
    }
}
