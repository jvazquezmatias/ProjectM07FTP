package controlador;

import javax.swing.JOptionPane;

import vista.ProjectM07FTPAddBookmarksDialog;
import vista.ProjectM07FTPClient;

public class AddBookmarksController {
	private ProjectM07FTPClient clientFtp;
	
	public AddBookmarksController(ProjectM07FTPClient clientFtp) {
		this.clientFtp = clientFtp;
		addListenersToMenuBar();
	}

	public void addListenersToMenuBar() {

		clientFtp.getMenuItemAddBookmark().addActionListener(e -> openBookDialog());
	}

	protected void openBookDialog() {
		ProjectM07FTPAddBookmarksDialog panel = new ProjectM07FTPAddBookmarksDialog();
		
		String op[] = { "Accept", "Cancel" };
		JOptionPane.showOptionDialog(clientFtp, panel, "Add Bookmark", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, op, op[0]);
	}
}

