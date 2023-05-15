package entities;

import java.awt.Color;
import java.awt.Graphics;

import startup.TasksList;

public class NextButton extends Component implements Clickable{

    TasksList tasksList;

    public NextButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
    }

    @Override
    public void onClick() {
        tasksList.nextPage();
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);
    }
    
}
