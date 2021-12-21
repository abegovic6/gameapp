package ba.academy.game.services;

import ba.academy.game.dto.MapDto;
import ba.academy.game.repository.DungeonRepository;
import ba.academy.game.repository.MapRepository;
import ba.academy.game.repository.erd.DungeonEntity;
import ba.academy.game.repository.erd.MapEntity;
import ba.academy.game.repository.transformer.MapDtoTransformer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
@Transactional
public class MapServiceImp implements MapService{
    private final MapDtoTransformer mapDtoTransformer = new MapDtoTransformer();

    @Inject
    MapRepository mapRepository;

    @Inject
    DungeonRepository dungeonRepository;

    @ConfigProperty(name = "prefix.message")
    String prefix;

    @Override
    public List<MapDto> getAll() {
        return mapDtoTransformer.toDtoList(mapRepository.findAllAsList());
    }

    @Override
    public MapDto getById(Integer id) {
        return mapDtoTransformer.toDto(mapRepository.findBy(id));
    }

    @Override
    public MapDto create(MapDto dto) {
        MapEntity mapEntity = mapDtoTransformer.toEntity(dto, new MapEntity());
        return getMapDto(dto, mapEntity);
    }

    @Override
    public MapDto deleteById(Integer id) {
        MapEntity mapEntity = mapRepository.findBy(id);
        if(mapEntity != null) {
            try {
                mapRepository.remove(mapEntity);
                return mapDtoTransformer.toDto(mapEntity);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public MapDto updateById(Integer id, MapDto dto) {
        try {
            MapEntity mapEntity = mapRepository.findBy(id);
            mapEntity.setDefeatedMonsters(dto.getMonstersDefeated());
            return getMapDto(dto, mapEntity);
        } catch (Exception e) {
            return null;
        }

    }

    private MapDto getMapDto(MapDto dto, MapEntity mapEntity) {
        if(dto.getCurrentDungeon() != null)
            mapEntity.setDungeonEntity(dungeonRepository.findBy(dto.getCurrentDungeon().getId()));
        else
            mapEntity.setDungeonEntity(null);
        Set<DungeonEntity> dungeonEntitySet = new HashSet<>();
        for(var dungeonDto : dto.getDungeons())
            dungeonEntitySet.add(dungeonRepository.findBy(dungeonDto.getId()));

        mapEntity.setDungeonEntitySet(dungeonEntitySet);

        mapRepository.persist(mapEntity);
        return mapDtoTransformer.toDto(mapEntity);
    }
}
