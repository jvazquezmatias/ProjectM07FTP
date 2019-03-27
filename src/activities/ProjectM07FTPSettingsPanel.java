package activities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ItemListener;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProjectM07FTPSettingsPanel extends JPanel {
	public ProjectM07FTPSettingsPanel() throws URISyntaxException, HeadlessException, AWTException {
		setPreferredSize(new Dimension(750, 500));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panelTop = new JPanel();
		add(panelTop);
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
	}
}
