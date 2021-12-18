package ba.academy.game.repository.transformer;

import ba.academy.game.dto.PlayerDto;
import ba.academy.game.repository.erd.PlayerEntity;

public class PlayerDtoTransformer implements DtoTransformer<PlayerEntity, PlayerDto>{
    @Override
    public PlayerDto toDto(PlayerEntity entity) {
        return null;
    }

    @Override
    public PlayerEntity toEntity(PlayerDto dto, PlayerEntity entityInstance) {
        return null;
    }
}
