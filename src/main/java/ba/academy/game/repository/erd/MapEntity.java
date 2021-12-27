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

    public MapEntity() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /** @Relations
     * */

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
    @Column(name = "CURRENT_DUNGEON", nullable = false)
    private Integer currentDungeon;

    public Integer getCurrentDungeon() {
        return currentDungeon;
    }

    public void setCurrentDungeon(Integer currentDungeon) {
        this.currentDungeon = currentDungeon;
    }

    @NotNull
    @Column(name = "DEFEATED_MONSTERS", nullable = false)
    private Integer defeatedMonsters;

    public Integer getDefeatedMonsters() {
        return defeatedMonsters;
    }

    public void setDefeatedMonsters(Integer defeatedMonsters) {
        this.defeatedMonsters = defeatedMonsters;
    }

    @NotNull
    @Column(name = "LEVEL_ID")
    private Integer levelId;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
}
