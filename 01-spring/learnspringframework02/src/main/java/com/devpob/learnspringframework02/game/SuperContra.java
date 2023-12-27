package com.devpob.learnspringframework02.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")   // To give preference to this candidate even though we've set Mario with @Primary, copy and paste this in the Constructor injection in GameRunner class
public class SuperContra implements GameConsole {
    @Override
    public void up() {
        System.out.println("SuperContra Up");   
    }

    @Override
    public void down() {
        System.out.println("SuperContra Down");  
    }

    @Override
    public void left() {
        System.out.println("SuperContra Left");  
    }

    @Override
    public void right() {
        System.out.println("SuperContra Right");  
    }
}
