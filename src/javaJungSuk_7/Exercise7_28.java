package javaJungSuk_7;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exercise7_28 {
    public static void main(String[] args) {
        Frame f = new Frame();
        //f.addWindowListener(new EventHandler());

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        f.setSize(500,500);
        f.setVisible(true);
    }
}


class EventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
}