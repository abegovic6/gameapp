package ba.academy.game.repository.erd;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "games", name = "GAME")
public class GameEntity extends AbstractEntity<Integer> {

    /** @Id
     * */
    @SequenceGenerator(
            name = "gameSeq",
            sequenceName = "GAME_SEQ",
            schema = "games",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameSeq")
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
    @OneToOne
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    private PlayerEntity player;

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity playerEntity) {
        this.player = playerEntity;
    }


    // this is not a column in game
    @OneToMany(mappedBy = "gameEntity")
    private Set<LevelEntity> levels;

    public Set<LevelEntity> getLevels() {
        return levels;
    }

    public void setLevels(Set<LevelEntity> levels) {
        this.levels = levels;
    }

    /** @Columns
     */
    @NotNull
    @Column(name = "SCORE", nullable = false)
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @NotNull
    @Column(name = "CURRENT_LEVEL")
    private Integer currentLevel;

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    @NotNull
    @Column(name = "STATUS")
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
