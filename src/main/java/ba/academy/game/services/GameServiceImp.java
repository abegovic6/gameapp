package ba.academy.game.services;

import ba.academy.game.dto.GameDto;
import ba.academy.game.dto.LevelDto;
import ba.academy.game.repository.GameRepository;
import ba.academy.game.repository.LevelRepository;
import ba.academy.game.repository.PlayerRepository;
import ba.academy.game.repository.erd.GameEntity;
import ba.academy.game.repository.erd.LevelEntity;
import ba.academy.game.repository.transformer.DungeonDtoTransformer;
import ba.academy.game.repository.transformer.GameDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Transactional
public class GameServiceImp implements GameService{
    private final GameDtoTransformer gameDtoTransformer = new GameDtoTransformer();

    @Inject
    GameRepository gameRepository;

    @Inject
    LevelRepository levelRepository;

    @Inject
    PlayerRepository playerRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<GameDto> getAll() {
        return gameDtoTransformer.toDtoList(gameRepository.findAllAsList());
    }

    @Override
    public GameDto getById(Integer id) {
        return gameDtoTransformer.toDto(gameRepository.findBy(id));
    }

    @Override
    public GameDto create(GameDto dto) {
        final GameEntity gameEntity = gameDtoTransformer.toEntity(dto, new GameEntity());
        return getGameDto(dto, gameEntity);
    }

    @Override
    public GameDto deleteById(Integer id) {
        final GameEntity gameEntity = gameRepository.findBy(id);
        if(gameEntity != null) {
            try {
                gameRepository.remove(gameEntity);
                return gameDtoTransformer.toDto(gameEntity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public GameDto updateById(Integer id, GameDto dto) {
        try {
            final GameEntity gameEntity = gameRepository.findBy(id);
            gameEntity.setScore(dto.getScore());
            return getGameDto(dto, gameEntity);
        } catch (Exception e) {
            return null;
        }
    }

    private GameDto getGameDto(GameDto dto, GameEntity gameEntity) {
        gameEntity.setPlayer(playerRepository.findBy(dto.getPlayerDto().getId()));
        gameEntity.setCurrentLevel(levelRepository.findBy(dto.getCurrentLevelDto().getId()));

        Set<LevelEntity> levelEntities = new HashSet<>();
        for(LevelDto levelDto : dto.getLevelDtos())
            levelEntities.add(levelRepository.findBy(levelDto.getId()));
        gameEntity.setLevels(levelEntities);

        gameRepository.persist(gameEntity);
        return gameDtoTransformer.toDto(gameEntity);
    }
}
