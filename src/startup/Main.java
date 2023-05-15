package startup;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import entities.Component;
import entities.CreateTaskButton;
import setup.Manager;
import setup.Window;

public class Main implements Manager {

    public static final int SCREEN_WIDTH = 1200, SCREEN_HEIGHT = 800;

    public static final int TASK_HEIGHT = 80, TASK_BUTTON_HEIGHT = 80, TASK_BUTTON_X = 950,
            TASK_BUTTON_Y = SCREEN_HEIGHT - TASK_BUTTON_HEIGHT - 60, TASK_BUTTON_WIDTH = 200;

    public final static int TASKS_X = 0, TASKS_WIDTH = 300;
    public static final int VIEW_X = TASKS_X + TASKS_WIDTH + Component.margin + Component.margin,
            VIEW_WIDTH = 860;

    TasksView tasksView;
    TasksList tasksList;
    CreateTaskButton createTaskButton;

    public Main() {
        tasksView = new TasksView(VIEW_X, 0, VIEW_WIDTH, SCREEN_HEIGHT - TASK_BUTTON_HEIGHT - 70);
        tasksList = new TasksList(TASKS_X, 0, TASKS_WIDTH, SCREEN_HEIGHT, tasksView);
        createTaskButton = new CreateTaskButton(TASK_BUTTON_X, TASK_BUTTON_Y, TASK_BUTTON_WIDTH, TASK_BUTTON_HEIGHT,
                tasksList);
    }

    public static void main(String[] args) {
        new Window(SCREEN_WIDTH, SCREEN_HEIGHT, 120, 120, "HelpDesk Managment System", new Main());
    }

    @Override
    public void draw(Graphics g) {
        Font f = new Font("Times New Roman", Font.PLAIN, 12);
        g.setFont(f);

        tasksList.draw(g);
        tasksView.draw(g);
        createTaskButton.draw(g);
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
        createTaskButton.clicked(e);
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

    public static void drawTextInBox(Graphics2D g, String desc, int x, int y, int w, int h, int lh) {
        AffineTransform at = g.getTransform();
        g.translate(x, y);
        int desclength = desc.length();
        int lineh = lh;
        int linechar = w / 6;
        int linec = h / lineh;
        for (int i = 0; i < linec; i++) {
            if (-i * linechar + desclength < 0)
                break;
            g.drawString(desc.substring(i * linechar, Math.min(desclength, (i + 1) * linechar)), 0, lineh * i);
        }
        g.setTransform(at);
    }
}
