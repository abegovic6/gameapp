package ba.academy.game.repository.erd;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class EntityListener {

    @PrePersist
    public void prePersist(AbstractEntity entity) {
        entity.setCreatedOn(LocalDateTime.now());
        entity.setModifiedOn(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(AbstractEntity entity) {
        entity.setModifiedOn(LocalDateTime.now());
    }
}
