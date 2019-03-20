package activities;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Window;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;


import javax.swing.ImageIcon;

public class ProjectM07FTPClient extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectM07FTPClient frame = new ProjectM07FTPClient();
					frame.setVisible(true);
					frame.setSize(800, 550);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectM07FTPClient() {
		setLocation(new Point(200, 170));
		addWindowListener(new MyWindowAdapter());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(40, 32767));
		contentPane.setPreferredSize(new Dimension(800, 550));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addToolBar();
		
		addFastConnection();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuFile();
		menuEdit();

		menuView();

		menuServer();
		menuTransfer();
		menuBookmarks();
		menuHelp();
		
		pack();

	}


	
	public void addFastConnection() {
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 786, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(0, 15, 47, 15);
		panel.add(lblHost);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(37, 12, 74, 18);
		panel.add(editorPane);
		
		JLabel lblUsuari = new JLabel("Username:");
		lblUsuari.setBounds(111, 15, 74, 15);
		panel.add(lblUsuari);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(187, 12, 90, 18);
		panel.add(editorPane_1);
		
		JLabel lblContrasea = new JLabel("Password:");
		lblContrasea.setBounds(282, 15, 70, 15);
		panel.add(lblContrasea);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(354, 12, 100, 18);
		panel.add(editorPane_2);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(459, 15, 36, 15);
		panel.add(lblPort);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(496, 12, 47, 18);
		panel.add(editorPane_3);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(555, 10, 90, 25);
		panel.add(btnConnect);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "", "\n" + 
				"Clean bar ", "Clean history" }));
		comboBox.setBounds(657, 10, 98, 24);
		panel.add(comboBox);
		
	}

	private void addToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		toolBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.setFocusTraversalKeysEnabled(false);
		toolBar.setFocusable(false);
		toolBar.setBounds(10, 10, 680, 39);
		toolBar.setFloatable(false);
		contentPane.add(toolBar);
		
		JButton btnToolBarSiteManager = new JButton("");
		btnToolBarSiteManager.setFocusable(false);
		btnToolBarSiteManager.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarSiteManager.setOpaque(false);
		btnToolBarSiteManager.setMargin(new Insets(0, 0, 0, 25));
		btnToolBarSiteManager.setToolTipText("Open the Site Manager");
		btnToolBarSiteManager.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconServerToolBar.png")));
		toolBar.add(btnToolBarSiteManager);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setPreferredSize(new Dimension(10, 2));
		menuBar_1.setOpaque(false);
		menuBar_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.add(menuBar_1);
		
		JMenu mnH = new JMenu("");
		mnH.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarFlecha.png")));
		menuBar_1.add(mnH);
		mnH.setFocusable(false);
		mnH.setBorder(new EmptyBorder(0, 0, 0, 0));
		mnH.setMaximumSize(new Dimension(20, 32767));
		mnH.setPreferredSize(new Dimension(25, 27));
		
		JLabel lblNoSitesAvailable = new JLabel("No sites available");
		lblNoSitesAvailable.setFont(new Font("Tahoma", Font.PLAIN, 9));
		mnH.add(lblNoSitesAvailable);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(15, 30));
		separator.setPreferredSize(new Dimension(0, 1));
		toolBar.add(separator);
		
		JButton btnToolBarRefresh = new JButton("");
		btnToolBarRefresh.setFocusable(false);
		btnToolBarRefresh.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarRefresh.setToolTipText("Refresh the file and folder lists");
		btnToolBarRefresh.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarRefresh.png")));
		toolBar.add(btnToolBarRefresh);
		
		JButton btnToolBarCancel = new JButton("");
		btnToolBarCancel.setFocusable(false);
		btnToolBarCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarCancel.setToolTipText("Cancels the current operation");
		btnToolBarCancel.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconCancelToolBar.png")));
		toolBar.add(btnToolBarCancel);
		
		JButton btnToolBarServerDisconnect = new JButton("");
		btnToolBarServerDisconnect.setFocusable(false);
		btnToolBarServerDisconnect.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarServerDisconnect.setToolTipText("Disconnects from the currently visible server");
		btnToolBarServerDisconnect.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarServerDisconnect.png")));
		toolBar.add(btnToolBarServerDisconnect);
		
		JButton btnToolBarServerConnect = new JButton("");
		btnToolBarServerConnect.setFocusable(false);
		btnToolBarServerConnect.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarServerConnect.setToolTipText("Reconnects to the last used server");
		btnToolBarServerConnect.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarServerConnect.png")));
		toolBar.add(btnToolBarServerConnect);		
		
		
	}

	private void menuTransfer() {
		JMenu menuTransfer = new JMenu("Transfer");
		menuBar.add(menuTransfer);
		JMenuItem menuItemProcessQueue = new JMenuItem("Process Queue");
		menuItemProcessQueue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		menuTransfer.add(menuItemProcessQueue);
		
		JSeparator separator = new JSeparator();
		menuTransfer.add(separator);
		
		JMenuItem menuItemTransferType = new JMenu("Transfer Type");
		menuTransfer.add(menuItemTransferType);
		
		JMenuItem subMenuItemAutomatic = new JMenuItem("Automatic");
		subMenuItemAutomatic.setMnemonic('M');
		menuItemTransferType.add(subMenuItemAutomatic);
		JMenuItem subMenuItemASCII = new JMenuItem("ASCII");
		menuItemTransferType.add(subMenuItemASCII);
		JMenuItem subMenuItemBinary = new JMenuItem("Binary");
		menuItemTransferType.add(subMenuItemBinary);
		
		menuTransfer.add(separator);
		
		JMenuItem menuItemSpeedLimit = new JMenu("Speed Limit");
		menuTransfer.add(menuItemSpeedLimit);
		
		JMenuItem subMenuItemEnable = new JMenuItem("Enable");
		menuItemSpeedLimit.add(subMenuItemEnable);
		JMenuItem subMenuItemConfigure = new JMenuItem("Configure...");
		menuItemSpeedLimit.add(subMenuItemConfigure);
	}

	
	private void menuEdit() {
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuEdit.setMnemonic('e');
		
		JMenuItem menuItemEdit = new JMenuItem("Clear private data...");
		menuEdit.add(menuItemEdit);

		JSeparator separator = new JSeparator();
		menuEdit.add(separator);

		JMenuItem menuItemSettigs = new JMenuItem("Settings...");
		menuEdit.add(menuItemSettigs);

	}

	private void menuServer() {
		JMenu menuServer = new JMenu("Server");
		menuBar.add(menuServer);
		menuServer.setMnemonic('s');

		JMenuItem menuItemCancelCurrentOperation = new JMenuItem("Cancel current operation");
		menuServer.add(menuItemCancelCurrentOperation);
		menuItemCancelCurrentOperation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, Event.CTRL_MASK));

		JSeparator separator = new JSeparator();
		menuServer.add(separator);

		JMenuItem menuItemReconnect = new JMenuItem("Reconnect");
		menuServer.add(menuItemReconnect);
		menuItemReconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));

		JMenuItem menuItemDisconnect = new JMenuItem("Disconnect");
		menuServer.add(menuItemDisconnect);
		menuItemDisconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));

		JSeparator separator2 = new JSeparator();
		menuServer.add(separator2);
		JMenuItem menuItemForceShowingHiddenFiles = new JMenuItem("Force showing hidden files");
		menuServer.add(menuItemForceShowingHiddenFiles);

	}

	public void menuView() {
		JMenu menuView = new JMenu("View");
		menuView.setMnemonic('V');
		menuBar.add(menuView);

		JMenuItem menuItemRefresh = new JMenuItem("Refresh");
		menuItemRefresh.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarRefresh.png")));
		menuItemRefresh.setMnemonic(KeyEvent.VK_C);
		menuItemRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		menuView.add(menuItemRefresh);

		JSeparator separator = new JSeparator();
		menuView.add(separator);

		JCheckBoxMenuItem menuItemFilelistStatusBars = new JCheckBoxMenuItem("Filelist status bars");
		menuItemFilelistStatusBars.setSelected(true);
		menuView.add(menuItemFilelistStatusBars);

		JSeparator separator_1 = new JSeparator();
		menuView.add(separator_1);

		JCheckBoxMenuItem menuItemToolbar = new JCheckBoxMenuItem("Toolbar");
		menuItemToolbar.setSelected(true);
		menuView.add(menuItemToolbar);

		JCheckBoxMenuItem menuItemQuickconnectBar = new JCheckBoxMenuItem("Quickconnect bar");
		menuItemQuickconnectBar.setSelected(true);
		menuView.add(menuItemQuickconnectBar);

		JCheckBoxMenuItem menuItemMessageLog = new JCheckBoxMenuItem("Message log");
		menuItemMessageLog.setSelected(true);
		menuView.add(menuItemMessageLog);

		JCheckBoxMenuItem menuItemLocalDirectoryTree = new JCheckBoxMenuItem("Local directory tree");
		menuItemLocalDirectoryTree.setSelected(true);
		menuView.add(menuItemLocalDirectoryTree);

		JCheckBoxMenuItem menuItemRemoteDirectoryTree = new JCheckBoxMenuItem("Remote directory tree");
		menuItemRemoteDirectoryTree.setSelected(true);
		menuView.add(menuItemRemoteDirectoryTree);

		JCheckBoxMenuItem menuItemTransferQueue = new JCheckBoxMenuItem("Transfer queue");
		menuItemTransferQueue.setSelected(true);
		menuView.add(menuItemTransferQueue);
	}
	
	private void menuBookmarks() {
		JMenu menuBookmarks = new JMenu("Bookmarks");
		menuBookmarks.setMnemonic('B');
		menuBar.add(menuBookmarks);
		
		
		JMenuItem menuItemAddBookmark = new JMenuItem("Add bookmark...");
		menuItemAddBookmark.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarBookmark.png")));
		menuItemAddBookmark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		menuBookmarks.add(menuItemAddBookmark);
		
		JMenuItem menuItemManageBookmarks = new JMenuItem("Manage bookmarks...");
		menuItemManageBookmarks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBookmarks.setMnemonic(KeyEvent.VK_F1);
		menuBookmarks.add(menuItemManageBookmarks);
		
		
		
	}
	private void menuFile() {

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItemFile = new JMenuItem("Site Manager");
		menuItemFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuFile.add(menuItemFile);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuItemNewWindow = new JMenuItem("New Window");
		menuItemNewWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		menuFile.add(menuItemNewWindow);

		JMenuItem menuItemCloseWindow = new JMenuItem("Close Window");
		menuItemCloseWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		menuFile.add(menuItemCloseWindow);

		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);

		JMenuItem menuItemImport = new JMenuItem("Import");
		menuFile.add(menuItemImport);

		JMenuItem menuItemExport = new JMenuItem("Export");
		menuFile.add(menuItemExport);

		JSeparator separator_2 = new JSeparator();
		menuFile.add(separator_2);

		JMenuItem menuItemClose = new JMenuItem("Close");
		menuItemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menuFile.add(menuItemClose);

	}
	private void menuHelp() {
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic('H');
		menuBar.add(menuHelp);
		
		JMenuItem menuItemCheckupdates = new JMenuItem("Check for updates...");
		menuItemCheckupdates.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarUpdate.png")));
		menuItemCheckupdates.setMnemonic('u');
		menuHelp.add(menuItemCheckupdates);

		JSeparator separator_2 = new JSeparator();
		menuHelp.add(separator_2);
		
		JMenuItem menuItemFaqs = new JMenuItem("Faqs...");
		menuItemFaqs.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarFaq.png")));
		menuItemFaqs.setMnemonic('F');
		menuHelp.add(menuItemFaqs);
		
		JMenuItem menuItemReportBug = new JMenuItem("Report a bug...");
		menuItemReportBug.setMnemonic('R');
		menuItemReportBug.setSelected(true);
		menuHelp.add(menuItemReportBug);

		JSeparator separator_3 = new JSeparator();
		menuHelp.add(separator_3);
		
		JMenuItem menuItemAbout = new JMenuItem("About...");
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		menuItemAbout.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarAbout.png")));
		menuItemAbout.setMnemonic('A');
		menuHelp.add(menuItemAbout);
	}
	
	class MyWindowAdapter extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

			String op[] = { "Exit", "Cancel" };

			int n = JOptionPane.showOptionDialog(e.getComponent(), "Quieres salir?", "Cerrar",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

			if (n == JOptionPane.YES_OPTION) {
				((Window) e.getComponent()).dispose();

			}

		}

	}
}
