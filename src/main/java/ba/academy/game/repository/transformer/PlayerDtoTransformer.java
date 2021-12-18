package ba.academy.game.repository.transformer;

import ba.academy.game.dto.PlayerDto;
import ba.academy.game.repository.erd.PlayerEntity;

public class PlayerDtoTransformer implements DtoTransformer<PlayerEntity, PlayerDto>{
    @Override
    public PlayerDto toDto(PlayerEntity entity) {
        PlayerDto dto = new PlayerDto();
        dto.setId(entity.getId());
        dto.setWeapon(entity.getWeapon());
        dto.setHealth(entity.getHealth());
        dto.setPowerUp(entity.getPowerUp());
        return dto;
    }

    @Override
    public PlayerEntity toEntity(PlayerDto dto, PlayerEntity entityInstance) {
        if(entityInstance == null)
            entityInstance = new PlayerEntity();

        entityInstance.setPowerUp(dto.getPowerUp());
        entityInstance.setWeapon(dto.getWeapon());
        entityInstance.setHealth(dto.getHealth());
        return entityInstance;
    }
}
