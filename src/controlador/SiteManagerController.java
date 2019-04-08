package controlador;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import model.ProjectM07FTPDadesConnexio;
import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPSiteManagerDialog;

public class SiteManagerController {

	private ProjectM07FTPDadesConnexio dadesConnexio;
	private ProjectM07FTPClient clientFtp;
	private ProjectM07FTPSiteManagerDialog siteManager;

	public SiteManagerController(ProjectM07FTPDadesConnexio dadesConnexio, ProjectM07FTPClient clientFtp,
			ProjectM07FTPSiteManagerDialog siteManager) {
		this.dadesConnexio = dadesConnexio;
		this.clientFtp = clientFtp;
		this.siteManager = siteManager;
		this.clientFtp.getBtnConnect().addActionListener(e -> saveConnection());
		this.siteManager.getBtnSaveAndConnect().addActionListener(e -> saveConnectAsFile());
		addListenersToMenuBar();
	}

	public SiteManagerController() {

	}

	public void addListenersToMenuBar() {
		clientFtp.getMenuItemFile().addActionListener(e -> openSiteManager());
	}

	protected void openSiteManager() {
		siteManager.setModal(true);
		siteManager.setVisible(true);
	}

	public void saveConnection() {

		dadesConnexio.setHost(clientFtp.getHostFastConn());
		dadesConnexio.setPort(Integer.parseInt(clientFtp.getPortTextFastConn()));
		dadesConnexio.setUser(clientFtp.getUserFastConn());
		dadesConnexio.setPassword(clientFtp.getFieldPasswordFastConn().getText());
		

		connectToServer(dadesConnexio.getHost(), String.valueOf(dadesConnexio.getPort()), dadesConnexio.getUser(),
				dadesConnexio.getPassword());
	}

	public void saveConnectAsFile() {
		dadesConnexio.setHost(siteManager.getGeneralHost());
		dadesConnexio.setPort(Integer.parseInt(siteManager.getGeneralPort().toString()));
		dadesConnexio.setUser(siteManager.getGeneralUser());
		dadesConnexio.setPassword(siteManager.getPasswordFieldGeneralPassword().getText());

		Properties properties = new Properties();
		properties.put("Host", dadesConnexio.getHost());
		properties.put("Port", String.valueOf(dadesConnexio.getPort()));
		properties.put("User", dadesConnexio.getUser());
		try {
			properties.store(new FileOutputStream("dadesConnexio.txt"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectToServer(dadesConnexio.getHost(), String.valueOf(dadesConnexio.getPort()), dadesConnexio.getUser(),
				dadesConnexio.getPassword());

	}

	public void connectToServer(String host, String port, String user, String password) {

		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(host, Integer.parseInt(port));
			ftpClient.login(user, password);
			for (FTPFile file: ftpClient.listFiles()) {
				System.out.println(file.getName());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
