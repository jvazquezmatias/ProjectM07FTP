package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ProjectM07FTPDadesConnexio;

import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectM07FTPSiteManagerDialog extends JDialog {

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	private JTextField textFieldGeneralHost;
	private JTextField textFieldGeneralUser;
	private JPasswordField passwordFieldGeneralPassword;
	private ButtonGroup buttonGroupTabTranferSettings = new ButtonGroup();

	private JTextField textFieldAdvancedLocalDirectory;
	private JTextField textFieldAdvancedRemoteDirectory;
	private JTextField textFieldEncoding;
	private final ButtonGroup buttonGroupTabCharset = new ButtonGroup();
	private JTextField textFieldGeneralAccount;

	private ProjectM07FTPDadesConnexio dadesConnexio;
	private JButton btnSaveAndConnect;
	private JTextField textFieldGeneralPort;

	public ProjectM07FTPSiteManagerDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 717, 443);
		contentPane.add(tabbedPane);
		
		btnSaveAndConnect = new JButton("Save and Connect");
		btnSaveAndConnect.setBounds(548, 450, 157, 25);
		contentPane.add(btnSaveAndConnect);

		addTabGeneral();
		addTabAdvanced();
		addTabTransferSettings();
		addTabCharset();

	}

	private void addTabGeneral() {
		dadesConnexio = new ProjectM07FTPDadesConnexio();
		Panel generalPanel = new Panel();
		tabbedPane.addTab("General", null, generalPanel, null);
		generalPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Protocol:");
		lblNewLabel.setBounds(12, 12, 85, 15);
		generalPanel.add(lblNewLabel);

		JComboBox comboBoxGeneralProtocol = new JComboBox();
		comboBoxGeneralProtocol.setModel(new DefaultComboBoxModel(new String[] { "FTP - File Transfer Protocol",
				"SFTP - SSH File Transfer Protocol", "Storj - Decentralized Colud Storage" }));
		comboBoxGeneralProtocol.setBounds(150, 7, 550, 24);
		generalPanel.add(comboBoxGeneralProtocol);

		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(12, 41, 85, 15);
		generalPanel.add(lblHost);

		textFieldGeneralHost = new JTextField();
		textFieldGeneralHost.setColumns(10);
		textFieldGeneralHost.setBounds(150, 37, 397, 24);
		generalPanel.add(textFieldGeneralHost);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(565, 41, 66, 15);
		generalPanel.add(lblPort);

		textFieldGeneralPort = new JTextField();
		textFieldGeneralPort.setBounds(649, 37, 51, 24);
		generalPanel.add(textFieldGeneralPort);
		textFieldGeneralPort.setColumns(10);

		JLabel lblEncryption = new JLabel("Encryption:");
		lblEncryption.setBounds(12, 73, 85, 15);
		generalPanel.add(lblEncryption);

		JComboBox comboBoxGeneralEncryption = new JComboBox();
		comboBoxGeneralEncryption
				.setModel(new DefaultComboBoxModel(new String[] { "Use explicit FTP over TLS if available",
						"Require explicit FTP over", "Require implicit FTP over", "Only use plain FTP (insecure)" }));
		comboBoxGeneralEncryption.setBounds(150, 68, 550, 24);
		generalPanel.add(comboBoxGeneralEncryption);

		JLabel lblLogonType = new JLabel("Logon Type:");
		lblLogonType.setBounds(12, 130, 85, 15);
		generalPanel.add(lblLogonType);

		JComboBox comboBoxGeneralLogonType = new JComboBox();
		comboBoxGeneralLogonType.setModel(new DefaultComboBoxModel(
				new String[] { "Anonymous", "Normal", "Ask for password", "Interactive", "Account" }));
		comboBoxGeneralLogonType.setSelectedIndex(1);
		comboBoxGeneralLogonType.setBounds(150, 125, 550, 24);
		generalPanel.add(comboBoxGeneralLogonType);

		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(12, 161, 85, 15);
		generalPanel.add(lblUser);

		textFieldGeneralUser = new JTextField();
		textFieldGeneralUser.setColumns(10);
		textFieldGeneralUser.setBounds(150, 157, 550, 24);
		generalPanel.add(textFieldGeneralUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 192, 85, 15);
		generalPanel.add(lblPassword);

		passwordFieldGeneralPassword = new JPasswordField();
		passwordFieldGeneralPassword.setBounds(150, 193, 550, 24);
		generalPanel.add(passwordFieldGeneralPassword);

		JLabel lblBackgroundColor = new JLabel("Background color:");
		lblBackgroundColor.setBounds(12, 276, 137, 15);
		generalPanel.add(lblBackgroundColor);

		JComboBox comboBoxGeneralBackgroundColor = new JComboBox();
		comboBoxGeneralBackgroundColor.setBounds(167, 271, 85, 24);
		generalPanel.add(comboBoxGeneralBackgroundColor);

		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(12, 309, 137, 15);
		generalPanel.add(lblComments);

		JTextArea textAreaGeneralComments = new JTextArea();
		textAreaGeneralComments.setBounds(12, 336, 688, 68);
		generalPanel.add(textAreaGeneralComments);

		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setBounds(12, 233, 85, 15);
		generalPanel.add(lblAccount);

		textFieldGeneralAccount = new JTextField();
		textFieldGeneralAccount.setColumns(10);
		textFieldGeneralAccount.setBounds(150, 229, 550, 24);
		generalPanel.add(textFieldGeneralAccount);
	}

	private void addTabAdvanced() {
		// Create panel
		Panel advancedPanel = new Panel();
		tabbedPane.addTab("Advanced", null, advancedPanel, null);
		advancedPanel.setLayout(null);

		// Create label ServerType
		JLabel serverTypeLabel = new JLabel("Server Type: ");
		serverTypeLabel.setBounds(8, 10, 91, 15);
		serverTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		advancedPanel.add(serverTypeLabel);

		// Create comboBox ServerType
		JComboBox comboBoxAdvancedServerType;
		comboBoxAdvancedServerType = new JComboBox();
		comboBoxAdvancedServerType.setBounds(129, 5, 571, 25);
		// Create and add comboBox items
		String[] ServerTypeComboBoxItems = { "Default (Autodetect)", "Unix", "VMS", "DOS with backslash separators",
				"MVS, OS/390, z/OS", "VxWORKS", "z/VM", "HP NonStop", "DOS-like with virtual paths", "Cygwin",
				"DOS with forward-slash separatos" };
		comboBoxAdvancedServerType.setModel(new DefaultComboBoxModel<String>(ServerTypeComboBoxItems));
		advancedPanel.add(comboBoxAdvancedServerType);

		JCheckBox checkBoxAdvancedByPassProxy = new JCheckBox("Bypass proxy");
		checkBoxAdvancedByPassProxy.setOpaque(false);
		checkBoxAdvancedByPassProxy.setBounds(8, 47, 126, 23);
		advancedPanel.add(checkBoxAdvancedByPassProxy);

		JLabel localDirectoryLabel = new JLabel("Default local directory:");
		localDirectoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		localDirectoryLabel.setBounds(8, 90, 157, 15);
		advancedPanel.add(localDirectoryLabel);

		textFieldAdvancedLocalDirectory = new JTextField();
		textFieldAdvancedLocalDirectory.setBounds(8, 111, 579, 25);
		advancedPanel.add(textFieldAdvancedLocalDirectory);
		textFieldAdvancedLocalDirectory.setColumns(10);

		JLabel remoteDirectoryLabel = new JLabel("Default remote directory:");
		remoteDirectoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		remoteDirectoryLabel.setBounds(8, 145, 174, 15);
		advancedPanel.add(remoteDirectoryLabel);

		textFieldAdvancedRemoteDirectory = new JTextField();
		textFieldAdvancedRemoteDirectory.setColumns(10);
		textFieldAdvancedRemoteDirectory.setBounds(8, 162, 692, 25);
		advancedPanel.add(textFieldAdvancedRemoteDirectory);

		JButton buttonAdvancedLocalDirectory = new JButton("Browse...");
		buttonAdvancedLocalDirectory.setMargin(new Insets(2, 0, 2, 0));
		buttonAdvancedLocalDirectory.setBounds(599, 111, 98, 25);
		advancedPanel.add(buttonAdvancedLocalDirectory);

		JSeparator separator = new JSeparator();
		separator.setBounds(8, 78, 692, 2);
		advancedPanel.add(separator);

		JCheckBox chckbxAdvancedUseSynchronizedBrowsing = new JCheckBox("Use synchronized browsing");
		chckbxAdvancedUseSynchronizedBrowsing.setOpaque(false);
		chckbxAdvancedUseSynchronizedBrowsing.setBounds(8, 198, 218, 23);
		advancedPanel.add(chckbxAdvancedUseSynchronizedBrowsing);

		JCheckBox chckbxDirectoryComparasion = new JCheckBox("Directory comparison");
		chckbxDirectoryComparasion.setOpaque(false);
		chckbxDirectoryComparasion.setBounds(8, 225, 184, 23);
		advancedPanel.add(chckbxDirectoryComparasion);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(8, 264, 692, 2);
		advancedPanel.add(separator_1);

		JLabel lblAdjustServerTime = new JLabel("Adjust server time, offset by:");
		lblAdjustServerTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdjustServerTime.setBounds(8, 278, 157, 15);
		advancedPanel.add(lblAdjustServerTime);

		JSpinner spinnerHours = new JSpinner();
		spinnerHours.setBounds(9, 320, 40, 20);
		advancedPanel.add(spinnerHours);

		JSpinner spinnerMinutes = new JSpinner();
		spinnerMinutes.setBounds(109, 320, 40, 20);
		advancedPanel.add(spinnerMinutes);

		JLabel lblHours = new JLabel("Hours, ");
		lblHours.setHorizontalAlignment(SwingConstants.LEFT);
		lblHours.setBounds(55, 322, 53, 15);
		advancedPanel.add(lblHours);

		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutes.setBounds(156, 322, 91, 15);
		advancedPanel.add(lblMinutes);
	}

	private void addTabTransferSettings() {

		Panel transferSettingsPanel = new Panel();
		tabbedPane.addTab("Transfer Settings", null, transferSettingsPanel, null);
		transferSettingsPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Transfer mode:");
		lblNewLabel.setBounds(12, 12, 112, 15);
		transferSettingsPanel.add(lblNewLabel);

		JRadioButton rdbtnDefault = new JRadioButton("Default");
		rdbtnDefault.setSelected(true);
		rdbtnDefault.setOpaque(false);
		rdbtnDefault.setBounds(42, 35, 80, 23);
		buttonGroupTabTranferSettings.add(rdbtnDefault);
		transferSettingsPanel.add(rdbtnDefault);

		JRadioButton rdbtnActive = new JRadioButton("Active");
		rdbtnActive.setOpaque(false);
		rdbtnActive.setBounds(136, 35, 80, 23);
		buttonGroupTabTranferSettings.add(rdbtnActive);
		transferSettingsPanel.add(rdbtnActive);

		JRadioButton rdbtnPassive = new JRadioButton("Passive");
		rdbtnPassive.setOpaque(false);
		rdbtnPassive.setBorder(new EmptyBorder(0, 0, 0, 0));
		rdbtnPassive.setBounds(224, 35, 80, 23);
		buttonGroupTabTranferSettings.add(rdbtnPassive);
		transferSettingsPanel.add(rdbtnPassive);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Limit numbers of simultaneous connection");
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(12, 67, 318, 23);
		transferSettingsPanel.add(chckbxNewCheckBox);

		JLabel lblMaxiumNumberOf = new JLabel("Maximum number of connections:");
		lblMaxiumNumberOf.setBounds(42, 93, 245, 15);
		transferSettingsPanel.add(lblMaxiumNumberOf);

		Integer[] monthStrings = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		JSpinner spinner = new JSpinner(monthModel);
		spinner.setOpaque(false);
		spinner.setBounds(288, 91, 42, 20);
		spinner.setEnabled(false);
		transferSettingsPanel.add(spinner);

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				if (chckbxNewCheckBox.isSelected()) {
					spinner.setEnabled(true);
				} else {
					spinner.setEnabled(false);
				}

			}
		});

	}

	private void addTabCharset() {
		// Create panel
		Panel charsetPanel = new Panel();
		tabbedPane.addTab("Charset", null, charsetPanel, null);
		charsetPanel.setLayout(null);

		JLabel lblCharset = new JLabel("<html>The server uses following charset encoding for <br>\nfilenames:<html>");
		lblCharset.setBounds(12, 12, 325, 30);
		charsetPanel.add(lblCharset);

		JRadioButton rdbtnAutodetect = new JRadioButton("Autodetect");
		rdbtnAutodetect.setOpaque(false);
		buttonGroupTabCharset.add(rdbtnAutodetect);
		rdbtnAutodetect.setBounds(12, 50, 144, 23);
		rdbtnAutodetect.setActionCommand("Autodetect");
		charsetPanel.add(rdbtnAutodetect);

		JLabel lbluseUtfIf = new JLabel(
				"<html>Use UTF-8 if the server supports it, else use <br>\nlocal charset.<html>");
		lbluseUtfIf.setBounds(34, 82, 325, 30);
		charsetPanel.add(lbluseUtfIf);

		JRadioButton rdbtnForceUtf = new JRadioButton("Force UTF-8");
		rdbtnForceUtf.setOpaque(false);
		buttonGroupTabCharset.add(rdbtnForceUtf);
		rdbtnForceUtf.setBounds(12, 120, 144, 23);
		charsetPanel.add(rdbtnForceUtf);

		JRadioButton rdbtnUseCustomCharset = new JRadioButton("Use custom charset");
		rdbtnUseCustomCharset.setOpaque(false);
		buttonGroupTabCharset.add(rdbtnUseCustomCharset);
		rdbtnUseCustomCharset.setBounds(12, 157, 164, 23);
		charsetPanel.add(rdbtnUseCustomCharset);

		JLabel lblEncoding = new JLabel("Encoding:");
		lblEncoding.setBounds(34, 192, 75, 15);
		charsetPanel.add(lblEncoding);

		textFieldEncoding = new JTextField();
		textFieldEncoding.setBounds(107, 188, 69, 23);
		charsetPanel.add(textFieldEncoding);
		textFieldEncoding.setColumns(10);
	}


	public JButton getBtnSaveAndConnect() {
		return btnSaveAndConnect;
	}
	public String getGeneralHost() {
		return textFieldGeneralHost.getText();
	}
	public void setGeneralHost(String text) {
		textFieldGeneralHost.setText(text);
	}
	public String getGeneralPort() {
		return textFieldGeneralPort.getText();
	}
	public void setGeneralPort(String text_1) {
		textFieldGeneralPort.setText(text_1);
	}
	public String getGeneralUser() {
		return textFieldGeneralUser.getText();
	}
	public void setGeneralUser(String text_2) {
		textFieldGeneralUser.setText(text_2);
	}
	public JPasswordField getPasswordFieldGeneralPassword() {
		return passwordFieldGeneralPassword;
	}
}
