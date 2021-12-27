package ba.academy.game.repository.transformer;

import ba.academy.game.dto.DungeonDto;
import ba.academy.game.dto.MapDto;
import ba.academy.game.repository.erd.MapEntity;

import java.util.LinkedList;

public class MapDtoTransformer implements DtoTransformer<MapEntity, MapDto>{
    private final DungeonDtoTransformer dungeonDtoTransformer = new DungeonDtoTransformer();

    @Override
    public MapDto toDto(MapEntity entity) {
        MapDto dto = new MapDto();
        dto.setId(entity.getId());
        dto.setMonstersDefeated(entity.getDefeatedMonsters());
        dto.setCurrentDungeonId(entity.getCurrentDungeon());
        dto.setDungeons((LinkedList<DungeonDto>)
                dungeonDtoTransformer.toDtoList(entity.getDungeonEntitySet()));
        for(var dungeon : dto.getDungeons()) {
            dungeon.setMapId(dto.getId());
        }
        dto.setLevelId(entity.getLevelId());
        return dto;
    }

    @Override
    public MapEntity toEntity(MapDto dto, MapEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new MapEntity();

        entityInstance.setCurrentDungeon(dto.getCurrentDungeonId());
        entityInstance.setDefeatedMonsters(dto.getMonstersDefeated());
        entityInstance.setLevelId(dto.getLevelId());
        return entityInstance;
    }
}
