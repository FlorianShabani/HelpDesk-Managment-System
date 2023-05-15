package startup;

import java.awt.Color;
import java.awt.Graphics;

import entities.Component;
import tasks.Task;

public class TasksView extends Component{


    public TasksView(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }
    
    public void requestFocus(Task t) {
        System.out.println("worked bitch");
    }   
}
