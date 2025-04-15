package com.mycompany.app.RPGSinglePlayer;

public class Monster {
    private String name;
    private int hp;
    private int attack;
    //private Monster monster; // Add a field for monster
    private Room room; // Add a reference to the Room
     
    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
  

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
       /*  
       name = "哥布林";
        hp = 30;
        attack = 8;
        */
    }

    public Monster getMonster() {
        return this; // Return the current instance
    }

    /*public void setMonster(Monster monster) {
        this.monster = monster;
    }*/

    public void attack(Player player) {
        if (isAlive()) {
            System.out.println(name + "攻擊了你，造成" + attack + "傷害!");
            player.takeDamage(attack);
        }
    }


    public String getName() { return name; }
    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int damage) { hp -= damage; 
        if (hp <= 0) {
            System.out.println(name + "被擊敗了!");
            if (room != null) {
                room.removeMonster(); // 從房間中移除怪物
            }
        } else {
            System.out.println(name + "還有" + hp + "生命值.");
        }
    }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }
}
