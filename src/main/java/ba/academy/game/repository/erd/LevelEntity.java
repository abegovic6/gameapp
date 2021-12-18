package ba.academy.game.repository.erd;


import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "LEVEL")
public class LevelEntity extends AbstractEntity<Integer>{

    /** ID
     * */
    @SequenceGenerator(
            name = "levelSeq",
            sequenceName = "LEVEL_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "levelSeq")
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
     * */
    @NotNull
    @Column(name = "LEVEL_NUMBER", nullable = false)
    private Integer levelNumber;

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }
}
