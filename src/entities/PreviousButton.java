package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import startup.TasksList;

public class PreviousButton extends Component implements Clickable{

    TasksList tasksList;

    public PreviousButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
    }

    @Override
    public void onClick() {
        tasksList.prevPage();
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);


        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 20);
		g.setFont(f);
        g.drawString("<", 15, 30);
    }
    
}
