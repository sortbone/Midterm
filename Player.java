package com.mycompany.app.RPGSinglePlayer;

public class Player {
    private String name;
    private int hp;
    private int attack;
    private int killCount = 0;
    private int totalDamage = 0;
    //private String skillName;
    //private int skillDamage = 0;
    private Room currentRoom; // 玩家當前所在的房間

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        
       // this.currentRoom = null; // 初始時沒有房間

        /*name = "玩家";
        hp = 100;
        attack = 15;
        skillName = "【火球術】";
        skillDamage = 40;
        */

    }
    
    // Getter 方法：取得當前房間
    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Setter 方法：設定當前房間
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void move(String direction) {
        Room currentRoom = getCurrentRoom();
        if (currentRoom != null) {
            Room nextRoom = currentRoom.getExit(direction); // 根據方向獲取下一個房間
            if (nextRoom != null) {
                setCurrentRoom(nextRoom); // 更新玩家的當前房間
                System.out.println("你移動到了 " + nextRoom.getName() + "。");
            } else {
                System.out.println("這個方向沒有出口！");
            }
        } else {
            System.out.println("你不在任何房間中，無法移動！");
        }
    }

    public String getDirection() {
        // 假設有邏輯來取得玩家的移動方向
        return "north";
    }


    /*public void attack(Monster monster) {
        if (isAlive()) {

            System.out.println("你攻擊了" + monster.getName() + "，造成" + attack + "傷害!");
            monster.takeDamage(attack);
            totalDamage += attack;
        }
    }
    public void useSkill(Skill skill, Monster monster) {
        if (isAlive()) {
            System.out.println("你準備施放技能: " + skill.getName());
            skill.use(this, monster); // 呼叫技能的 use 方法
        }
    }*/

    

    /*public void useSkill(Skill skill, Monster monster) {
        if (isAlive()) {
            System.out.println("你施放了" + skill.getName() + "!");
            skillDamage = skill.calculateDamage(this, monster); // Assuming skill has a method to calculate damage
            // Assuming skill has a method to calculate damage
            
            monster.takeDamage(skillDamage);
            totalDamage += skillDamage;

            //Assuming skill has a method to use it
            // This is a placeholder for the actual skill usage
            // For example, if the skill is a fireball:
            // FireballSkill fireball = (FireballSkill) skill;
            // fireball.use(this, monster);
            // For now, just call the skill's use method
            // Assuming skill has a method to use it

            skill.use(this, monster);
            totalDamage += attack; // Assuming skill also adds to total damage
        }
    }*/


    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int dmg) { hp -= dmg; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public void addKill() { killCount++; }
    public void addDamage(int dmg) { totalDamage += dmg; }
   
}
