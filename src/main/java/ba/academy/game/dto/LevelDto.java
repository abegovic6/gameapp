package ba.academy.game.dto;

public class LevelDto {
    private Integer id;

    private Integer levelNumber;

    private MapDto mapDto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MapDto getMap() {
        return mapDto;
    }

    public void setMap(MapDto mapDto) {
        this.mapDto = mapDto;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Integer getScore() {
        return mapDto.getMonstersDefeated() * levelNumber;
    }

    public DungeonDto getCurrentDungeon() {
        return mapDto.getCurrentDungeon();
    }

    public Integer getFleeDamage() {
        return mapDto.getCurrentDungeon().getFleeDamage();
    }
}
