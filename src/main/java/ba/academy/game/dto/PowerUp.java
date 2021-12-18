package ba.academy.game.dto;

public enum PowerUp {
    ONE(1),
    TWO(2),
    THREE(3);

    private Integer score;

    private PowerUp() {
    }

    private PowerUp(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}
