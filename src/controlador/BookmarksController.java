package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import vista.ProjectM07FTPAddBookmarksDialog;
import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPManegesBookmarks;

public class BookmarksController {
	private ProjectM07FTPClient clientFtp;
	private ProjectM07FTPAddBookmarksDialog book;
	private ProjectM07FTPManegesBookmarks manage;

	public BookmarksController(ProjectM07FTPClient clientFtp, ProjectM07FTPManegesBookmarks manage,
			ProjectM07FTPAddBookmarksDialog book) throws IOException {
		this.clientFtp = clientFtp;
		this.manage = manage;
		this.book = book;
		addListenersToMenuBar();

		String linea;
		FileReader file = new FileReader("bookmarks.txt");
		BufferedReader br = new BufferedReader(file);
		while ((linea = br.readLine()) != null) {
			JMenuItem newBookmark = new JMenuItem(linea);
			clientFtp.getMenuBookmarks().add(newBookmark);
			
			((DefaultMutableTreeNode) manage.getTree().getModel().getRoot()).add(new DefaultMutableTreeNode(linea));
			manage.getTree().repaint();
			manage.getTree().revalidate();
			
			System.out.println(linea);
		}
		br.close();
	}

	public void readBookmarks() throws IOException {

	}

	public void addListenersToMenuBar() {

		clientFtp.getMenuItemAddBookmark().addActionListener(e -> {
			try {
				openAddBookDialog();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		clientFtp.getMenuItemManageBookmarks().addActionListener(e -> openMangeBookDialog());
		manage.getBtnNewBookmark().addActionListener(e -> {
			try {
				openAddNewNodeDialog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

	protected void openAddBookDialog() throws IOException {

		String op[] = { "Accept", "Cancel" };
		int aux = JOptionPane.showOptionDialog(clientFtp, book, "Add Bookmark", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, op, op[0]);

		if (aux == JOptionPane.OK_OPTION) {
			addNewBookmark(book.getNameBookmark().getText());

		}
	}

	protected void addNewBookmark(String name) throws IOException {

		JMenuItem newBookmark = new JMenuItem(name);
		clientFtp.getMenuBookmarks().add(newBookmark);

		((DefaultMutableTreeNode) manage.getTree().getModel().getRoot()).add(new DefaultMutableTreeNode(name));
		manage.getTree().repaint();
		manage.getTree().revalidate();

		File archivo = new File("bookmarks.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
		bw.write(name + "\n");

		bw.close();
	}

	protected void openMangeBookDialog() {

		String op[] = { "Accept", "Cancel" };
		int aux = JOptionPane.showOptionDialog(clientFtp, manage, "Add Bookmark", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, op, op[0]);

		if (aux == JOptionPane.OK_OPTION) {

		}
	}

	protected void openAddNewNodeDialog() throws IOException {

		String op[] = { "Accept", "Cancel" };
		int aux = JOptionPane.showOptionDialog(clientFtp, manage, "Add Bookmark", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, op, op[0]);

		if (aux == JOptionPane.OK_OPTION) {
			addToTree(manage.getTextFieldBookName().getText());

		}
	}

	protected void addToTree(String name) throws IOException {

		JMenuItem newBookmark = new JMenuItem(name);
		clientFtp.getMenuBookmarks().add(newBookmark);

		((DefaultMutableTreeNode) manage.getTree().getModel().getRoot()).add(new DefaultMutableTreeNode(name));
		manage.getTree().repaint();
		manage.getTree().revalidate();

		File archivo = new File("bookmarks.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
		bw.write(name + "\n");

		bw.close();

	}
}
