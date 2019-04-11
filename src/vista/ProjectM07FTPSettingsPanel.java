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

public class ProjectM07FTPSettingsPanel extends JPanel {
	JPanel panel;
	private JTree tree;
	CardLayout cardLayoutSettings;
	private JTextField textField;

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

		JButton btnNewButton_2 = new JButton("Run configuration wizard now...");
		btnNewButton_2.setBounds(12, 101, 271, 25);
		debugPanel.add(btnNewButton_2);

		JLabel lblNewLabel_4 = new JLabel("Timeout");
		lblNewLabel_4.setBounds(12, 150, 66, 15);
		debugPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Timeout in seconds:");
		lblNewLabel_5.setBounds(12, 177, 153, 15);
		debugPanel.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setText("20");
		textField.setBounds(159, 175, 34, 19);
		debugPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("(10-9999, 0 to disable)");
		lblNewLabel_6.setBounds(197, 177, 170, 15);
		debugPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(12, 204, 66, 15);
		debugPanel.add(lblNewLabel_7);

		JCheckBox chckbxShowDebugMenu = new JCheckBox("Show debug menu");
		chckbxShowDebugMenu.setBounds(22, 48, 185, 23);
		debugPanel.add(chckbxShowDebugMenu);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "0 - None", "1 - Warning", "2 - Info", "3 - Verbose", "4 - Debug" }));
		comboBox.setBounds(273, 79, 114, 19);
		debugPanel.add(comboBox);

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

		}
	}
}
