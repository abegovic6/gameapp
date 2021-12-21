package ba.academy.game.repository.erd;


import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "games", name = "MONSTER")
public class MonsterEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "monsterSeq",
            sequenceName = "MONSTER_SEQ",
            schema = "games",
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

    /** @Relations
     * */
    @OneToOne(mappedBy = "monsterEntity", cascade = CascadeType.ALL)
    private DungeonEntity dungeonEntity;

    public DungeonEntity getDungeonEntity() {
        return dungeonEntity;
    }

    public void setDungeonEntity(DungeonEntity dungeonEntity) {
        this.dungeonEntity = dungeonEntity;
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
