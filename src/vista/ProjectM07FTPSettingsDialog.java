package activities;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.net.URISyntaxException;

import javax.swing.JDialog;

public class ProjectM07FTPSettingsDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProjectM07FTPSettingsDialog dialog = new ProjectM07FTPSettingsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws AWTException 
	 * @throws URISyntaxException 
	 * @throws HeadlessException 
	 */
	public ProjectM07FTPSettingsDialog() throws HeadlessException, URISyntaxException, AWTException {
		setTitle("Settings");
		setBounds(100, 100, 750, 500);
		ProjectM07FTPSettingsPanel dialogContent = new ProjectM07FTPSettingsPanel();
		setContentPane(dialogContent);
	}
}
