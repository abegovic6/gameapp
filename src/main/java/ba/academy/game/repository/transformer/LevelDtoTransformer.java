package ba.academy.game.repository.transformer;

import ba.academy.game.dto.LevelDto;
import ba.academy.game.repository.erd.LevelEntity;

public class LevelDtoTransformer implements DtoTransformer<LevelEntity, LevelDto>{
    @Override
    public LevelDto toDto(LevelEntity entity) {
        return null;
    }

    @Override
    public LevelEntity toEntity(LevelDto dto, LevelEntity entityInstance) {
        return null;
    }
}
