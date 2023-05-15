package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Comparator;

import startup.TasksList;
import tasks.Task;

public class SortAddedButton extends Component implements Clickable {
    TasksList tasksList;

    public SortAddedButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
    }

    class SortAdded implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            if (task1.getId() > task2.getId()) {
                return 1;
            } else
                return -1;
        }
    }

    @Override
    public void onClick() {
        tasksList.sort(new SortAdded());
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(161, 209, 227, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 15);
        g.setFont(f);
        g.drawString("Added", 13, 30);

    }

}
