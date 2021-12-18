package ba.academy.game.repository;

import ba.academy.game.repository.erd.MonsterEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MonsterRepository extends Repository<MonsterEntity, Integer> {
    protected MonsterRepository() {
        super(MonsterEntity.class);
    }
}
