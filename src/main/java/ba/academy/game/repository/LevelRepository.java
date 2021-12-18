package ba.academy.game.repository;

import ba.academy.game.repository.erd.LevelEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class LevelRepository extends Repository<LevelEntity, Integer>{
    protected LevelRepository() {
        super(LevelEntity.class);
    }
}
