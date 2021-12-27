package ba.academy.game.services;

import ba.academy.game.dto.DungeonDto;
import ba.academy.game.repository.DungeonRepository;
import ba.academy.game.repository.MapRepository;
import ba.academy.game.repository.MonsterRepository;
import ba.academy.game.repository.erd.DungeonEntity;
import ba.academy.game.repository.transformer.DungeonDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DungeonServiceImp implements DungeonService{
    private final DungeonDtoTransformer dungeonDtoTransformer = new DungeonDtoTransformer();

    @Inject
    DungeonRepository dungeonRepository;

    @Inject
    MonsterRepository monsterRepository;

    @Inject
    MapRepository mapRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<DungeonDto> getAll() {
        return dungeonDtoTransformer.toDtoList(dungeonRepository.findAllAsList());
    }

    @Override
    public DungeonDto getById(Integer id) {
        return dungeonDtoTransformer.toDto(dungeonRepository.findBy(id));
    }

    @Override
    public DungeonDto create(DungeonDto dto) {
        final DungeonEntity dungeonEntity = dungeonDtoTransformer.toEntity(dto, new DungeonEntity());
        if(dto.getMonster() != null)
            dungeonEntity.setMonsterEntity(monsterRepository.findBy(dto.getMonster().getId()));
        else
            dungeonEntity.setMonsterEntity(null);
        if(dto.getMapId() != null)
            dungeonEntity.setMapEntity(mapRepository.findBy(dto.getMapId()));
        else
            dungeonEntity.setMapEntity(null);
        dungeonRepository.persist(dungeonEntity);
        return dungeonDtoTransformer.toDto(dungeonEntity);
    }

    @Override
    public DungeonDto deleteById(Integer id) {
        DungeonEntity entity = dungeonRepository.findBy(id);
        if(entity != null) {
            try {
                dungeonRepository.remove(entity);
                return dungeonDtoTransformer.toDto(entity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public DungeonDto updateById(Integer id, DungeonDto dto) {
        DungeonEntity entity = dungeonRepository.findBy(id);
        entity.setPowerUp(dto.getPowerUp());
        entity.setHealingPotion(dto.getHealingPotion());
        if(dto.getMonster() != null)
            entity.setMonsterEntity(monsterRepository.findBy(dto.getMonster().getId()));
        else
            entity.setMonsterEntity(null);
        if(dto.getMapId() != null)
            entity.setMapEntity(mapRepository.findBy(dto.getMapId()));
        else
            entity.setMapEntity(null);
        try {
            dungeonRepository.persist(entity);
            return dungeonDtoTransformer.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
