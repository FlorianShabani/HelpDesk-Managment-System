package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Comparator;

import startup.TasksList;
import tasks.Task;
import tasks.UrgentTask;

public class SortUrgentButton extends Component implements Clickable {
    TasksList tasksList;

    public SortUrgentButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
    }

    class SortUrgent implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            if (task1 instanceof UrgentTask && !(task2 instanceof UrgentTask)) {
                return -1;
            } else
                return 0;
        }
    }

    @Override
    public void onClick() {
        tasksList.sort(new SortUrgent());
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(161, 209, 227, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);


        g.setColor(Color.BLACK);
        Font f = new Font("Times New Roman", Font.BOLD, 15);
		g.setFont(f);
        g.drawString("Urgent", 13, 30);

    }

}
