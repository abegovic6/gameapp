package ba.academy.game.repository.erd;


import ba.academy.game.dto.Weapon;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "PLAYER")
public class PlayerEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "playerSeq",
            sequenceName = "PLAYER_SEQ",
            schema = "game-schema",
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
    @Column(name = "WEAPON", nullable = false)
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
