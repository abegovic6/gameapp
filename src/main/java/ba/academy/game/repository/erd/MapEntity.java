package ba.academy.game.repository.erd;


import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "games", name = "MAP")
public class MapEntity extends AbstractEntity<Integer> {

    /** @Id
     * */
    @SequenceGenerator(
            name = "mapSeq",
            sequenceName = "MAP_SEQ",
            schema = "games",
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

    @OneToOne(mappedBy = "mapEntity", cascade = CascadeType.ALL)
    private LevelEntity levelEntity;

    public LevelEntity getLevelEntity() {
        return levelEntity;
    }

    public void setLevelEntity(LevelEntity levelEntity) {
        this.levelEntity = levelEntity;
    }

    @OneToOne
    @JoinColumn(name = "CURRENT_DUNGEON")
    private DungeonEntity dungeonEntity;

    public DungeonEntity getDungeonEntity() {
        return dungeonEntity;
    }

    public void setDungeonEntity(DungeonEntity dungeonEntity) {
        this.dungeonEntity = dungeonEntity;
    }

    @OneToMany(mappedBy = "mapEntity")
    private Set<DungeonEntity> dungeonEntitySet;

    public Set<DungeonEntity> getDungeonEntitySet() {
        return dungeonEntitySet;
    }

    public void setDungeonEntitySet(Set<DungeonEntity> dungeonEntitySet) {
        this.dungeonEntitySet = dungeonEntitySet;
    }

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
