package ba.academy.game.repository;


import ba.academy.game.repository.erd.DungeonEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DungeonRepository extends Repository<DungeonEntity, Integer> {
    protected DungeonRepository() {
        super(DungeonEntity.class);
    }
}
