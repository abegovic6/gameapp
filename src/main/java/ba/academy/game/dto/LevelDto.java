package ba.academy.game.dto;

public class LevelDto {
    private Integer id;

    private Integer levelNumber;

    private MapDto map;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MapDto getMap() {
        return map;
    }

    public void setMap(MapDto mapDto) {
        this.map = mapDto;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Integer getScore() {
        if(map == null)
            return 0;
        return map.getMonstersDefeated() * levelNumber;
    }

    public DungeonDto getCurrentDungeon() {
        if(map == null) return null;
        return map.getCurrentDungeon();
    }

    public Integer getFleeDamage() {
        if(map == null) return 0;
        return map.getCurrentDungeon().getFleeDamage();
    }
}
