package com.mycompany.app.RPGSinglePlayer;

public interface Command {
    void execute(Player player, GameContext context);
}
