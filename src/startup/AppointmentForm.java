package startup;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import tasks.Task;
import tasks.UrgentTask;

/**
 * The JPanel provided to the JOptionPane in its getAppointment method
 * which will be used to create a new Appointment
 * @author flori
 *
 */
public class AppointmentForm extends JPanel {
	private static final long serialVersionUID = 1L;

	JTextField title, description;
    Checkbox urgent;
	/**
	 * Create new form
	 */
	@SuppressWarnings("static-access")
	public AppointmentForm() {
		super(new GridLayout(8, 2));

		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new ColorUIResource(255, 200, 100));
		UI.put("Panel.background", new ColorUIResource(255, 200, 100));
		UI.put("Button.background", new Color(255, 230, 180));

		title = new JTextField("hh:mm", 20);
		description = new JTextField(30);
        urgent = new Checkbox();

		this.setBackground(new Color(255, 200, 100));
		title.setBackground(new Color(255, 220, 150));
		description.setBackground(new Color(255, 220, 150));

		this.add(new JLabel("Title : "));
		this.add(title);
		// this.add(Box.createHorizontalStrut(15));
		this.add(new JLabel("Description :"));
		this.add(description);
        this.add(new JLabel("Urgent?     :"));
        this.add(urgent);
	}
	/**
	 * Creates JOptionPane that shows the inputs to create a new appointment and returns it
	 * @return
	 */
	public Task getAppointment(TasksList tasksList) {
		int result = JOptionPane.showConfirmDialog(null, this, "Enter Date and Description",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			try {
			return urgent.getState() ?
                new UrgentTask(tasksList);
                : new StandardTask(tasksList);

			}catch(Exception e) {return null;}
		}else return null;
	}
}