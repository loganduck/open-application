import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

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
		int frameCenterX = (frame.getWidth() - button.getPreferredSize().width) / 2;
		int frameCenterY = frame.getHeight() / 2 - button.getPreferredSize().height;
		
		button.setBounds(frameCenterX, frameCenterY,
				button.getPreferredSize().width, button.getPreferredSize().height);
		
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