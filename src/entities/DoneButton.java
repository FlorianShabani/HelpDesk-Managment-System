package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import startup.TasksView;

public class DoneButton extends Component implements Clickable {

    TasksView tasksView;

    public DoneButton(int x, int y, int width, int height, TasksView tasksView) {
        super(x, y, width, height);
        this.tasksView = tasksView;
    }

    @Override
    public void onClick() {
        tasksView.getFocusedTask().setDone(true);
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(161, 250, 227, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 15);
        g.setFont(f);

        g.drawString("Mark Done", 13, 30);
    }

}
