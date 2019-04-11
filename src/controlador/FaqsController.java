package controlador;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import vista.ProjectM07FTPClient;

public class FaqsController {

	private ProjectM07FTPClient clientFtp;

	public FaqsController(ProjectM07FTPClient clientFtp) {
		this.clientFtp = clientFtp;
		addListenersToMenuBar();
	}

	public void addListenersToMenuBar() {

		clientFtp.getMenuItemFaqs().addActionListener(e -> {
			try {
				openFaqsUrl();
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	protected void openFaqsUrl() throws IOException, URISyntaxException {

		URI uri = new URI("https://filezilla-project.org/support.php?type=client&mode=help&version=3.41.2");
		if (Desktop.isDesktopSupported()) {

			Desktop.getDesktop().browse(uri);

		}

	}

}
