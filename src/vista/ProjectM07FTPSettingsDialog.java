package vista;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.net.URISyntaxException;

import javax.swing.JDialog;

public class ProjectM07FTPSettingsDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectM07FTPSettingsPanel dialogContent;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws AWTException 
	 * @throws URISyntaxException 
	 * @throws HeadlessException 
	 */
	public ProjectM07FTPSettingsDialog() throws HeadlessException, URISyntaxException, AWTException {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Settings");
		setBounds(100, 100, 750, 500);
		dialogContent = new ProjectM07FTPSettingsPanel();
		setContentPane(dialogContent);
	}
	public ProjectM07FTPSettingsPanel getDialogContent() {
		return dialogContent;
	}
}
