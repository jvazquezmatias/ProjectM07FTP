package controlador;

import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPSettingsDialog;

public class SettingsController {
	private ProjectM07FTPSettingsDialog settings;
	private ProjectM07FTPClient clientFtp;

	public SettingsController(ProjectM07FTPSettingsDialog settings, ProjectM07FTPClient clientFtp) {
		this.settings = settings;
		this.clientFtp = clientFtp;
		addListener();
	}
	
	public void addListener() {
		clientFtp.getMenuItemSettings().addActionListener(e -> abrirSettings());
	}

	private void abrirSettings() {
		settings.setModal(true);
		settings.setVisible(true);
	}
}
