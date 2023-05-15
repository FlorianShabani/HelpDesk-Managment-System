package startup;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import tasks.StandardTask;
import tasks.Task;
import tasks.UrgentTask;
public class TasksCreate extends JPanel {
    private static final long serialVersionUID = 1L;

    JTextField title, description;
    Checkbox urgent;

    /**
     * Create new form
     */
    @SuppressWarnings("static-access")
    public TasksCreate() {
        super(new GridLayout(8, 2));

        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(181, 229, 237));
        UI.put("Panel.background", new ColorUIResource(181, 229, 237));
        UI.put("Button.background", new Color(181, 229, 237));
        UI.put("CheckBox.background", new Color(181, 229, 237));

        title = new JTextField(20);
        description = new JTextField(30);
        urgent = new Checkbox();

        this.setBackground(new Color(181, 229, 237, 50));
        title.setBackground(new Color(181, 229, 237, 50));
        description.setBackground(new Color(181, 229, 237, 50));
        urgent.setBackground(new Color(181, 229, 237, 50));

        this.add(new JLabel("Title : "));
        this.add(title);
        // this.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Description :"));
        this.add(description);
        this.add(new JLabel("Urgent?     :"));
        this.add(urgent);
    }

    /**
     * Creates JOptionPane that shows the inputs to create a new appointment and
     * returns it
     * 
     * @return
     */
    public Task getTask(TasksList tasksList) {
        int result = JOptionPane.showConfirmDialog(null, this, "Enter Date and Description",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                return urgent.getState() ? new UrgentTask(tasksList, title.getText(), description.getText())
                        : new StandardTask(tasksList, title.getText(), description.getText());

            } catch (Exception e) {
                return null;
            }
        } else
            return null;
    }
}