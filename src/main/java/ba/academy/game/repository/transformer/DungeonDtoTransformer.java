package ba.academy.game.repository.transformer;

import ba.academy.game.dto.DungeonDto;
import ba.academy.game.repository.erd.DungeonEntity;

public class DungeonDtoTransformer implements DtoTransformer<DungeonEntity, DungeonDto>{
    @Override
    public DungeonDto toDto(DungeonEntity entity) {
        return null;
    }

    @Override
    public DungeonEntity toEntity(DungeonDto dto, DungeonEntity entityInstance) {
        return null;
    }
}
