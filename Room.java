package com.mycompany.app.RPGSinglePlayer;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private boolean hasPotion;
    private Map<String, Room> exits = new HashMap<>();
    private Monster monster; // Declare the monster field


    public Room(String name, String description, Monster monster, boolean hasPotion) {
        this.name = name;
        this.description = description;
        this.monster = monster;
        this.hasPotion = hasPotion;

    
    
        hasPotion = Math.random() < 0.5; // 50% chance to have a potion

        if (monster != null) {
            monster.setRoom(this); // 將房間與怪物關聯
            // Ensure the monster is associated with this room if needed
            // monster.setMonster(this); // Removed as it causes a type mismatch
        }

        /*if (hasPotion) {
            System.out.println("這裡有一瓶治療藥水!");
        } else {
            System.out.println("這裡沒有藥水.");
        }*/
    }

    
    



    public String getName() { return name; }
    public String getDescription() { return description; }
    public Monster getMonster() { return monster; }
    public boolean hasPotion() { return hasPotion; }
    public void removePotion() { hasPotion = false; }
    public void removeMonster() { monster = null;}
    public void setExit(String direction, Room room) { exits.put(direction, room); }
    public Room getExit(String direction) { return exits.get(direction); }
    public String getExitString() { return String.join(", ", exits.keySet()); }
}
