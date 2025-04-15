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


    // 確認玩家是否可以移動
    if (p.isAlive()) {
        // 呼叫玩家的 move 方法，並傳入方向
        p.move(direction);

        // 確認移動後的房間是否有怪物
        Room currentRoom = p.getCurrentRoom();
        if (currentRoom.getMonster() != null && currentRoom.getMonster().isAlive()) {
            System.out.println("你遇到了一個 " + currentRoom.getMonster().getName() + "!");
        } else {
            System.out.println("這裡沒有敵人。");
        }
    } else {
        System.out.println("你現在無法移動！");
    }
    }

} 

