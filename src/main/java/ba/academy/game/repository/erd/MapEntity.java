package ba.academy.game.repository.erd;


import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;

@Entity
@Table(schema = "game-schema", name = "MAP")
public class MapEntity extends AbstractEntity<Integer> {

    /** @Id
     * */
    @SequenceGenerator(
            name = "mapSeq",
            sequenceName = "MAP_SEQ",
            schema = "game-schema",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapSeq")
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
    @Column(name = "DEFEATED_MONSTERS", nullable = false)
    private Integer defeatedMonsters;



    public Integer getDefeatedMonsters() {
        return defeatedMonsters;
    }

    public void setDefeatedMonsters(Integer defeatedMonsters) {
        this.defeatedMonsters = defeatedMonsters;
    }
}
