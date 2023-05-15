package startup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import entities.Component;
import tasks.StandardTask;
import tasks.Task;;

public class TasksList extends Component {

    ArrayList<Task> tasksList = new ArrayList<Task>();
    TasksView tasksView;

    public static int perPageView = 7, page = 0;

    public TasksList(int x, int y, int width, int height, TasksView tasksView) {
        super(x, y, width, height);
        this.tasksView = tasksView;

        for (int i = 0; i < 25; i++) {
            addTask(new StandardTask(this, "Task " + i, "Task " + i));
        }

        System.out.println(perPageView);
    }

    public void drawC(Graphics g) {

        g.setColor(new Color(181, 229, 237, 100));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        int y = 0;
        for (int i = 0; i < tasksList.size(); i++) {
            Task t = tasksList.get(i);
            if (i >= (page * perPageView) && i < ((page + 1) * perPageView)) {
                t.draw(0, y, g);
                t.setX(this.x);
                t.setY(this.y + y);
                y += t.getHeight();
            }
        }
    }

    public void addTask() {
        tasksList.add(new StandardTask(this, "Title", "Description"));
    }

    public void addTask(Task t) {
        tasksList.add(t);
    }

    public void requestFocus(Task t) {
        tasksView.requestFocus(t);
    }

    public void onClick(MouseEvent e) {
        for (int i = 0; i < tasksList.size(); i++) {
            Task t = tasksList.get(i);
            if (i >= (page * perPageView) && i < ((page + 1) * perPageView)) {
                t.clicked(e);
            }
        }
    }

    public void nextPage() {
    }

    public void prevPage() {
    }
}
