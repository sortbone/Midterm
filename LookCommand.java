package com.mycompany.app.RPGSinglePlayer;

public class LookCommand implements Command { public void execute(Player p, GameContext c) {
    Room currentRoom = p.getCurrentRoom(); // 獲取玩家當前所在的房間

        if (currentRoom != null) {
            // 顯示房間資訊
            System.out.println("你正在查看房間: " + currentRoom.getName());
            System.out.println("這裡的描述: " + currentRoom.getDescription());
            System.out.println("這裡的怪物: " + (currentRoom.getMonster() != null ? currentRoom.getMonster().getName() : "沒有"));
            System.out.println("這裡的出口: " + currentRoom.getExitString());
            
            // 顯示是否有藥水
            if (currentRoom.hasPotion()) {
                System.out.println("這裡有一瓶治療藥水!");
            } else {
                System.out.println("這裡沒有藥水.");
            }
        } else {
            System.out.println("你不在任何房間中，無法查看。");
        }



} }