package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Desktop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import java.awt.Dimension;

public class ProjectM07FTPDialogBeforeOpen extends JPanel implements MouseListener {

	JLabel lblAskingQuestionIn, lblReportingBugsAnd, lblBasicUsageInstructions, lblConfiguringFilezilaAnd;

	/**
	 * Create the panel.
	 */
	public ProjectM07FTPDialogBeforeOpen() {
		setPreferredSize(new Dimension(440, 275));
		setSize(new Dimension(450, 313));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(450, 301));
		
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_5);

		JLabel lblFilezilla = new JLabel("Filezilla 3.7.2");
		panel.add(lblFilezilla);

		JLabel lblTheFreeOpen = new JLabel("The free open surce Ftp solution");

		panel.add(lblTheFreeOpen);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		JLabel lblGettingHelp = new JLabel("Getting help");
		panel.add(lblGettingHelp);
		lblAskingQuestionIn = new JLabel(
				"<html><a href=\"http://google.com\">Asking question in the FileZilla forums</a></html>");
		lblAskingQuestionIn.addMouseListener(this);
		panel.add(lblAskingQuestionIn);

		lblReportingBugsAnd = new JLabel(
				"<html><a href=\"http://google.com\">Reporting bugs and features requests</a></html>");
		lblReportingBugsAnd.addMouseListener(this);
		panel.add(lblReportingBugsAnd);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2);
		JLabel lblDocumentation = new JLabel("Documentation");
		panel.add(lblDocumentation);

		lblBasicUsageInstructions = new JLabel("<html><a href=\"http://google.com\">Basic usage instructions</a></html>");
		lblBasicUsageInstructions.addMouseListener(this);
		panel.add(lblBasicUsageInstructions);
		
		lblConfiguringFilezilaAnd = new JLabel(
				"<html><a href=\"http://google.com\">Configuring FileZila and your network</a></html>");
		lblConfiguringFilezilaAnd.addMouseListener(this);
		panel.add(lblConfiguringFilezilaAnd);
				
				Component verticalStrut_3 = Box.createVerticalStrut(20);
				panel.add(verticalStrut_3);
				
				Component verticalStrut_4 = Box.createVerticalStrut(20);
				panel.add(verticalStrut_4);
		
				JLabel lblYouCanAlways = new JLabel("You can always open this dialog again through the help menu.");
				panel.add(lblYouCanAlways);

	}

	public void mouseClicked(MouseEvent m) {

		URI uri;
		if (m.getComponent().equals(lblAskingQuestionIn)) {
			try {
				uri = new URI("https://forum.filezilla-project.org/");
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e) {
					}
				}

			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		} else if (m.getComponent().equals(lblReportingBugsAnd)) {
			try {
				uri = new URI("https://filezilla-project.org/support.php?version=3.41.2&product=#bugs");
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if (m.getComponent().equals(lblBasicUsageInstructions)) {
			try {
				uri = new URI("https://wiki.filezilla-project.org/Using");
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if (m.getComponent().equals(lblConfiguringFilezilaAnd)) {
			try {
				uri = new URI("https://wiki.filezilla-project.org/Network_Configuration");
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}
}
