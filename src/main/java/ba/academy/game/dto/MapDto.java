package ba.academy.game.dto;


import java.util.LinkedList;

public class MapDto {
    private Integer id;

    private LinkedList<DungeonDto> dungeons = new LinkedList<>();
    private Integer currentDungeonId = -1;

    private Integer levelId;

    private Integer monstersDefeated = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinkedList<DungeonDto> getDungeons() {
        return dungeons;
    }

    public void setDungeons(LinkedList<DungeonDto> dungeonDtos) {
        this.dungeons = dungeonDtos;
    }

    public Integer getCurrentDungeonId() {
        return currentDungeonId;
    }

    public void setCurrentDungeonId(Integer currentDungeonDto) {
        this.currentDungeonId = currentDungeonDto;
    }

    public DungeonDto findCurrentDungeon() {
        if(currentDungeonId == -1) return null;

        for(var dungeon : dungeons) {
            if(currentDungeonId.equals(dungeon.getId()))
                return dungeon;
        }

        return null;
    }

    public Integer getMonstersDefeated() {
        return monstersDefeated;
    }

    public void setMonstersDefeated(Integer monstersDefeated) {
        this.monstersDefeated = monstersDefeated;
    }

    public boolean lastLevel() {
        return dungeons.getLast().getId().equals(currentDungeonId);
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Status moveNext() {
        int index = dungeons.indexOf(findCurrentDungeon());
        if(index == dungeons.size() - 1) {
            return Status.LAST_DUNGEON_CANT_MOVE;
        }
        currentDungeonId = dungeons.get(index + 1).getId();
        return Status.DUNGEON_MOVE_OK;
    }

    public Status moveBack() {
        int index = dungeons.indexOf(findCurrentDungeon());
        if(index == 0 ) {
            return Status.FIRST_DUNGEON_CANT_MOVE;
        }
        currentDungeonId = index - 1;
        return Status.DUNGEON_MOVE_OK;
    }
}
