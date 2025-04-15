package com.mycompany.app.RPGSinglePlayer;

public class AttackCommand implements Command { public void execute(Player p, GameContext c) {

    Room currentRoom = p.getCurrentRoom(); // 獲取玩家當前所在的房間

        if (currentRoom != null) {
            Monster monster = currentRoom.getMonster(); // 獲取房間中的怪物

            if (monster != null && monster.isAlive()) {
                // 玩家攻擊怪物
                System.out.println("你攻擊了 " + monster.getName() + "，造成 " + p.getAttack() + " 傷害!");
                monster.takeDamage(p.getAttack());

                // 如果怪物被擊敗
                if (!monster.isAlive()) {
                    System.out.println(monster.getName() + " 被你擊敗了!");
                    currentRoom.removeMonster(); // 從房間中移除怪物
                    p.addKill(); // 增加玩家的擊殺數
                }
            } else {
                System.out.println("這裡沒有可以攻擊的怪物!");
            }
        } else {
            System.out.println("你不在任何房間中，無法攻擊!");
        }
} }