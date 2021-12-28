package ba.academy.game.dto;

import javax.ws.rs.core.Response;

public enum Status {
    LAST_DUNGEON_CANT_MOVE(false, "Can not move, this is the last dungeon!"),
    FIRST_DUNGEON_CANT_MOVE(false, "Can not move back, this is the last dungeon!"),
    DUNGEON_MOVE_OK(true, "You moved to another dungeon!"),

    BATTLE_IS_WON(true, "You defeated the monster! Now you can collect the items or move!"),

    NO_MONSTER_TO_FIGHT(false, "There is no monster to fight!"),

    NEED_TO_DEFEAT_MONSTER_TO_COLLECT(false, "In order to collect the items, " +
            "first you need to defeat the monster!"),
    COLLECT_OK(true, "You collected the items in the dungeon!"),

    FLEE_OK(true, "You fled the monster! You moved to the next dungeon!"),
    NO_MONSTER_TO_FLEE(false, "You don't need to flee. " +
            "There are no monsters in the dungeon."),
    CANT_FLEE_LAST_DUNGEON(false, "This is the last dungeon in the level. " +
            "You need to fight the monster to move!"),

    NEED_TO_FLEE_OR_FIGHT(false, "You can not move to the next dungeon." +
            "There is a monster in the dungeon. You can either flee or fight."),

    LEVEL_LOST(false, "Sorry! You have lost the level!"),

    COLLECT_ORB_OF_QUARKUS_TO_WIN(true, "This is the last dungeon in the level! " +
            "You need to collect the Orb of Quarkus to win!"),
    GAME_WON(true, "This was the last level. Congratulations. You have collected the Orb of Quarkus." +
            "You have won the game."),
    LEVEL_MOVE_OK(true, "Congratulations. You have collected the Orb of Quarkus. You won the level!" +
            "You have moved to the next level."),

    NULL_POINTER(false, "Ups! There has been a null pointer somewhere");


    private boolean isOk;

    private String reasonPhrase = "";

    Status(boolean isOk, String reasonPhrase) {
        this.isOk = isOk;
        this.reasonPhrase = reasonPhrase;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    Status() {
    }


}
