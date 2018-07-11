import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Opens application by clicking the button.
 * To open a different application, change '/Applications/Microsoft Excel.app' to
 * the preferred application and also change the button text. 
 * @author LoganDuck
 * @version 07/11/18
 */
public class OpenApplication {
	private static JButton button;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Open Application");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(300, 150));
		frame.setMaximumSize(new Dimension(300, 150));
		
		button = new JButton("Open Microsoft Excel");
		button.addActionListener(new OpenApplicationAction());
		frame.add(button);
		
		button.setBounds(60, 50, 180, 30);

		frame.setVisible(true);
	}
}

class OpenApplicationAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("button clicked");
		try {
			Desktop.getDesktop().open(new File("/Applications/Microsoft Excel.app"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}