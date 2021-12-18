package ba.academy.game.repository.transformer;

import ba.academy.game.dto.MonsterDto;
import ba.academy.game.repository.erd.MonsterEntity;

public class MonsterDtoTransformer implements DtoTransformer<MonsterEntity, MonsterDto>{
    @Override
    public MonsterDto toDto(MonsterEntity entity) {
        return null;
    }

    @Override
    public MonsterEntity toEntity(MonsterDto dto, MonsterEntity entityInstance) {
        return null;
    }
}
