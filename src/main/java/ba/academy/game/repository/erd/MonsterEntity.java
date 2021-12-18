package ba.academy.game.repository.erd;


import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "MONSTER")
public class MonsterEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "monsterSeq",
            sequenceName = "MONSTER_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monsterSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /** @Columns
     * */
    @NotNull
    @Column(name = "HEALTH", nullable = false)
    private Integer health;

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @NotNull
    @Column(name = "DAMAGE", nullable = false)
    private Integer damage;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
