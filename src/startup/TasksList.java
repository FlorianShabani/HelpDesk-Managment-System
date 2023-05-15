package startup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entities.Component;
import tasks.StandardTask;
import tasks.Task;
import tasks.UrgentTask;;

public class TasksList extends Component {

    ArrayList<Task> tasksList = new ArrayList<Task>();
    TasksView tasksView;

    public static int perPageView = 7, page = 0;

    public TasksList(int x, int y, int width, int height, TasksView tasksView) {
        super(x, y, width, height);
        this.tasksView = tasksView;

        for (int i = 0; i < 25; i++) {
            if (i < 5)
                addTask(new UrgentTask(this, "Task " + i,
                        "Task Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse at ipsum quis erat rhoncus interdum. Donec sollicitudin, elit a egestas pellentesque, odio tortor semper eros, vitae suscipit elit lorem sit amet dolor. Cras id ullamcorper enim. Maecenas fermentum mattis lacinia. Sed tincidunt risus odio, lobortis suscipit elit pulvinar id. Integer vel lectus lorem. Nam et elit sit amet diam tincidunt porta quis et tellus. Pellentesque magna neque, lacinia ut faucibus vitae, facilisis vitae lacus. Proin nulla dui, ornare eget lacinia vel, tincidunt in nisi. Nulla facilisi. Nullam at lacus nec dolor dapibus porttitor. Vivamus consectetur felis tortor, vel blandit risus mollis a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis at consectetur ligula. Sed vitae rutrum ante. Maecenas et nunc ultrices, convallis nunc ut, sodales elit"
                                + i));
            else
                addTask(new StandardTask(this, "Task " + i,
                        "Task Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse at ipsum quis erat rhoncus interdum. Donec sollicitudin, elit a egestas pellentesque, odio tortor semper eros, vitae suscipit elit lorem sit amet dolor. Cras id ullamcorper enim. Maecenas fermentum mattis lacinia. Sed tincidunt risus odio, lobortis suscipit elit pulvinar id. Integer vel lectus lorem. Nam et elit sit amet diam tincidunt porta quis et tellus. Pellentesque magna neque, lacinia ut faucibus vitae, facilisis vitae lacus. Proin nulla dui, ornare eget lacinia vel, tincidunt in nisi. Nulla facilisi. Nullam at lacus nec dolor dapibus porttitor. Vivamus consectetur felis tortor, vel blandit risus mollis a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis at consectetur ligula. Sed vitae rutrum ante. Maecenas et nunc ultrices, convallis nunc ut, sodales elit"
                                + i));

        }

        System.out.println(perPageView);
    }

    public void drawC(Graphics g) {

        g.setColor(new Color(181, 229, 237, 100));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        g.setColor(Color.BLACK);
        g.drawString("Page : " + (page + 1) + "/" + (tasksList.size() / perPageView + 1), 20, 20);

        int y = 20;
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
        if (page < tasksList.size() / perPageView)
            page++;
    }

    public void prevPage() {
        if (page > 0)
            page--;
    }

    public void sort(Comparator<Task> comp) {
        Collections.sort(tasksList, comp);
    }
}
