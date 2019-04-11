package controlador;

import javax.swing.JOptionPane;

import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPDialogBeforeOpen;

public class WelcomeController {
	private ProjectM07FTPClient clientFtp;

	public WelcomeController(ProjectM07FTPClient clientFtp) {
		this.clientFtp = clientFtp;
		addListenersToMenuBar();
	}

	public void addListenersToMenuBar() {

		clientFtp.getMntmOpenWelcomeDialog().addActionListener(e -> openWelcomeDialog());
	}

	protected void openWelcomeDialog() {
		ProjectM07FTPDialogBeforeOpen panel = new ProjectM07FTPDialogBeforeOpen();
		JOptionPane.showMessageDialog(clientFtp, panel, "Welcome", JOptionPane.PLAIN_MESSAGE);
	}
}
