package ba.academy.game.dto;

public enum HealingPotion {
    ONE(5),
    TWO(10),
    THREE(20);

    private Integer value;

    private HealingPotion() {
    }

    private HealingPotion(Integer value) {
        this.value = value;
    }

    public Integer getHealingPower() {
        return this.value;
    }
}
