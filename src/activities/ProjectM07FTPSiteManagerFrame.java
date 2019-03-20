package activities;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Panel;

public class ProjectM07FTPSiteManagerFrame extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedPane;
	
	
	public ProjectM07FTPSiteManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 586, 368);
		contentPane.add(tabbedPane);
		
		addTabGeneral();
		
		
		
		
		
		
		
		
	}

	private void addTabGeneral() {
		Panel panel = new Panel();
		tabbedPane.addTab("New tab", null, panel, null);		
	}
}
