package ba.academy.game.services;

import ba.academy.game.dto.MonsterDto;
import ba.academy.game.repository.MonsterRepository;
import ba.academy.game.repository.erd.MonsterEntity;
import ba.academy.game.repository.transformer.MonsterDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MonsterServiceImp implements MonsterService{
    private final MonsterDtoTransformer monsterDtoTransformer = new MonsterDtoTransformer();

    @Inject
    MonsterRepository monsterRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<MonsterDto> getAll() {
        return monsterDtoTransformer.toDtoList(monsterRepository.findAllAsList());
    }

    @Override
    public MonsterDto getById(Integer id) {
        return monsterDtoTransformer.toDto(monsterRepository.findBy(id));
    }

    @Override
    public MonsterDto create(MonsterDto dto) {
        MonsterEntity monsterEntity = monsterDtoTransformer.toEntity(dto, new MonsterEntity());
        monsterRepository.persist(monsterEntity);
        return monsterDtoTransformer.toDto(monsterEntity);
    }

    @Override
    public MonsterDto deleteById(Integer id) {
        MonsterEntity monsterEntity = monsterRepository.findBy(id);
        if(monsterEntity != null) {
            try {
                monsterRepository.remove(monsterEntity);
                return monsterDtoTransformer.toDto(monsterEntity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public MonsterDto updateById(Integer id, MonsterDto dto) {
        try {
            MonsterEntity monsterEntity = monsterRepository.findBy(id);
            monsterEntity.setHealth(dto.getHealth());
            monsterEntity.setDamage(dto.getDamage());
            monsterRepository.persist(monsterEntity);
            return monsterDtoTransformer.toDto(monsterEntity);
        } catch (Exception e) {
            return null;
        }
    }
}
