package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;

import startup.TasksList;
import tasks.Task;
import tasks.UrgentTask;

public class SortAddedButton extends Component implements Clickable {
    TasksList tasksList;

    public SortAddedButton(int x, int y, int width, int height, TasksList tasksList) {
        super(x, y, width, height);
        this.tasksList = tasksList;
    }

    class SortAdded implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            if (task1 instanceof UrgentTask) {
                return 1;
            } else
                return 0;
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

    }

}
