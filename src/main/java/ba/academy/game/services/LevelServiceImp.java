package ba.academy.game.services;

import ba.academy.game.dto.LevelDto;
import ba.academy.game.repository.LevelRepository;
import ba.academy.game.repository.MapRepository;
import ba.academy.game.repository.erd.LevelEntity;
import ba.academy.game.repository.transformer.LevelDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class LevelServiceImp implements LevelService{
    private final LevelDtoTransformer levelDtoTransformer = new LevelDtoTransformer();

    @Inject
    LevelRepository levelRepository;

    @Inject
    MapRepository mapRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<LevelDto> getAll() {
        return levelDtoTransformer.toDtoList(levelRepository.findAllAsList());
    }

    @Override
    public LevelDto getById(Integer id) {
        return levelDtoTransformer.toDto(levelRepository.findBy(id));
    }

    @Override
    public LevelDto create(LevelDto dto) {
        LevelEntity levelEntity = levelDtoTransformer.toEntity(dto, new LevelEntity());
        levelEntity.setMapEntity(mapRepository.findBy(dto.getMap().getId()));
        levelRepository.persist(levelEntity);
        return levelDtoTransformer.toDto(levelEntity);
    }

    @Override
    public LevelDto deleteById(Integer id) {
        LevelEntity levelEntity = levelRepository.findBy(id);
        if(levelEntity != null) {
            try {
                levelRepository.remove(levelEntity);
                return levelDtoTransformer.toDto(levelEntity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public LevelDto updateById(Integer id, LevelDto dto) {
        try {
            LevelEntity levelEntity = levelRepository.findBy(id);
            levelEntity.setLevelNumber(dto.getLevelNumber());
            levelEntity.setMapEntity(mapRepository.findBy(dto.getMap().getId()));
            levelRepository.persist(levelEntity);
            return levelDtoTransformer.toDto(levelEntity);
        } catch (Exception e) {
            return null;
        }
    }
}
