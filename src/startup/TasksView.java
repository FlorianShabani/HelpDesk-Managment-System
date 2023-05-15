package startup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import entities.Component;
import tasks.StandardTask;
import tasks.Task;
import tasks.UrgentTask;

public class TasksView extends Component{
    Task focusedTask = new StandardTask(null, "", "");

    public TasksView(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        if(focusedTask instanceof UrgentTask) {
            g.setColor(new Color(200, 50, 50, 150));
            g.fillRoundRect(0, 0, width, 70, padding, padding);


            g.setColor(new Color(170, 30, 30, 255));
            Font f = new Font("Times New Roman", Font.BOLD, 16);
            g.setFont(f);
            g.drawString("Urgent", 700, 40);
        }

        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 16);
		g.setFont(f);
        g.drawString(focusedTask.getTitle(), 20, 40);

        f = new Font("Times New Roman", Font.PLAIN, 12);
		g.setFont(f);
        Main.drawTextInBox((Graphics2D) g, focusedTask.getDescription(), 20, 100, width - 100, height,  20);
    }
    
    public void requestFocus(Task t) {
        focusedTask = t;
    }   
}
