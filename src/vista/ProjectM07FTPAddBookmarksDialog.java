package vista;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ProjectM07FTPAddBookmarksDialog extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public ProjectM07FTPAddBookmarksDialog() {
		
		setLayout(null);
		setPreferredSize(new Dimension(412, 288));
		
		JRadioButton rdbtnGlobalAddress = new JRadioButton("Global address");
		rdbtnGlobalAddress.setBounds(12, 40, 144, 23);
		add(rdbtnGlobalAddress);
		
		JRadioButton rdbtnSpecificAddressOf = new JRadioButton("Specific address of the site");
		rdbtnSpecificAddressOf.setBounds(154, 40, 228, 23);
		add(rdbtnSpecificAddressOf);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 71, 66, 15);
		add(lblName);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(12, 98, 66, 15);
		add(lblName_1);
		
		textField = new JTextField();
		textField.setBounds(66, 96, 337, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(12, 12, 66, 15);
		add(lblTypes);
		
		JLabel lblPaths = new JLabel("Paths");
		lblPaths.setBounds(14, 134, 66, 15);
		add(lblPaths);
		
		JLabel lblLocalDirectory = new JLabel("Local directory");
		lblLocalDirectory.setBounds(12, 161, 101, 15);
		add(lblLocalDirectory);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 159, 190, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(319, 156, 84, 25);
		add(btnSearch);
		
		JLabel lblRemoteDirectory = new JLabel("Remote directory");
		lblRemoteDirectory.setBounds(12, 188, 118, 15);
		add(lblRemoteDirectory);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 186, 271, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxUseSynchronizedNavigation = new JCheckBox("Use synchronized navigation");
		chckbxUseSynchronizedNavigation.setBounds(12, 226, 228, 23);
		add(chckbxUseSynchronizedNavigation);
		
		JCheckBox chckbxDirectoryComparation = new JCheckBox("Directory comparation");
		chckbxDirectoryComparation.setBounds(12, 255, 200, 23);
		add(chckbxDirectoryComparation);

	}
}
