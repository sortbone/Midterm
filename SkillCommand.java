package com.mycompany.app.RPGSinglePlayer;

public class SkillCommand implements Command { public SkillCommand(String name) {} 

private Skill skill; // 要使用的技能

    public SkillCommand(Skill skill) {
        this.skill = skill;
    }
public void execute(Player p, GameContext c) {
    Room currentRoom = p.getCurrentRoom(); // 獲取玩家當前所在的房間

        if (currentRoom != null) {
            Monster monster = currentRoom.getMonster(); // 獲取房間中的怪物

            if (monster != null && monster.isAlive()) {
                // 玩家使用技能對怪物
                System.out.println("你準備對 " + monster.getName() + " 使用技能: " + skill.getName());
                skill.use(p, monster); // 呼叫技能的 use 方法

                // 如果怪物被擊敗
                if (!monster.isAlive()) {
                    System.out.println(monster.getName() + " 被你擊敗了!");
                    currentRoom.removeMonster(); // 從房間中移除怪物
                    p.addKill(); // 增加玩家的擊殺數
                }
            } else {
                System.out.println("這裡沒有可以使用技能的怪物!");
            }
        } else {
            System.out.println("你不在任何房間中，無法使用技能!");
        }
} }