package startup;


import java.awt.Graphics;
import java.awt.event.MouseEvent;

import setup.Window;
import setup.Manager;
import entities.Segment;

public class Main implements Manager{

    public static final int SCREEN_WIDTH = 1200, SCREEN_HEIGHT = 800;

    public Main(){

    }

    public static void main(String[] args) {
        new Window(SCREEN_WIDTH, SCREEN_HEIGHT, 120, 120, "HelpDesk Managment System", new Main());
    }



    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void keyPressed(int e) {
        
    }

    @Override
    public void keyReleased(int e) {
        
    }

    @Override
    public void keyTyped(int e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void tick() {
        
    }   
}
