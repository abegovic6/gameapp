package ba.academy.game.repository.erd;


import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "DUNGEON")
public class DungeonEntity extends AbstractEntity<Integer>{

    /** @Id
     * */
    @SequenceGenerator(
            name = "dungeonSeq",
            sequenceName = "DUNGEON_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dungeonSeq")
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




}
