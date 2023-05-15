package startup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import entities.Component;
import tasks.Task;;

public class TasksList extends Component {

    ArrayList<Task> tasksList = new ArrayList<Task>();
    TasksView tasksView;


    public TasksList(int x, int y, int width, int height, TasksView tasksView) {
        super(x, y, width, height);
        this.tasksView = tasksView;

        tasksList.add(new Task(this));

        tasksList.add(new Task(this));

        tasksList.add(new Task(this));

        tasksList.add(new Task(this));

        tasksList.add(new Task(this));

        tasksList.add(new Task(this));
    }

    public void drawC(Graphics g) {

        g.setColor(new Color(181, 229, 237, 100));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        int y = 0;
        for(Task t : tasksList) {
            t.draw(0, y, g);
            t.setX(this.x);
            t.setY(this.y + y);
            y += t.getHeight();
        }
    }

    public void addTask() {
        tasksList.add(new Task(this));
    }

    public void requestFocus(Task t) {
        tasksView.requestFocus(t);
    }

    public void onClick(MouseEvent e) {
        for(Task t : tasksList) {
            t.clicked(e);
        }
    }

}
