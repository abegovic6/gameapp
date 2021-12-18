package ba.academy.game.repository.transformer;

import ba.academy.game.dto.MonsterDto;
import ba.academy.game.repository.erd.MonsterEntity;

public class MonsterDtoTransformer implements DtoTransformer<MonsterEntity, MonsterDto>{

    @Override
    public MonsterDto toDto(MonsterEntity entity) {
        if(entity == null)
            return null;
        MonsterDto dto = new MonsterDto();
        dto.setId(entity.getId());
        dto.setDamage(entity.getDamage());
        dto.setHealth(entity.getHealth());
        return dto;
    }

    @Override
    public MonsterEntity toEntity(MonsterDto dto, MonsterEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new MonsterEntity();
        entityInstance.setDamage(dto.getDamage());
        entityInstance.setHealth(dto.getHealth());
        return entityInstance;
    }
}
