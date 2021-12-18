package ba.academy.game.repository;

import ba.academy.game.repository.erd.PlayerEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PlayerRepository extends Repository<PlayerEntity, Integer>{
    protected PlayerRepository() {
        super(PlayerEntity.class);
    }
}
