package com.mycompany.app.RPGSinglePlayer;

import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        while (context.getPlayer().isAlive()) {
            System.out.println("\n你目前在：" + context.getCurrentRoom().getName());
            System.out.println("\n你看到：" + context.getCurrentRoom().getMonster().getName());
            System.out.println("\n可用方向：" + context.getCurrentRoom().getExitString());
            System.out.print("> ");
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
            }
        }
        System.out.println("你已死亡，遊戲結束。");
    }
}
