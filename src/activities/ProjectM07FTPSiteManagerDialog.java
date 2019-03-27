package activities;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class ProjectM07FTPSiteManagerDialog extends JDialog{

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	 
	
	
	public ProjectM07FTPSiteManagerDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 717, 463);
		contentPane.add(tabbedPane);
		
		addTabGeneral();
		
		
		
	}

	private void addTabGeneral() {
		Panel generalPanel = new Panel();
		tabbedPane.addTab("General", null, generalPanel, null);	
		generalPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Protocol:");
		lblNewLabel.setBounds(12, 12, 85, 15);
		generalPanel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"FTP - File Transfer Protocol", "SFTP - SSH File Transfer Protocol", "Storj - Decentralized Colud Storage"}));
		comboBox.setBounds(150, 7, 550, 24);
		generalPanel.add(comboBox);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(12, 41, 85, 15);
		generalPanel.add(lblHost);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 37, 397, 24);
		generalPanel.add(textField_1);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(565, 41, 66, 15);
		generalPanel.add(lblPort);
		
		JTextField textField = new JTextField();
		textField.setBounds(649, 37, 51, 24);
		generalPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEncryption = new JLabel("Encryption:");
		lblEncryption.setBounds(12, 73, 85, 15);
		generalPanel.add(lblEncryption);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Use explicit FTP over TLS if available", "Require explicit FTP over", "Require implicit FTP over", "Only use plain FTP (insecure)"}));
		comboBox_2.setBounds(150, 68, 550, 24);
		generalPanel.add(comboBox_2);
		
		JLabel lblLogonType = new JLabel("Logon Type:");
		lblLogonType.setBounds(12, 130, 85, 15);
		generalPanel.add(lblLogonType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Anonymous", "Normal", "Ask for password", "Interactive", "Account"}));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setBounds(150, 125, 550, 24);
		generalPanel.add(comboBox_1);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(12, 161, 85, 15);
		generalPanel.add(lblUser);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 157, 550, 24);
		generalPanel.add(textField_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 192, 85, 15);
		generalPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 193, 550, 24);
		generalPanel.add(passwordField);
		
		JLabel lblBackgroundColor = new JLabel("Background color:");
		lblBackgroundColor.setBounds(12, 276, 137, 15);
		generalPanel.add(lblBackgroundColor);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(167, 271, 85, 24);
		generalPanel.add(comboBox_3);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(12, 309, 137, 15);
		generalPanel.add(lblComments);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 336, 688, 88);
		generalPanel.add(textArea);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setBounds(12, 219, 85, 15);
		generalPanel.add(lblAccount);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(150, 220, 550, 24);
		generalPanel.add(passwordField_1);
		
		
		
		
	}

}
