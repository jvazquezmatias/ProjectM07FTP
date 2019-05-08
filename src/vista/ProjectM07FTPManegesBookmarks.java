package vista;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.tree.TreeModel;

public class ProjectM07FTPManegesBookmarks extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private ProjectM07FTPAddBookmarksDialog book;
	JTree tree;
	DefaultMutableTreeNode nodePrincipal;
	private JButton btnNewBookmark;
	private JTextField textFieldBookName;

	/**
	 * Create the panel.
	 */
	public ProjectM07FTPManegesBookmarks() {
		setLayout(null);
		setPreferredSize(new Dimension(565, 330));

		nodePrincipal = new DefaultMutableTreeNode("Global Bookmarks");
		tree = new JTree(nodePrincipal);
		
		tree.setBounds(12, 33, 274, 221);
		add(tree);

		btnNewBookmark = new JButton("New bookmark");

		btnNewBookmark.setBounds(12, 261, 152, 25);
		add(btnNewBookmark);

		JButton btnChangeName = new JButton("Change name");
		btnChangeName.setBounds(12, 298, 152, 25);
		add(btnChangeName);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(172, 261, 114, 25);
		add(btnDelete);

		JButton btnDuplicate = new JButton("Duplicate");
		btnDuplicate.setBounds(172, 298, 114, 25);
		add(btnDuplicate);

		JLabel lblBookmarks = new JLabel("Bookmarks:");
		lblBookmarks.setBounds(296, 12, 114, 15);
		add(lblBookmarks);

		JLabel label = new JLabel("Bookmarks:");
		label.setBounds(12, 12, 114, 15);
		add(label);

		JLabel lblLocalDirectory = new JLabel("Local directory:");
		lblLocalDirectory.setBounds(300, 93, 114, 15);
		add(lblLocalDirectory);

		textField = new JTextField();
		textField.setBounds(302, 120, 142, 19);
		add(textField);
		textField.setColumns(10);

		JButton btnNavegate = new JButton("Navegate");
		btnNavegate.setBounds(456, 117, 99, 25);
		add(btnNavegate);

		JLabel lblRemoteDirectory = new JLabel("Remote directory:");
		lblRemoteDirectory.setBounds(300, 156, 134, 15);
		add(lblRemoteDirectory);

		textField_1 = new JTextField();
		textField_1.setBounds(302, 183, 253, 19);
		add(textField_1);
		textField_1.setColumns(10);

		JCheckBox checkBox = new JCheckBox("Use synchronized navigation");
		checkBox.setBounds(298, 210, 228, 23);
		add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("Directory comparation");
		checkBox_1.setBounds(298, 239, 200, 23);
		add(checkBox_1);
		
		JLabel lblBookmarkName = new JLabel("Bookmark Name:");
		lblBookmarkName.setBounds(296, 39, 167, 15);
		add(lblBookmarkName);
		
		textFieldBookName = new JTextField();
		textFieldBookName.setBounds(298, 66, 257, 19);
		add(textFieldBookName);
		textFieldBookName.setColumns(10);

	}
	public JTree getTree() {
		return tree;
	}
	public TreeModel getTreeModel() {
		return tree.getModel();
	}
	public void setTreeModel(TreeModel model) {
		tree.setModel(model);
	}
	public JButton getBtnNewBookmark() {
		return btnNewBookmark;
	}
	public JTextField getTextFieldBookName() {
		return textFieldBookName;
	}
}
