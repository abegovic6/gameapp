package ba.academy.game.repository.transformer;

import ba.academy.game.dto.MapDto;
import ba.academy.game.repository.erd.MapEntity;

public class MapDtoTransformer implements DtoTransformer<MapEntity, MapDto>{
    @Override
    public MapDto toDto(MapEntity entity) {
        return null;
    }

    @Override
    public MapEntity toEntity(MapDto dto, MapEntity entityInstance) {
        return null;
    }
}
