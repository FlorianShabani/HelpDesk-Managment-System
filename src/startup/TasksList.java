package startup;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Segment;

public class TasksList extends Segment {

    ArrayList<Segment> segments = new ArrayList<Segment>();

    public TasksList(int x, int y) {
        super(x, y, 400, Main.SCREEN_HEIGHT);
    }

    public void draw(Graphics g) {
        g.drawString("Hello", 20, 20);
    }

    public void addTask() {
        
    }
}
