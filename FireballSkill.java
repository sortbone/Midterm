package com.mycompany.app.RPGSinglePlayer;

public class FireballSkill implements Skill { 
	public String getName() { 
		return "火球術"; 
	} 
	
	public void use(Player p, Monster m) { 
		// Implement the logic for using the Fireball skill
		System.out.println("🔥你對" + m.getName() + "施放了火球術！");
		m.takeDamage(40); // Example damage value
	}
}