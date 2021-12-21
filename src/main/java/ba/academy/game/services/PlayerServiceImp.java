package ba.academy.game.services;

import ba.academy.game.dto.PlayerDto;
import ba.academy.game.repository.PlayerRepository;
import ba.academy.game.repository.erd.PlayerEntity;
import ba.academy.game.repository.transformer.PlayerDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class PlayerServiceImp implements PlayerService{
    private final PlayerDtoTransformer playerDtoTransformer = new PlayerDtoTransformer();

    @Inject
    PlayerRepository playerRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<PlayerDto> getAll() {
        return playerDtoTransformer.toDtoList(playerRepository.findAllAsList());
    }

    @Override
    public PlayerDto getById(Integer id) {
        return playerDtoTransformer.toDto(playerRepository.findBy(id));
    }

    @Override
    public PlayerDto create(PlayerDto dto) {
        PlayerEntity playerEntity = playerDtoTransformer.toEntity(dto, new PlayerEntity());
        playerRepository.persist(playerEntity);
        return playerDtoTransformer.toDto(playerEntity);
    }

    @Override
    public PlayerDto deleteById(Integer id) {
        PlayerEntity playerEntity = playerRepository.findBy(id);
        if(playerEntity != null) {
            try {
                playerRepository.remove(playerEntity);
                return playerDtoTransformer.toDto(playerEntity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public PlayerDto updateById(Integer id, PlayerDto dto) {
        try {
            PlayerEntity playerEntity = playerRepository.findBy(id);
            playerEntity.setHealth(dto.getHealth());
            playerEntity.setPowerUp(dto.getPowerUp());
            playerEntity.setWeapon(dto.getWeapon());
            playerRepository.persist(playerEntity);
            return playerDtoTransformer.toDto(playerEntity);
        } catch (Exception e) {
            return null;
        }
    }
}
