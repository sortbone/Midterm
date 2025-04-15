package com.mycompany.app.RPGSinglePlayer;

public class MoveCommand implements Command { 
    
    private String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
    public void execute(Player p, GameContext c) {


    // Check if the player is in a valid state to move
    if (p.isAlive() && p.getCurrentRoom() != null ) {
        // Move the player in the specified direction
        p.move(direction);
        System.out.println("你朝著" + p.getDirection() + "的方向移動了。");
        // Check if the player has encountered an enemy
        if (c.getCurrentRoom().getMonster() != null && c.getCurrentRoom().getMonster().isAlive()) {
            // Display the enemy's name
            System.out.println("你遇到了一個" + c.getCurrentRoom().getMonster() + "!");
            // Check if the enemy is alive
            if (c.getCurrentRoom().getMonster().isAlive()) {
                System.out.println("敵人還活著，準備戰鬥！");
            } else {
                System.out.println("敵人已經被打敗了。");
            }
            // Set the player's state to in combat
            // Start combat
            //c.startCombat(p, c.getCurrentRoom().getMonster());
        } else {
            System.out.println("這裡沒有敵人。");
        }
    } else {
        System.out.println("You cannot move right now.");
    }

} 



}