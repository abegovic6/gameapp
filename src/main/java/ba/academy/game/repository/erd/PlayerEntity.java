package ba.academy.game.repository.erd;


import ba.academy.game.dto.Weapon;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "games", name = "PLAYER")
public class PlayerEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "playerSeq",
            sequenceName = "PLAYER_SEQ",
            schema = "games",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerSeq")
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
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private GameEntity gameEntity;

    /** @Columns
     */
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
    @Column(name = "POWER_UP", nullable = false)
    private Integer powerUp;

    public Integer getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(Integer powerUp) {
        this.powerUp = powerUp;
    }

    @NotNull
    @Column(name = "WEAPON", nullable = false)
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
