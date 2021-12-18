package ba.academy.game.repository.erd;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "GAME")
public class GameEntity extends AbstractEntity<Integer> {

    /** @Id
     * */
    @SequenceGenerator(
            name = "gameSeq",
            sequenceName = "GAME_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    /** @Relations
     * */
    @OneToOne

}
