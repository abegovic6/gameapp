package ba.academy.game.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PlayerDto {
    private Integer id;
    private Integer health;
    private Weapon weapon = Weapon.FIST;
    private Integer powerUp = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Integer getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(Integer powerUp) {
        this.powerUp = powerUp;
    }

    public void addPowerUp(PowerUp powerUp) {
        this.powerUp += powerUp.getScore();
    }

    public Integer getDamage() {
        if(powerUp == 0)
            return weapon.getPower();
        return weapon.getPower() + powerUp;
    }
}
