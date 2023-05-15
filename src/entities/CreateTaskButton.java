package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import startup.TasksCreate;
import startup.TasksList;

public class CreateTaskButton extends Component implements Clickable {

    TasksList tasksList;
    TasksCreate taskForm;

    public CreateTaskButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
        taskForm = new TasksCreate();
    }

    @Override
    public void onClick() {
        tasksList.addTask(taskForm.getTask(tasksList));
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(161, 209, 227, 255));
        g.fillRoundRect(0, 0, width, height, padding, padding);

    
        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 16);
		g.setFont(f);
        g.drawString("Create New Task", 20, 43);        
    }
}
