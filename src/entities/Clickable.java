package entities;

import java.awt.event.MouseEvent;

public interface Clickable {
    public void onClick();

    public default void clicked(MouseEvent e) {
        Component c = (Component) this;
        if (e.getX() >= c.getX() && e.getX() <= c.getX() + c.getWidth()
         && e.getY() >= c.getY() && e.getY() <= c.getY() + c.getHeight()) {
            //Click is Inside of the component
            onClick();  
         }
    }
}
