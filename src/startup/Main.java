package startup;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import entities.Component;
import setup.Manager;
import setup.Window;

public class Main implements Manager {

    public static final int SCREEN_WIDTH = 1200, SCREEN_HEIGHT = 800;


    public static final int TASK_HEIGHT = 80;

    public final static int TASKS_X = 0, TASKS_WIDTH = 300;
    public static final int VIEW_X = TASKS_X + TASKS_WIDTH + Component.margin + Component.margin,
    VIEW_WIDTH = 860;


    TasksView tasksView;
    TasksList tasksList;

    public Main() {
        tasksView = new TasksView(VIEW_X, 0, VIEW_WIDTH, SCREEN_HEIGHT/2);
        tasksList = new TasksList(TASKS_X, 0, TASKS_WIDTH, SCREEN_HEIGHT, tasksView);
    }

    public static void main(String[] args) {
        new Window(SCREEN_WIDTH, SCREEN_HEIGHT, 120, 120, "HelpDesk Managment System", new Main());
    }

    @Override
    public void draw(Graphics g) {
        tasksList.draw(g);
        tasksView.draw(g);
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
        tasksList.onClick(e);
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
