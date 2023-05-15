package tasks;

import java.awt.Color;
import java.awt.Graphics;

import startup.TasksList;

public class UrgentTask extends Task {

    public UrgentTask(TasksList tasksList, String title, String description) {
        super(tasksList, title, description);
    }

    public void drawDecorations(Graphics g) {
        g.setColor(new Color(200, 50, 50, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }

}
