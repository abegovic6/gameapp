package ba.academy.game.dto;

import java.util.LinkedList;
import java.util.Random;

public class GameDto {
    private Integer id;
    private Integer score = 0;

    private LinkedList<LevelDto> levelDtos = new LinkedList<>();
    private LevelDto currentLevelDto;
    private PlayerDto playerDto;

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

    public LevelDto getCurrentLevelDto() {
        return currentLevelDto;
    }

    public void setCurrentLevelDto(LevelDto currentLevelDto) {
        this.currentLevelDto = currentLevelDto;
    }

    public PlayerDto getPlayerDto() {
        return playerDto;
    }

    public void setPlayerDto(PlayerDto playerDto) {
        this.playerDto = playerDto;
    }

    public Status fight() {
        try {
            MonsterDto monsterDto = currentLevelDto.getCurrentDungeon().getMonster();

            if(monsterDto != null && monsterDto.getHealth() > 0) {
                while (playerDto.getHealth() > 0 && monsterDto.getHealth() > 0) {
                    Random random = new Random();
                    int nb = Math.abs(Math.floorMod(random.nextInt(),6))/5;
                    monsterDto.setHealth(monsterDto.getHealth() - playerDto.getDamage() * nb);
                    playerDto.setHealth(playerDto.getHealth() - monsterDto.getDamage() * nb);

                    if(!(playerDto.getHealth() > 0)) return Status.LEVEL_LOST;
                    if(!(monsterDto.getHealth() > 0)) {
                        currentLevelDto.getMap().setMonstersDefeated(currentLevelDto.getMap().getMonstersDefeated() + 1);
                        playerDto.setWeapon(playerDto.getWeapon().getNext());
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
            DungeonDto dungeonDto = currentLevelDto.getCurrentDungeon();
            if(dungeonDto.getMonster() != null && dungeonDto.getMonster().getHealth() > 0)
                return Status.NEED_TO_DEFEAT_MONSTER_TO_COLLECT;

            if(dungeonDto.getHealingPotion() != null)
                playerDto.setHealth(playerDto.getHealth() + dungeonDto.getHealingPotion().getHealingPower());

            if(dungeonDto.getPowerUp() != null)
                playerDto.addPowerUp(dungeonDto.getPowerUp());

            if(currentLevelDto.getMap().lastLevel())
                return Status.LEVEL_WON;

            return Status.COLLECT_OK;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status flee() {
        try {
            MonsterDto monsterDto = currentLevelDto.getCurrentDungeon().getMonster();

            if(monsterDto != null && monsterDto.getHealth() > 0) {
                playerDto.setHealth(playerDto.getHealth() - currentLevelDto.getFleeDamage());
                return Status.FLEE_OK;
            }

            return Status.NO_MONSTER_TO_FLEE;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status move() {
        try {
            MonsterDto monsterDto = currentLevelDto.getCurrentDungeon().getMonster();
            if(monsterDto != null && monsterDto.getHealth() > 0) {
                return Status.NEED_TO_FLEE_OR_FIGHT;
            }

            return currentLevelDto.getMap().moveNext();
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

    public Status nextLevel() {
        try {
            int index = levelDtos.indexOf(currentLevelDto);
            if(index == levelDtos.size() - 1) {
                return Status.GAME_WON;
            }
            currentLevelDto = levelDtos.get(index + 1);
            return Status.LEVEL_MOVE_OK;
        } catch (NullPointerException e) {
            return Status.NULL_POINTER;
        }

    }

}
