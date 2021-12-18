package ba.academy.game.repository;

import ba.academy.game.repository.erd.MapEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MapRepository extends Repository<MapEntity, Integer> {
    protected MapRepository() {
        super(MapEntity.class);
    }
}
