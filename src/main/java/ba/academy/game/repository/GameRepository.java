package ba.academy.game.repository;

import ba.academy.game.repository.erd.GameEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class GameRepository extends Repository<GameEntity, Integer> {
    protected GameRepository() {
        super(GameEntity.class);
    }
}
