package vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import vista.ProjectM07FTPTable;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.io.File;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ProjectM07FTPTreePanel extends JPanel implements TreeSelectionListener, TreeExpansionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	private String pathChanged;
	private String pathExpanded;
	private JPanel panell;
	private ImageIcon tutorialIcon;
	DefaultMutableTreeNode top;
	private boolean server = false;

	// Optionally play with line styles. Possible values are
	// "Angled" (the default), "Horizontal", and "None".
	private static boolean playWithLineStyle = false;
	private static String lineStyle = "Horizontal";

	// Optionally set the look and feel.
	private static boolean useSystemLookAndFeel = false;

	public ProjectM07FTPTreePanel(String path, JPanel panell) {
		super(new GridLayout(1, 0));
		this.pathChanged = path;
		this.panell = panell;
		// Create the nodes.
		top = new DefaultMutableTreeNode("/");
		tutorialIcon = createImageIcon("/activities/img/IconDirectory.png");
		pathExpanded = path;
		createNodes(top);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);
		tree.addTreeExpansionListener(this);

		if (playWithLineStyle) {
			tree.putClientProperty("JTree.lineStyle", lineStyle);
		}

		// Create the scroll pane and add the tree to it.
		JScrollPane treeView = new JScrollPane(tree);

		// Add the scroll panes to a split pane.
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(treeView);

		Dimension minimumSize = new Dimension(100, 50);
		treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(100);
		splitPane.setPreferredSize(new Dimension(500, 300));

		if (tutorialIcon != null) {
			tree.setCellRenderer(new MyRenderer(tutorialIcon));
		} else {
			System.err.println("Tutorial icon missing; using default.");
		}

		// Add the split pane to this panel.
		add(splitPane);

	}

	public ProjectM07FTPTreePanel(String path, JPanel panell, ArrayList<Object[]> objetos) {
		super(new GridLayout(1, 0));
		// removeAll();
		this.pathChanged = path;
		this.panell = panell;
		this.server = true;
		// Create the nodes.
		top = new DefaultMutableTreeNode(path);
		tutorialIcon = createImageIcon("/activities/img/IconDirectory.png");
		pathExpanded = path;
		createNodesServer(objetos, path);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);
		tree.addTreeExpansionListener(this);
		if (playWithLineStyle) {
			tree.putClientProperty("JTree.lineStyle", lineStyle);
		}

		// Create the scroll pane and add the tree to it.
		JScrollPane treeView = new JScrollPane(tree);

		// Add the scroll panes to a split pane.
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(treeView);

		Dimension minimumSize = new Dimension(100, 50);
		treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(100);
		splitPane.setPreferredSize(new Dimension(500, 300));

		if (tutorialIcon != null) {
			tree.setCellRenderer(new MyRenderer(tutorialIcon));
		} else {
			System.err.println("Tutorial icon missing; using default.");
		}

		// Add the split pane to this panel.

		add(splitPane);
		// panell.add(new ProjectM07FTPTable(pathChanged));

	}

//	public ProjectM07FTPTreePanel() {
//		// TODO Auto-generated constructor stub
//		this.server = true;
//		top = new DefaultMutableTreeNode("/");
//
//		tree = new JTree(top);
//		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//		// Create the scroll pane and add the tree to it.
//		JScrollPane treeView = new JScrollPane(tree);
//		// Add the scroll panes to a split pane.
//		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//		splitPane.setTopComponent(treeView);
//
//		Dimension minimumSize = new Dimension(100, 50);
//		treeView.setMinimumSize(minimumSize);
//		splitPane.setDividerLocation(100);
//		splitPane.setPreferredSize(new Dimension(500, 300));
//		add(splitPane);
//	}

	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ProjectM07FTPTreePanel.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/** Required by TreeSelectionListener interface. */
	public void valueChanged(TreeSelectionEvent e) {
		if (!server) {
			this.pathChanged = convert(tree.getSelectionPath().toString());
			panell.removeAll();
			panell.add(new ProjectM07FTPTable(pathChanged));
			panell.repaint();
			panell.revalidate();
		}
	}

	private String convert(String hi) {

		hi = hi.replaceAll(",\\s", "/");
		hi = hi.replaceAll("\\[", "");
		hi = hi.replaceAll("\\]", "");
		return hi.replaceAll("//", "/");
	}

	public void createNodesServer(ArrayList<Object[]> objetos, String nombre) {

		for (Object[] objects : objetos) {
			top.add(new DefaultMutableTreeNode(objects[0]));
		}

	}

	private void createNodes(DefaultMutableTreeNode top) {
		File f = new File(pathExpanded);
		if (f.canRead()) {
			for (File file : f.listFiles()) {
				if (file.isDirectory() && f.canRead()) {
					DefaultMutableTreeNode category = new DefaultMutableTreeNode(file.getName());
					top.add(category);
					if (file.canRead() && file.isDirectory()) {
						for (File file1 : file.listFiles()) {
							if (file1.isDirectory() && f.canRead()) {
								DefaultMutableTreeNode category1 = new DefaultMutableTreeNode(file1.getName());
								category.add(category1);
							}
						}
					}
				}
			}
		}
		/*
		 * File f = new File(path); try { recursiveNodes(top, f); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Override
	public void treeCollapsed(TreeExpansionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeExpanded(TreeExpansionEvent arg0) {
		// TODO Auto-generated method stub
		if (!server) {
			pathExpanded = convert(arg0.getPath().toString());
			DefaultMutableTreeNode aux = (DefaultMutableTreeNode) arg0.getPath().getLastPathComponent();
			aux.removeAllChildren();
			System.out.println(aux);

			createNodes(aux);

			DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
			model.reload(aux);
		}

	}

	private class MyRenderer extends DefaultTreeCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Icon tutorialIcon;

		public MyRenderer(Icon icon) {
			tutorialIcon = icon;
		}

		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {

			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			// if (leaf) {
			setIcon(tutorialIcon);
			setToolTipText("This book is in the Tutorial series.");
			/*
			 * } else { setToolTipText(null); //no tool tip }
			 */

			return this;
		}
	}
}