package ba.academy.game.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PlayerDto {
    private Integer id;
    private Integer health;
    private Weapon weapon = Weapon.FIST;
    private final List<PowerUp> powerUps = new ArrayList<>();

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

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void addPowerUp(PowerUp powerUp) {
        powerUps.add(powerUp);
    }

    public Integer getDamage() {
        if(powerUps.isEmpty())
            return weapon.getPower();
        AtomicReference<Integer> sum = new AtomicReference<>(0);
        powerUps.forEach(powerUp -> sum.updateAndGet(v -> v + powerUp.getScore()));
        return weapon.getPower() * sum.get() / powerUps.size();
    }
}
