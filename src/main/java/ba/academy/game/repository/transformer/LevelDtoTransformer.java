package ba.academy.game.repository.transformer;

import ba.academy.game.dto.LevelDto;
import ba.academy.game.repository.erd.LevelEntity;

public class LevelDtoTransformer implements DtoTransformer<LevelEntity, LevelDto>{
    private final MapDtoTransformer mapDtoTransformer = new MapDtoTransformer();


    @Override
    public LevelDto toDto(LevelEntity entity) {
        LevelDto dto = new LevelDto();
        dto.setId(entity.getId());
        dto.setLevelNumber(entity.getLevelNumber());
        if(entity.getMapEntity() != null)
            dto.setMap(mapDtoTransformer.toDto(entity.getMapEntity()));
        else
            dto.setMap(null);
        return dto;
    }

    @Override
    public LevelEntity toEntity(LevelDto dto, LevelEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new LevelEntity();

        entityInstance.setLevelNumber(dto.getLevelNumber());
        return entityInstance;
    }
}
