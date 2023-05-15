package startup;

import java.awt.Color;
import java.awt.Graphics;

import entities.Component;
import tasks.Task;

public class TasksView extends Component{
    Task focusedTask = new Task(null, "Defualt Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse at ipsum quis erat rhoncus interdum. Donec sollicitudin, elit a egestas pellentesque, odio tortor semper eros, vitae suscipit elit lorem sit amet dolor. Cras id ullamcorper enim. Maecenas fermentum mattis lacinia. Sed tincidunt risus odio, lobortis suscipit elit pulvinar id. Integer vel lectus lorem. Nam et elit sit amet diam tincidunt porta quis et tellus. Pellentesque magna neque, lacinia ut faucibus vitae, facilisis vitae lacus. Proin nulla dui, ornare eget lacinia vel, tincidunt in nisi. Nulla facilisi. Nullam at lacus nec dolor dapibus porttitor. Vivamus consectetur felis tortor, vel blandit risus mollis a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis at consectetur ligula. Sed vitae rutrum ante. Maecenas et nunc ultrices, convallis nunc ut, sodales elit. ");

    public TasksView(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void drawC(Graphics g) {
        g.setColor(new Color(181, 229, 237, 150));
        g.fillRoundRect(0, 0, width, height, padding, padding);

        g.setColor(Color.BLACK);
        g.drawString(focusedTask.title, margin, margin);
        g.drawString(focusedTask.description, margin, 100);
    }
    
    public void requestFocus(Task t) {
        focusedTask = t;
        System.out.println(t.id);
    }   
}
