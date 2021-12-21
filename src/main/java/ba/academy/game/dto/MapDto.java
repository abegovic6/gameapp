package ba.academy.game.dto;


import java.util.LinkedList;

public class MapDto {
    private Integer id;

    private LinkedList<DungeonDto> dungeonDtos = new LinkedList<>();
    private DungeonDto currentDungeon;

    private Integer monstersDefeated = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinkedList<DungeonDto> getDungeons() {
        return dungeonDtos;
    }

    public void setDungeons(LinkedList<DungeonDto> dungeonDtos) {
        this.dungeonDtos = dungeonDtos;
    }

    public DungeonDto getCurrentDungeon() {
        return currentDungeon;
    }

    public void setCurrentDungeon(DungeonDto currentDungeonDto) {
        this.currentDungeon = currentDungeonDto;
    }

    public Integer getMonstersDefeated() {
        return monstersDefeated;
    }

    public void setMonstersDefeated(Integer monstersDefeated) {
        this.monstersDefeated = monstersDefeated;
    }

    public boolean lastLevel() {
        return dungeonDtos.getLast().equals(currentDungeon);
    }

    public Status moveNext() {
        int index = dungeonDtos.indexOf(currentDungeon);
        if(index == dungeonDtos.size() - 1) {
            return Status.LAST_DUNGEON_CANT_MOVE;
        }
        currentDungeon = dungeonDtos.get(index + 1);
        return Status.DUNGEON_MOVE_OK;
    }

    public Status moveBack() {
        int index = dungeonDtos.indexOf(currentDungeon);
        if(index == 0) {
            return Status.FIRST_DUNGEON_CANT_MOVE;
        }
        currentDungeon = dungeonDtos.get(index - 1);
        return Status.DUNGEON_MOVE_OK;
    }
}
