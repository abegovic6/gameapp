package ba.academy.game.dto;

import java.util.Objects;
import java.util.Random;

public class DungeonDto {
    private Integer id;

    private MonsterDto monster;
    private PowerUp powerUp;
    private HealingPotion healingPotion;

    private Integer mapId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MonsterDto getMonster() {
        return monster;
    }

    public void setMonster(MonsterDto monsterDto) {
        this.monster = monsterDto;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public HealingPotion getHealingPotion() {
        return healingPotion;
    }

    public void setHealingPotion(HealingPotion healingPotion) {
        this.healingPotion = healingPotion;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getFleeDamage() {
        Random random = new Random();
        int nb = random.nextInt();

        return Math.abs(Math.floorMod(nb, 5));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DungeonDto dungeonDto = (DungeonDto) o;
        return id.equals(dungeonDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
