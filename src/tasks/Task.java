package tasks;

import java.awt.Color;
import java.awt.Graphics;

import org.w3c.dom.events.MouseEvent;

import entities.Clickable;
import entities.Component;
import startup.Main;
import startup.TasksList;

public class Task extends Component implements Clickable{

    public static final int TASK_HEIGHT = 100;
    TasksList tasksList;

    String title, description;

    public Task(TasksList tasksList) {
        super(0, 0, Main.TASKS_WIDTH - margin - margin, TASK_HEIGHT);
        this.tasksList = tasksList;
    }

    public Task(TasksList tasksList, String title, String description) {
        super(0, 0, Main.TASKS_WIDTH - margin - margin, TASK_HEIGHT);
        this.tasksList = tasksList;
        this.title = title;
        this.description = description;
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 250));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        g.setColor(Color.BLACK);
        g.drawString("Hello", 20, 20);   
    }

    @Override
    public void onClick() {
        tasksList.requestFocus(this);
    }
}
