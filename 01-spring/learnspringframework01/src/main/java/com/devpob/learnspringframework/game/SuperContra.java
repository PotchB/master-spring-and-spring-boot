package com.devpob.learnspringframework.game;

public class SuperContra implements GameConsole {
    @Override
    public void up() {
        System.out.println("Up");
    }

    @Override
    public void down() {
        System.out.println("Fall Down");
    }

    @Override
    public void left() {
        System.out.println("Retreat");
    }

    @Override
    public void right() {
        System.out.println("Attack");
    }
}
