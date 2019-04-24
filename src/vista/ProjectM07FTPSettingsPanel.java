package vista;

import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ItemListener;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import vista.ProjectM07FTPClient;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class ProjectM07FTPSettingsPanel extends JPanel {
	JPanel panel;
	private JTree tree;
	CardLayout cardLayoutSettings;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public ProjectM07FTPSettingsPanel() throws URISyntaxException, HeadlessException, AWTException {
		setPreferredSize(new Dimension(750, 500));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 10, 10);
		add(panelMain);
		panelMain.setLayout(null);

		JLabel lblNewLabel = new JLabel("Select page:");
		lblNewLabel.setBounds(12, 12, 113, 15);
		panelMain.add(lblNewLabel);

		Icon leafIcon = new ImageIcon(ProjectM07FTPClient.class.getResource(""));

		tree = new JTree();

		tree.setRootVisible(false);
		tree.setBorder(new LineBorder(new Color(0, 0, 0)));
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Settings") {
			{
				DefaultMutableTreeNode node_1;
				DefaultMutableTreeNode node_2;
				node_1 = new DefaultMutableTreeNode("Connection");
				node_2 = new DefaultMutableTreeNode("FTP");
				node_2.add(new DefaultMutableTreeNode("Active mode"));
				node_2.add(new DefaultMutableTreeNode("Passive mode\t\t"));
				node_2.add(new DefaultMutableTreeNode("FTP Proxy"));
				node_1.add(node_2);
				node_1.add(new DefaultMutableTreeNode("SFTP"));
				node_1.add(new DefaultMutableTreeNode("Generic proxy"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Transfers");
				node_1.add(new DefaultMutableTreeNode("FTP: File Types"));
				node_1.add(new DefaultMutableTreeNode("File exists action"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Interface");
				node_1.add(new DefaultMutableTreeNode("Passwords"));
				node_1.add(new DefaultMutableTreeNode("Themes"));
				node_1.add(new DefaultMutableTreeNode("Data/time format"));
				node_1.add(new DefaultMutableTreeNode("Filesize format"));
				node_1.add(new DefaultMutableTreeNode("File lists"));
				add(node_1);
				add(new DefaultMutableTreeNode("Language"));
				node_1 = new DefaultMutableTreeNode("File editing");
				node_1.add(new DefaultMutableTreeNode("Filetype associations"));
				add(node_1);
				add(new DefaultMutableTreeNode("Updates"));
				add(new DefaultMutableTreeNode("Logging"));
				add(new DefaultMutableTreeNode("Debug"));
			}
		}));
		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		renderer.setLeafIcon(leafIcon);

		tree.setBounds(12, 27, 243, 344);
		panelMain.add(tree);

		panel = new JPanel();
		panel.setBounds(267, 12, 461, 466);
		cardLayoutSettings = new CardLayout(0, 0);
		panel.setLayout(cardLayoutSettings);
		JPanel connectionPanel = new JPanel();
		panel.add(connectionPanel, "connection");
		connectionPanel.setLayout(null);

		JPanel debugPanel = new JPanel();

		panel.add(debugPanel, "debug");
		debugPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Debugging settings");
		lblNewLabel_1.setBounds(12, 31, 153, 15);
		debugPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Debug information in message log:");
		lblNewLabel_3.setBounds(12, 79, 256, 15);
		debugPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("The higher the debug level, the more information will be");
		lblNewLabel_4.setBounds(12, 106, 437, 15);
		debugPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("displayed in the message log. Displaying debug information");
		lblNewLabel_5.setBounds(12, 126, 437, 15);
		debugPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("has a negative impact on performance. If reporting bugs,");
		lblNewLabel_6.setBounds(12, 148, 407, 15);
		debugPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("please provide logs with \"Verbose\" logging level.");
		lblNewLabel_7.setBounds(12, 170, 389, 15);
		debugPanel.add(lblNewLabel_7);

		JCheckBox chckbxShowDebugMenu = new JCheckBox("Show debug menu");
		chckbxShowDebugMenu.setBounds(22, 48, 185, 23);
		debugPanel.add(chckbxShowDebugMenu);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "0 - None", "1 - Warning", "2 - Info", "3 - Verbose", "4 - Debug" }));
		comboBox.setBounds(273, 79, 114, 19);
		debugPanel.add(comboBox);
		
		JCheckBox chckbxShowRawDirectory = new JCheckBox("Show raw directory listing");
		chckbxShowRawDirectory.setBounds(22, 193, 246, 23);
		debugPanel.add(chckbxShowRawDirectory);

		JPanel loggingPanel = new JPanel();

		panel.add(loggingPanel, "logging");
		loggingPanel.setLayout(null);
		
		JLabel lblLogging = new JLabel("Logging");
		lblLogging.setBounds(12, 28, 153, 15);
		loggingPanel.add(lblLogging);
		
		JCheckBox chckbxShowTimestampsIn = new JCheckBox("Show timestamps in message log");
		chckbxShowTimestampsIn.setBounds(22, 51, 265, 23);
		loggingPanel.add(chckbxShowTimestampsIn);
		
		JCheckBox chckbxLogToFile = new JCheckBox("Log to file");
		chckbxLogToFile.setBounds(22, 78, 185, 23);
		loggingPanel.add(chckbxLogToFile);
		
		JLabel lblFilename = new JLabel("Filename:");
		lblFilename.setBounds(22, 109, 93, 15);
		loggingPanel.add(lblFilename);
		
		textField = new JTextField();
		textField.setBounds(100, 107, 244, 19);
		loggingPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Browse..");
		btnNewButton_2.setBounds(356, 104, 93, 25);
		loggingPanel.add(btnNewButton_2);
		
		JCheckBox chckbxLimitSizeOf = new JCheckBox("Limit size of logfile");
		chckbxLimitSizeOf.setSelected(true);
		chckbxLimitSizeOf.setBounds(22, 143, 185, 23);
		loggingPanel.add(chckbxLimitSizeOf);
		
		JLabel lblLimit = new JLabel("Limit:");
		lblLimit.setBounds(32, 176, 93, 15);
		loggingPanel.add(lblLimit);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 174, 57, 19);
		loggingPanel.add(textField_1);
		
		JLabel lblMib = new JLabel("MiB");
		lblMib.setBounds(147, 174, 93, 15);
		loggingPanel.add(lblMib);
		
		JLabel lblTheHigherThe = new JLabel("If the size of the logfile reaches the limit, it gets renamed by");
		lblTheHigherThe.setBounds(22, 198, 437, 15);
		loggingPanel.add(lblTheHigherThe);
		
		JLabel lblAddingTo = new JLabel("adding \".1\" to the end of the filename (possibly overwriting");
		lblAddingTo.setBounds(22, 218, 437, 15);
		loggingPanel.add(lblAddingTo);
		
		JLabel lblOlderLogfilesAnd = new JLabel("older logfiles) and a new file gets created.");
		lblOlderLogfilesAnd.setBounds(22, 240, 407, 15);
		loggingPanel.add(lblOlderLogfilesAnd);
		
		JLabel lblChangingLogfileSettings = new JLabel("Changing logfile settings requires restart of FTPClient");
		lblChangingLogfileSettings.setBounds(12, 261, 437, 15);
		loggingPanel.add(lblChangingLogfileSettings);
		
		
		JPanel updatesPanel = new JPanel();

		panel.add(updatesPanel, "updates");
		updatesPanel.setLayout(null);
		
		JLabel lblFtpclientUpdates = new JLabel("FTPClient updates");
		lblFtpclientUpdates.setBounds(12, 26, 153, 15);
		updatesPanel.add(lblFtpclientUpdates);
		
		JLabel lblCheckForFtpclient = new JLabel("Check for FTPClient updates automatically:");
		lblCheckForFtpclient.setBounds(22, 50, 437, 15);
		updatesPanel.add(lblCheckForFtpclient);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Once a week", "Once a day", "Never"}));
		comboBox_1.setBounds(32, 77, 114, 19);
		updatesPanel.add(comboBox_1);
		
		JLabel lblWhenCheckingFor = new JLabel("When checking for updates, check for:");
		lblWhenCheckingFor.setBounds(22, 109, 437, 15);
		updatesPanel.add(lblWhenCheckingFor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Stable versions only", "Stable and beta versions", "Stable, beta and nightly versions"}));
		comboBox_2.setBounds(32, 136, 205, 19);
		updatesPanel.add(comboBox_2);
		
		JLabel lblAdviceUnlessYou = new JLabel("Advice: Unless you want to test new features, please keep");
		lblAdviceUnlessYou.setBounds(22, 172, 437, 15);
		updatesPanel.add(lblAdviceUnlessYou);
		
		JLabel lblUsingStableVersions = new JLabel("using stable versions only. Beta versions and nightly builds");
		lblUsingStableVersions.setBounds(22, 192, 437, 15);
		updatesPanel.add(lblUsingStableVersions);
		
		JLabel lblAreDevelopmentVersions = new JLabel("are development versions meant for testing purposes.");
		lblAreDevelopmentVersions.setBounds(22, 214, 407, 15);
		updatesPanel.add(lblAreDevelopmentVersions);
		
		JLabel lblNightlyBuildsOf = new JLabel("Nightly builds of FTPClient may not work as expected and");
		lblNightlyBuildsOf.setBounds(22, 238, 437, 15);
		updatesPanel.add(lblNightlyBuildsOf);
		
		JLabel lblMightEvenDamage = new JLabel("might even damage your system. Use beta versions and");
		lblMightEvenDamage.setBounds(22, 258, 437, 15);
		updatesPanel.add(lblMightEvenDamage);
		
		JLabel lblNightlyBuildsAt = new JLabel("nightly builds at your own risk.");
		lblNightlyBuildsAt.setBounds(22, 281, 437, 15);
		updatesPanel.add(lblNightlyBuildsAt);
		
		JButton btnNewButton_3 = new JButton("Run update check now..");
		btnNewButton_3.setBounds(120, 354, 212, 25);
		updatesPanel.add(btnNewButton_3);
		
		JLabel lblPrivacyPolicyOnly = new JLabel("Privacy policy: Only your version of FTPClient, your");
		lblPrivacyPolicyOnly.setBounds(22, 398, 437, 15);
		updatesPanel.add(lblPrivacyPolicyOnly);
		
		JLabel lblUsedOperatingSystem = new JLabel("used operating system and your CPU architecture will");
		lblUsedOperatingSystem.setBounds(22, 418, 437, 15);
		updatesPanel.add(lblUsedOperatingSystem);
		
		JLabel lblBeSubmittedTo = new JLabel("be submitted to the server.");
		lblBeSubmittedTo.setBounds(22, 439, 437, 15);
		updatesPanel.add(lblBeSubmittedTo);
		
		JPanel fileEditingPanel = new JPanel();

		panel.add(fileEditingPanel, "file-editing");
		fileEditingPanel.setLayout(null);
		
		JLabel lblDefaultEditor = new JLabel("Default editor:");
		lblDefaultEditor.setBounds(12, 26, 153, 15);
		fileEditingPanel.add(lblDefaultEditor);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Do not use default editor");
		rdbtnNewRadioButton.setBounds(22, 49, 221, 23);
		fileEditingPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnUseSystemsDefault = new JRadioButton("Use system's default editor for text files");
		rdbtnUseSystemsDefault.setBounds(21, 76, 314, 23);
		fileEditingPanel.add(rdbtnUseSystemsDefault);
		
		JRadioButton rdbtnUseCustomEditor = new JRadioButton("Use custom editor:");
		rdbtnUseCustomEditor.setBounds(22, 103, 221, 23);
		fileEditingPanel.add(rdbtnUseCustomEditor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 126, 281, 19);
		fileEditingPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse..");
		btnBrowse.setBounds(347, 123, 102, 25);
		fileEditingPanel.add(btnBrowse);
		
		JLabel lblCommandAndIts = new JLabel("Command and its arguments should be properly quoted.");
		lblCommandAndIts.setBounds(53, 152, 390, 15);
		fileEditingPanel.add(lblCommandAndIts);
		
		JRadioButton rdbtnUseFiletypeAssociations = new JRadioButton("Use filetype associations if available");
		rdbtnUseFiletypeAssociations.setBounds(22, 184, 340, 23);
		fileEditingPanel.add(rdbtnUseFiletypeAssociations);
		
		JRadioButton rdbtnAlwaysUseDefault = new JRadioButton("Always use default editor");
		rdbtnAlwaysUseDefault.setEnabled(false);
		rdbtnAlwaysUseDefault.setBounds(22, 213, 221, 23);
		fileEditingPanel.add(rdbtnAlwaysUseDefault);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Watch locally edited files and prompt to upload modifications");
		chckbxNewCheckBox.setBounds(12, 240, 469, 23);
		fileEditingPanel.add(chckbxNewCheckBox);
		
		JPanel filetypeAssociationsPanel = new JPanel();

		panel.add(filetypeAssociationsPanel, "filetype-associations");
		filetypeAssociationsPanel.setLayout(null);
		
		JLabel lblFiletypeAssociations = new JLabel("Filetype associations");
		lblFiletypeAssociations.setBounds(12, 23, 153, 15);
		filetypeAssociationsPanel.add(lblFiletypeAssociations);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Inherit system's filetype associations");
		chckbxNewCheckBox_1.setBounds(22, 43, 284, 23);
		filetypeAssociationsPanel.add(chckbxNewCheckBox_1);
		
		JLabel lblCustomFiletypesAssociations = new JLabel("Custom filetypes associations:");
		lblCustomFiletypesAssociations.setBounds(32, 74, 225, 15);
		filetypeAssociationsPanel.add(lblCustomFiletypesAssociations);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(31, 101, 403, 276);
		filetypeAssociationsPanel.add(textPane);
		
		JLabel lblFormatExtensionFollowed = new JLabel("Format: Extension followed by properly quoted");
		lblFormatExtensionFollowed.setBounds(32, 390, 403, 15);
		filetypeAssociationsPanel.add(lblFormatExtensionFollowed);
		
		JLabel lblExamplePngcprogram = new JLabel("Example: png \"c\\program files\\viewer\\viewer.exe\" -open");
		lblExamplePngcprogram.setBounds(31, 413, 403, 15);
		filetypeAssociationsPanel.add(lblExamplePngcprogram);
		
		JPanel languagePanel = new JPanel();

		panel.add(languagePanel, "language");
		languagePanel.setLayout(null);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(12, 23, 153, 15);
		languagePanel.add(lblLanguage);
		
		JLabel lblSelectLanguage = new JLabel("Select language:");
		lblSelectLanguage.setBounds(22, 46, 153, 15);
		languagePanel.add(lblSelectLanguage);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Default system language", "Arabic (ar)", "Armenian (hy)", "Azeri (az)", "Basque (eu)", "Bulgarian (bg_BG)", "Catalan (ca)", "Chinese (zh_TW)", "Chinese (Simplified) (zh_CN)", "Corsican (co)", "Croatian (hr)", "Czech (cs_CZ)", "Danish (da)", "Dutch (nl)", "English (en_US)", "Estonian (et)", "Farsi (fa_IR)", "Finnish (fi_FI)", "French (fr)", "Galician (gl_ES)", "Georgian (ka)", "German (de)", "Greek (el)", "Hebrew (he_IL)", "Hungarian (hu_HU)", "Icelandic (is)", "Indonesian (id_ID)", "Italian (it)", "Japanese (ja_JP)", "Kabyle (kab)", "Kirghiz (ky)", "Korean (ko_KR)", "Kurdish (ku)", "Laothian (lo_LA)", "Latvian (lv_LV)", "Lithuanian (lt_LT)", "Macedonian (mk_MK)", "Nepali (ne)", "Norwegian (Bokmal) (nb_NO)", "Norwegian (Nynorsk) (nn_NO)", "Occitan (oc)", "Polish (pl_PL)", "Portuguese (pt_PT)", "Portuguese (Brazilian) (pt_BR)", "Romanian (ro_RO)", "Russian (ru)", "Serbian (sr)", "Slovak (sk_SK)", "Slovenian (sl_SI)", "Spanish (es)", "Swedish (sv)", "Thai (th_TH)", "Turkish (tr)", "Ukrainian (uk_UA)", "Valencian (Southern Catalan) (ca_ES@valencia)", "Vietnamese (vi_VN)", "Welsh (cy)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(22, 60, 275, 299);
		languagePanel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(297, 60, 17, 299);
		languagePanel.add(scrollBar);
		
		JLabel lblIfYouChange = new JLabel("If you change the language, you need to restart FTPClient.");
		lblIfYouChange.setBounds(22, 371, 408, 15);
		languagePanel.add(lblIfYouChange);
		
		JPanel interfacePanel = new JPanel();

		panel.add(interfacePanel, "interface");
		interfacePanel.setLayout(null);
		
		JLabel lblInterface = new JLabel("Interface");
		lblInterface.setBounds(12, 22, 153, 15);
		interfacePanel.add(lblInterface);
		
		JLabel lblNewLabel_2 = new JLabel("Layout of file and directory panes:");
		lblNewLabel_2.setBounds(22, 43, 244, 15);
		interfacePanel.add(lblNewLabel_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Classic", "Explorer", "Widescreen", "Blackboard"}));
		comboBox_3.setBounds(284, 38, 122, 24);
		interfacePanel.add(comboBox_3);
		
		JLabel lblMessageLogPosition = new JLabel("Message log position:");
		lblMessageLogPosition.setBounds(22, 75, 244, 15);
		interfacePanel.add(lblMessageLogPosition);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Above the file lists", "Next to the transfer queue", "As tab in the transfer queue pane"}));
		comboBox_4.setBounds(284, 70, 165, 24);
		interfacePanel.add(comboBox_4);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Swap local and remote panes");
		chckbxNewCheckBox_2.setBounds(22, 98, 262, 23);
		interfacePanel.add(chckbxNewCheckBox_2);
		
		JLabel lblBehaviour = new JLabel("Behaviour");
		lblBehaviour.setBounds(12, 138, 153, 15);
		interfacePanel.add(lblBehaviour);
		
		JCheckBox chckbxMinimizeToTray = new JCheckBox("Minimize to tray");
		chckbxMinimizeToTray.setBounds(22, 154, 262, 23);
		interfacePanel.add(chckbxMinimizeToTray);
		
		JCheckBox chckbxPreventSystemFrom = new JCheckBox("Prevent system from entering idle sleep");
		chckbxPreventSystemFrom.setSelected(true);
		chckbxPreventSystemFrom.setBounds(22, 181, 427, 23);
		interfacePanel.add(chckbxPreventSystemFrom);
		
		JLabel lblOnStartupOf = new JLabel("On startup of FTPClient");
		lblOnStartupOf.setBounds(22, 220, 187, 15);
		interfacePanel.add(lblOnStartupOf);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Start normally");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(22, 243, 144, 23);
		interfacePanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnShowTheSite = new JRadioButton("Show the Site Manager on startup");
		rdbtnShowTheSite.setBounds(22, 269, 278, 23);
		interfacePanel.add(rdbtnShowTheSite);
		
		JRadioButton rdbtnRestoreTabsAnd = new JRadioButton("Restore tabs and reconnect");
		rdbtnRestoreTabsAnd.setBounds(21, 296, 374, 23);
		interfacePanel.add(rdbtnRestoreTabsAnd);
		
		JLabel lblWhenStartingA = new JLabel("When starting a new connection while already connected:");
		lblWhenStartingA.setBounds(22, 321, 409, 15);
		interfacePanel.add(lblWhenStartingA);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Ask for action", "Connect in new tab", "Connect in current tab"}));
		comboBox_5.setBounds(22, 348, 187, 24);
		interfacePanel.add(comboBox_5);
		
		JLabel lblTransferQueue = new JLabel("Transfer Queue");
		lblTransferQueue.setBounds(12, 384, 153, 15);
		interfacePanel.add(lblTransferQueue);
		
		JCheckBox chckbxDisplayMomentaryTransfer = new JCheckBox("Display momentary transfer speed instead of average speed");
		chckbxDisplayMomentaryTransfer.setBounds(10, 404, 439, 23);
		interfacePanel.add(chckbxDisplayMomentaryTransfer);
		
		JPanel passwordsPanel = new JPanel();

		panel.add(passwordsPanel, "passwords");
		passwordsPanel.setLayout(null);
		
		JPanel ftpPanel = new JPanel();
		panel.add(ftpPanel, "ftp");

		JPanel activemodePanel = new JPanel();
		panel.add(activemodePanel, "ftp");

//		tree.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				DefaultMutableTreeNode click = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
//				switch (click.getUserObject().toString()) {
//				case "Connection":
//					cardLayoutSettings.show(panel, "connection");
//					break;
//				case "FTP":
//					cardLayoutSettings.show(panel, "ftp");
//					break;
//
//				case "Active mode":
//					cardLayoutSettings.show(panel, "active-mode");
//					break;
//
//				}
//			}
//		});

		panelMain.add(panel);

		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(12, 383, 243, 25);
		panelMain.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(12, 420, 243, 25);
		panelMain.add(btnNewButton_1);
	}

	public JTree getTree() {
		return tree;
	}

	public void seleccionarScreen(MouseEvent e) {
		DefaultMutableTreeNode click = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		switch (click.getUserObject().toString()) {
		case "Connection":
			cardLayoutSettings.show(panel, "connection");
			break;
		case "FTP":
			cardLayoutSettings.show(panel, "ftp");
			break;
		case "Active mode":
			cardLayoutSettings.show(panel, "active-mode");

			break;
		case "Debug":
			cardLayoutSettings.show(panel, "debug");

			break;
		case "Logging":
			cardLayoutSettings.show(panel, "logging");

			break;
		case "Updates":
			cardLayoutSettings.show(panel, "updates");

			break;
		case "File editing":
			cardLayoutSettings.show(panel, "file-editing");

			break;
		case "Filetype associations":
			cardLayoutSettings.show(panel, "filetype-associations");

			break;
		case "Language":
			cardLayoutSettings.show(panel, "language");

			break;
		case "Interface":
			cardLayoutSettings.show(panel, "interface");

			break;
		case "Passwords":
			cardLayoutSettings.show(panel, "passwords");

			break;
		}
	}
}
