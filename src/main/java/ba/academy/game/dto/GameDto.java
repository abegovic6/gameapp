package ba.academy.game.dto;

import java.util.LinkedList;
import java.util.Random;

public class GameDto {
    private Integer id;
    private Integer score = 0;

    private LinkedList<LevelDto> levelDtos = new LinkedList<>();
    private Integer currentLevelId = -1;
    private PlayerDto player;
    private String status;

    public GameDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LinkedList<LevelDto> getLevelDtos() {
        return levelDtos;
    }

    public void setLevelDtos(LinkedList<LevelDto> levelDtos) {
        this.levelDtos = levelDtos;
    }

    public Integer getCurrentLevelId() {
        return currentLevelId;
    }

    public void setCurrentLevelId(Integer currentLevelId) {
        this.currentLevelId = currentLevelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LevelDto findCurrentLevel() {
        if(currentLevelId == -1) return null;

        for(var l : levelDtos) {
            if(l.getId().equals(currentLevelId)) {
                return  l;
            }
        }

        return null;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public Status fight() {
        try {
            MonsterDto monsterDto = findCurrentLevel().getCurrentDungeon().getMonster();

            if(monsterDto != null && monsterDto.getHealth() > 0) {
                while (player.getHealth() > 0 && monsterDto.getHealth() > 0) {
                    Random random = new Random();
                    int nb = Math.abs(Math.floorMod(random.nextInt(),6))/5;
                    monsterDto.setHealth(monsterDto.getHealth() - player.getDamage() * nb);
                    player.setHealth(player.getHealth() - monsterDto.getDamage() * nb);

                    if(!(player.getHealth() > 0)) return Status.LEVEL_LOST;
                    if(!(monsterDto.getHealth() > 0)) {
                        findCurrentLevel().getMap().setMonstersDefeated(findCurrentLevel().getMap().getMonstersDefeated() + 1);
                        player.setWeapon(player.getWeapon().getNext());
                        score += monsterDto.getDamage();
                        return Status.BATTLE_IS_WON;
                    }
                }

            }

            return Status.NO_MONSTER_TO_FIGHT;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }
    }

    public Status collect() {
        try {
            DungeonDto dungeonDto = findCurrentLevel().getCurrentDungeon();
            if(dungeonDto.getMonster() != null && dungeonDto.getMonster().getHealth() > 0)
                return Status.NEED_TO_DEFEAT_MONSTER_TO_COLLECT;

            if(dungeonDto.getHealingPotion() != null)
                player.setHealth(player.getHealth() + dungeonDto.getHealingPotion().getHealingPower());

            if(dungeonDto.getPowerUp() != null)
                player.addPowerUp(dungeonDto.getPowerUp());

            if(findCurrentLevel().getMap().lastDungeon()) {
                return nextLevel();
            }

            return Status.COLLECT_OK;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status flee() {
        try {
            MonsterDto monsterDto = findCurrentLevel().getCurrentDungeon().getMonster();

            if(monsterDto != null && monsterDto.getHealth() > 0) {
                if(findCurrentLevel().getMap().lastDungeon())
                    return Status.CANT_FLEE_LAST_DUNGEON;
                player.setHealth(player.getHealth() - findCurrentLevel().getFleeDamage());
                return Status.FLEE_OK;
            }

            return Status.NO_MONSTER_TO_FLEE;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status move() {
        try {
            if(status.equals(Status.GAME_WON.getReasonPhrase()))
                return Status.GAME_WON;
            MonsterDto monsterDto = findCurrentLevel().getCurrentDungeon().getMonster();
            if(monsterDto != null && monsterDto.getHealth() > 0) {
                return Status.NEED_TO_FLEE_OR_FIGHT;
            }
            var status = findCurrentLevel().getMap().moveNext();
            if(status.equals(Status.LAST_DUNGEON_CANT_MOVE))
                return Status.COLLECT_ORB_OF_QUARKUS_TO_WIN;
            return status;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status nextLevel() {
        try {
            int index = levelDtos.indexOf(findCurrentLevel());
            if(index == levelDtos.size() - 1) {
                return Status.GAME_WON;
            }
            currentLevelId = levelDtos.get(index).getId();
            return Status.LEVEL_MOVE_OK;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

}
