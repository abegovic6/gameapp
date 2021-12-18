package ba.academy.game.services;

import ba.academy.game.dto.PlayerDto;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class PlayerServiceImp implements PlayerService{
    @Override
    public List<PlayerDto> getAll() {
        return null;
    }

    @Override
    public PlayerDto getById(Integer id) {
        return null;
    }

    @Override
    public PlayerDto create(PlayerDto dto) {
        return null;
    }

    @Override
    public PlayerDto deleteById(Integer id) {
        return null;
    }

    @Override
    public PlayerDto updateById(Integer id, PlayerDto dto) {
        return null;
    }
}
