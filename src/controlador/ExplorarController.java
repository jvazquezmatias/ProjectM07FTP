package controlador;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import vista.ProjectM07FTPClient;

public class ExplorarController {
	
	private ProjectM07FTPClient clientFtp;

	public ExplorarController(ProjectM07FTPClient clientFtp) {
		super();
		this.clientFtp = clientFtp;
		addListenersToMenuBar();
	}

	public void addListenersToMenuBar() {
		clientFtp.getMenuItemExport().addActionListener(e -> openExportDialog());
		
	}
	
	public void openExportDialog() {
		
		System.out.println("gola");
		
		ArrayList<JCheckBox> options = new ArrayList<JCheckBox>();

		JCheckBox cdbtnSiteManager = new JCheckBox("Export Site Manager entries");
		JCheckBox cdbtnSettings = new JCheckBox("Export Settings");
		JCheckBox cdbtnQueue = new JCheckBox("Export Queue");
		JCheckBox cdbtnFilters = new JCheckBox("Export Filters");
		options.add(cdbtnSiteManager);
		options.add(cdbtnSettings);
		options.add(cdbtnQueue);
		options.add(cdbtnFilters);

		Object[] obj = (Object[]) options.toArray(new Object[options.size()]);

		String op[] = { "Accept", "Cancel" };

		JOptionPane.showOptionDialog(clientFtp, obj, "Export configuration", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, op, op[0]);
	}
}
