package ba.academy.game.repository.transformer;

import ba.academy.game.dto.GameDto;
import ba.academy.game.dto.LevelDto;
import ba.academy.game.repository.erd.GameEntity;

import java.util.LinkedList;


public class GameDtoTransformer implements DtoTransformer<GameEntity, GameDto>{
    private final LevelDtoTransformer levelDtoTransformer = new LevelDtoTransformer();
    private final PlayerDtoTransformer playerDtoTransformer = new PlayerDtoTransformer();

    @Override
    public GameDto toDto(GameEntity entity) {
        GameDto dto = new GameDto();

        dto.setId(entity.getId());
        dto.setScore(entity.getScore());
        dto.setCurrentLevelId(entity.getCurrentLevel());
        dto.setStatus(entity.getStatus());
        if(entity.getPlayer() != null) {
            dto.setPlayer(playerDtoTransformer.toDto(entity.getPlayer()));
        }
        else
            dto.setPlayer(null);
        dto.setLevelDtos((LinkedList<LevelDto>)
                levelDtoTransformer.toDtoList(entity.getLevels()));
        for(var level : dto.getLevelDtos())
            level.setGameId(dto.getId());
        return dto;
    }

    @Override
    public GameEntity toEntity(GameDto dto, GameEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new GameEntity();
        entityInstance.setScore(dto.getScore());
        entityInstance.setCurrentLevel(dto.getCurrentLevelId());
        entityInstance.setStatus(dto.getStatus());
        return entityInstance;
    }
}
