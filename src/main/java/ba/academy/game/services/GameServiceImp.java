package ba.academy.game.services;

import ba.academy.game.dto.*;
import ba.academy.game.repository.GameRepository;
import ba.academy.game.repository.LevelRepository;
import ba.academy.game.repository.PlayerRepository;
import ba.academy.game.repository.erd.GameEntity;
import ba.academy.game.repository.erd.LevelEntity;
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

    @Inject
    PlayerService playerService;

    @Inject
    MonsterService monsterService;

    @Inject
    LevelService levelService;

    @Inject
    MapService mapService;

    @Inject
    DungeonService dungeonService;

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

    @Override
    public Status move(Integer id) {
        var gameDto = getById(id);
        var status = gameDto.move();
        gameDto.setStatus(status.getReasonPhrase());
        updateAll(gameDto);
        return status;
    }

    @Override
    public Status fight(Integer id) {
        var gameDto = getById(id);
        var status = gameDto.fight();
        gameDto.setStatus(status.getReasonPhrase());
        updateAll(gameDto);
        return status;
    }

    @Override
    public Status flee(Integer id) {
        var gameDto = getById(id);
        var status = gameDto.flee();
        gameDto.setStatus(status.getReasonPhrase());
        updateAll(gameDto);
        return status;
    }

    @Override
    public Status collect(Integer id) {
        var gameDto = getById(id);
        var status = gameDto.collect();
        gameDto.setStatus(status.getReasonPhrase());
        updateAll(gameDto);
        return status;
    }

    private GameDto getGameDto(GameDto dto, GameEntity gameEntity) {
        if(dto.getPlayer() != null)
            gameEntity.setPlayer(playerRepository.findBy(dto.getPlayer().getId()));
        else
            gameEntity.setPlayer(null);
        gameEntity.setStatus(dto.getStatus());
        gameEntity.setCurrentLevel(dto.getCurrentLevelId());
        Set<LevelEntity> levelEntities = new HashSet<>();
        for(LevelDto levelDto : dto.getLevelDtos())
            levelEntities.add(levelRepository.findBy(levelDto.getId()));
        gameEntity.setLevels(levelEntities);

        gameRepository.persist(gameEntity);
        return gameDtoTransformer.toDto(gameEntity);
    }

    private void updateAll(GameDto game) {
        LevelDto level = game.findCurrentLevel();
        updateLevel(level);

        for(var l : game.getLevelDtos())
            updateLevel(l);

        updateById(game.getId(), game);
    }

    private void updateLevel(LevelDto level) {
        if(level != null) {
            MapDto map = level.getMap();
            if (map != null) {
                for (var dungeon : map.getDungeons()) {
                    MonsterDto monsterDto = dungeon.getMonster();
                    if (monsterDto != null) {
                        monsterService.updateById(monsterDto.getId(), monsterDto);
                    }
                    dungeonService.updateById(dungeon.getId(), dungeon);
                }
                mapService.updateById(map.getId(), map);
            }
            levelService.updateById(level.getId(), level);
        }
    }
}
