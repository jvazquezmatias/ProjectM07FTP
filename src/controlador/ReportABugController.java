package controlador;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import vista.ProjectM07FTPClient;

public class ReportABugController {
	
	private ProjectM07FTPClient clientFtp;

	public ReportABugController(ProjectM07FTPClient clientFtp) {
		this.clientFtp = clientFtp;
		addListenersToMenuBar();
	}

	public void addListenersToMenuBar() {

		clientFtp.getMenuItemReportBug().addActionListener(e -> {
			try {
				openReportABugUrl();
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	protected void openReportABugUrl() throws IOException, URISyntaxException {

		URI uri = new URI("https://filezilla-project.org/support.php?type=client&mode=bugreport&version=3.41.2");
		if (Desktop.isDesktopSupported()) {

			Desktop.getDesktop().browse(uri);

		}

	}
}
