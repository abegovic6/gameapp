package ba.academy.game.dto;

public enum Weapon {
    FIST(5),
    HAMMER(10),
    WRENCH(15),
    CROWBAR(20),
    KNIFE(25),
    SWORD(30),
    GLOCK(35),
    USP(40),
    UZI(45),
    SNIPER(50);

    private Integer value;

    private Weapon() {
    }

    private Weapon(Integer value) {
        this.value = value;
    }

    public Integer getPower() {
        return this.value;
    }

    public Weapon getNext() {
        if(this.equals(Weapon.SNIPER)) return SNIPER;

        return this.ordinal() < Weapon.values().length - 1
                ? Weapon.values()[this.ordinal() + 1]
                : null;
    }
}