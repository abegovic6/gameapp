package ba.academy.game.dto;


import java.util.LinkedList;

public class MapDto {
    private Integer id;

    private LinkedList<DungeonDto> dungeonDtos = new LinkedList<>();
    private DungeonDto currentDungeonDto;

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
        return currentDungeonDto;
    }

    public void setCurrentDungeon(DungeonDto currentDungeonDto) {
        this.currentDungeonDto = currentDungeonDto;
    }

    public Integer getMonstersDefeated() {
        return monstersDefeated;
    }

    public void setMonstersDefeated(Integer monstersDefeated) {
        this.monstersDefeated = monstersDefeated;
    }

    public boolean isOrbOfQuarkus() {
        return dungeonDtos.getLast().equals(currentDungeonDto);
    }

    public Status moveNext() {
        int index = dungeonDtos.indexOf(currentDungeonDto);
        if(index == dungeonDtos.size() - 1) {
            return Status.LAST_DUNGEON_CANT_MOVE;
        }
        currentDungeonDto = dungeonDtos.get(index + 1);
        return Status.DUNGEON_MOVE_OK;
    }

    public Status moveBack() {
        int index = dungeonDtos.indexOf(currentDungeonDto);
        if(index == 0) {
            return Status.FIRST_DUNGEON_CANT_MOVE;
        }
        currentDungeonDto = dungeonDtos.get(index - 1);
        return Status.DUNGEON_MOVE_OK;
    }
}
