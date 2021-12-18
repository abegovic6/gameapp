package ba.academy.game.repository.erd;


import ba.academy.game.dto.HealingPotion;
import ba.academy.game.dto.PowerUp;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "DUNGEON")
public class DungeonEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "dungeonSeq",
            sequenceName = "DUNGEON_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dungeonSeq")
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
    @ManyToOne
    @JoinColumn(name="MAP_ID", nullable=false)
    private MapEntity mapEntity;

    @OneToOne
    @JoinColumn(name = "MONSTER_ID")
    private MonsterEntity monsterEntity;

    public MonsterEntity getMonsterEntity() {
        return monsterEntity;
    }

    public void setMonsterEntity(MonsterEntity monsterEntity) {
        this.monsterEntity = monsterEntity;
    }

    /** @Columns
     * */
    @Column(name = "POWER_UP")
    private PowerUp powerUp;

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    @Column(name = "HEALING_POTION")
    private HealingPotion healingPotion;

    public HealingPotion getHealingPotion() {
        return healingPotion;
    }

    public void setHealingPotion(HealingPotion healingPotion) {
        this.healingPotion = healingPotion;
    }
}
