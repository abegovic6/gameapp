package ba.academy.game.repository.transformer;

import ba.academy.game.dto.GameDto;
import ba.academy.game.repository.erd.GameEntity;

public class GameDtoTransformer implements DtoTransformer<GameEntity, GameDto>{
    private final LevelDtoTransformer levelDtoTransformer = new LevelDtoTransformer();

    @Override
    public GameDto toDto(GameEntity entity) {
        GameDto dto = new GameDto();

        dto.setId(entity.getId());
        //dto.setCurrentLevelDto(levelDtoTransformer.toDto());
        return null;
    }

    @Override
    public GameEntity toEntity(GameDto dto, GameEntity entityInstance) {
        return null;
    }
}
