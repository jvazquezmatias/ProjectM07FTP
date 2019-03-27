package activities;

import java.awt.AWTException;
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

public class ProjectM07FTPSettingsPanel extends JPanel {
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
		
		  Icon leafIcon = new ImageIcon("leaf.gif");
		  Icon openIcon = new ImageIcon("open.gif");
		  Icon closedIcon = new ImageIcon("closed.gif");
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Settings") {
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
			}
		));
	    DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
	    renderer.setLeafIcon(leafIcon);
	    renderer.setClosedIcon(closedIcon);
	    renderer.setOpenIcon(openIcon);

		tree.setBounds(12, 27, 243, 451);
		panelMain.add(tree);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(267, 12, 461, 466);
		panelMain.add(panel);
	}
}
