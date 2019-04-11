package controlador;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("dadesConnexio.txt"));
			readParametersAsFile(properties);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public SiteManagerController() {

	}

	public void readParametersAsFile(Properties properties) {

		if (!properties.isEmpty()) {
			dadesConnexio.setHost(properties.getProperty("Host"));
			dadesConnexio.setPort(Integer.parseInt(properties.getProperty("Port")));
			dadesConnexio.setUser(properties.getProperty("User"));
			dadesConnexio.setPassword(properties.getProperty("Password"));
			buttonConnectionToolBar();
		}
	}

	public void buttonConnectionToolBar() {
		JMenuItem menuItem = new JMenuItem(dadesConnexio.getHost() + " - " + dadesConnexio.getUser());
		menuItem.addActionListener(e -> directoriesServer());
		clientFtp.getMenuSiteManagerToolBar().add(menuItem);

	}

	public void addListenersToMenuBar() {
		clientFtp.getMenuItemFile().addActionListener(e -> openSiteManager());
		clientFtp.getBtnToolBarSiteManager().addActionListener(e -> openSiteManager());
	}

	protected void openSiteManager() {
		siteManager.setModal(true);
		siteManager.setVisible(true);
	}

	public void saveConnection() {

		try {
			dadesConnexio.setHost(clientFtp.getHostFastConn());
			dadesConnexio.setPort(Integer.parseInt(clientFtp.getPortTextFastConn()));
			dadesConnexio.setUser(clientFtp.getUserFastConn());
			dadesConnexio.setPassword(clientFtp.getFieldPasswordFastConn().getText());

			connectToServer(dadesConnexio.getHost(), String.valueOf(dadesConnexio.getPort()), dadesConnexio.getUser(),
					dadesConnexio.getPassword());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(siteManager, "The port field has to be a number.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void saveConnectAsFile() {

		try {
			dadesConnexio.setHost(siteManager.getGeneralHost());
			dadesConnexio.setPort(Integer.parseInt(siteManager.getGeneralPort().toString()));
			dadesConnexio.setUser(siteManager.getGeneralUser());
			dadesConnexio.setPassword(siteManager.getPasswordFieldGeneralPassword().getText());

			Properties properties = new Properties();
			properties.put("Host", dadesConnexio.getHost());
			properties.put("Port", String.valueOf(dadesConnexio.getPort()));
			properties.put("User", dadesConnexio.getUser());
			properties.put("Password", dadesConnexio.getPassword());
			try {
				properties.store(new FileOutputStream("dadesConnexio.txt"), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connectToServer(dadesConnexio.getHost(), String.valueOf(dadesConnexio.getPort()), dadesConnexio.getUser(),
					dadesConnexio.getPassword());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(siteManager, "The port field has to be a number.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void connectToServer(String host, String port, String user, String password) {

		FTPClient ftpClient = new FTPClient();

		try {
			ftpClient.connect(host, Integer.parseInt(port));
			ftpClient.login(user, password);
			for (FTPFile file : ftpClient.listFiles()) {
				System.out.println(file.getName());
			}
			siteManager.dispose();
		} catch (NumberFormatException | IOException e) {
			JOptionPane.showMessageDialog(siteManager, "Could not connect to server.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public FTPFile[] directoriesServer() {
		FTPClient ftpClient = new FTPClient();
		FTPFile[] files = new FTPFile[0];

		try {
			ftpClient.connect(dadesConnexio.getHost(), dadesConnexio.getPort());
			ftpClient.login(dadesConnexio.getUser(), dadesConnexio.getPassword());
			files = ftpClient.listDirectories();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} catch (NumberFormatException | IOException e) {
			JOptionPane.showMessageDialog(siteManager, "Could not connect to server.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return files;
	}

}
