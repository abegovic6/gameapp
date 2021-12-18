package ba.academy.game.repository.transformer;

import ba.academy.game.dto.DungeonDto;
import ba.academy.game.repository.erd.DungeonEntity;

public class DungeonDtoTransformer implements DtoTransformer<DungeonEntity, DungeonDto>{
    private final MonsterDtoTransformer monsterDtoTransformer = new MonsterDtoTransformer();

    @Override
    public DungeonDto toDto(DungeonEntity entity) {
        DungeonDto dto = new DungeonDto();
        dto.setId(entity.getId());
        dto.setHealingPotion(entity.getHealingPotion());
        dto.setMonster(monsterDtoTransformer.toDto(entity.getMonsterEntity()));
        dto.setPowerUp(entity.getPowerUp());

        return dto;
    }

    @Override
    public DungeonEntity toEntity(DungeonDto dto, DungeonEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new DungeonEntity();
        entityInstance.setHealingPotion(dto.getHealingPotion());
        entityInstance.setPowerUp(dto.getPowerUp());
        return entityInstance;
    }
}
