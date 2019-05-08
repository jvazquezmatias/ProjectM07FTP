package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import model.ProjectM07FTPDadesConnexio;
import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPSiteManagerDialog;
import vista.ProjectM07FTPTreePanel;

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
		buttonConnectionToolBar();

	}

	public SiteManagerController() {

	}

	public void readParametersAsFile(Properties properties) {

		if (!properties.isEmpty()) {
			dadesConnexio.setConnectionName(properties.getProperty("ConnectionName"));
			dadesConnexio.setHost(properties.getProperty("Host"));
			dadesConnexio.setPort(Integer.parseInt(properties.getProperty("Port")));
			dadesConnexio.setUser(properties.getProperty("User"));
			dadesConnexio.setPassword(properties.getProperty("Password"));
		}
	}

	public void buttonConnectionToolBar() {
		clientFtp.getMenuSiteManagerToolBar().removeAll();
		File directory = new File("ftpConnections");
		File[] files = directory.listFiles();

		for (int i = 0; i < files.length; i++) {
			Properties properties = createProperties(files[i].getName());
			readParametersAsFile(properties);
			JMenuItem menuItem = new JMenuItem(dadesConnexio.getConnectionName());
			menuItem.addActionListener(e -> crearTree(e));
			clientFtp.getMenuSiteManagerToolBar().add(menuItem);
		}

	}

	public void crearTree(ActionEvent e) {
		clientFtp.getPanel_3().add(new ProjectM07FTPTreePanel("/", clientFtp.getPanel_4(), getDirectoriesFtp("/", e)));
		clientFtp.getPanel_3().repaint();
		clientFtp.getPanel_3().revalidate();
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
			dadesConnexio.setConnectionName(siteManager.getConnectionNameSiteManager());
			dadesConnexio.setHost(siteManager.getGeneralHost());
			dadesConnexio.setPort(Integer.parseInt(siteManager.getGeneralPort().toString()));
			dadesConnexio.setUser(siteManager.getGeneralUser());
			dadesConnexio.setPassword(siteManager.getPasswordFieldGeneralPassword().getText());

			Properties properties = new Properties();
			properties.put("ConnectionName", dadesConnexio.getConnectionName());
			properties.put("Host", dadesConnexio.getHost());
			properties.put("Port", String.valueOf(dadesConnexio.getPort()));
			properties.put("User", dadesConnexio.getUser());
			properties.put("Password", dadesConnexio.getPassword());
			try {
				properties.store(
						new FileOutputStream("ftpConnections/" + siteManager.getConnectionNameSiteManager() + ".txt"),
						null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			buttonConnectionToolBar();
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

	public FTPFile[] serverDirectories(ActionEvent e) {

		readParametersAsFile(createProperties(e.getActionCommand() + ".txt"));
		FTPClient ftpClient = new FTPClient();
		FTPFile[] files = new FTPFile[0];
		System.out.println(dadesConnexio.getConnectionName());
		try {
			ftpClient.connect(dadesConnexio.getHost(), dadesConnexio.getPort());
			ftpClient.login(dadesConnexio.getUser(), dadesConnexio.getPassword());
			files = ftpClient.listDirectories();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} catch (NumberFormatException | IOException f) {
			JOptionPane.showMessageDialog(siteManager, "Could not connect to server.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return files;
	}

	public Properties createProperties(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("ftpConnections/" + fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return properties;
	}

	public ArrayList<Object[]> getDirectoriesFtp(String path, ActionEvent e) {

		try {
			readParametersAsFile(createProperties(e.getActionCommand() + ".txt"));
			FTPClient ftpClient = new FTPClient();
			ArrayList<Object[]> filesAndDirectories = new ArrayList<>();
			FTPFile[] files = new FTPFile[0];
			ftpClient.connect(dadesConnexio.getHost(), dadesConnexio.getPort());
			ftpClient.login(dadesConnexio.getUser(), dadesConnexio.getPassword());
			files = ftpClient.listFiles(path);

			for (FTPFile ftpFile : files) {
				Object[] file = new Object[4];
				file[0] = ftpFile.getName();
				if (ftpFile.isDirectory()) {
					file[1] = "";
					file[2] = "directory";
				} else {
					file[1] = ftpFile.getSize();
					String extension = ftpFile.getName().substring(ftpFile.getName().lastIndexOf("."));
					if (extension.equals("")) {
						file[2] = "file";

					} else {
						file[2] = extension + "-file";
					}
					file[3] = ftpFile.getTimestamp().getTime().toString();
				}
				filesAndDirectories.add(file);
			}
			for (int i = 0; i < filesAndDirectories.size(); i++) {
				Object[] filee = filesAndDirectories.get(i);
				System.out.println(filee[0]);
				System.out.println(filee[1]);
				System.out.println(filee[2]);
				System.out.println(filee[3]);
				System.out.println("---------------------------");
			}

			return filesAndDirectories;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
