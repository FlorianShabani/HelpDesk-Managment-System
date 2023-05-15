package tasks;

import java.awt.Color;
import java.awt.Graphics;

import entities.Clickable;
import entities.Component;
import startup.Main;
import startup.TasksList;

public abstract class Task extends Component implements Clickable{
    public static int ID_CURRENT = 0;

    boolean done = false;

    public int id;

    TasksList tasksList;

    public String title, description;

    public int getId() {
        return id;
    }

    public Task(TasksList tasksList) {
        super(0, 0, Main.TASKS_WIDTH - margin - margin, Main.TASK_HEIGHT);
        this.tasksList = tasksList;

        this.id = ID_CURRENT;
        ID_CURRENT++;

        this.title = "";
        this.description = "";
    }

    public Task(TasksList tasksList, String title, String description) {
        this(tasksList);
        this.title = title;
        this.description = description;
    }

    @Override
    public void drawC(Graphics g) {
        if(!done) {
            drawDecorations(g);
        }else {
            drawDone(g);
        }

        g.setColor(Color.BLACK);
        g.drawString(title, 20, 20);   
    }

    @Override
    public void onClick() {
        tasksList.requestFocus(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void drawDone(Graphics g) {
        g.setColor(new Color(0, 255, 0, 50));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }

    public void drawDecorations(Graphics g) {
        g.setColor(new Color(181, 229, 237, 250));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
