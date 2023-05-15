package tasks;

import java.awt.Color;
import java.awt.Graphics;

import startup.TasksList;

public class StandardTask extends Task{

    public StandardTask(TasksList tasksList, String title, String description) {
        super(tasksList, title, description);
    }

    public void drawDecorations(Graphics g) {
        g.setColor(new Color(181, 229, 237, 250));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }
    
}
