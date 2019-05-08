package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;

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
		settings.getDialogContent().getTree().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				settings.getDialogContent().seleccionarScreen(e);
			}
		});
		settings.getDialogContent().getBtnNewButton_2().addActionListener(e -> escollirFitxer());
	}

	private void escollirFitxer() {
		JFileChooser fileChooser = new JFileChooser();
		 
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
 
        fileChooser.setAcceptAllFileFilterUsed(false);
 
        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
        	settings.getDialogContent().getTextField().setText(fileChooser.getSelectedFile().toString()+"/ftpclient.log");
        }
      }

	private void abrirSettings() {
		//settings.setModal(true);
		settings.setVisible(true);
		settings.setResizable(false);
		settings.pack();
	}
}