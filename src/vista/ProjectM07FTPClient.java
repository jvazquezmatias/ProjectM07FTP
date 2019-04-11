package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import model.ProjectM07FTPDadesConnexio;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Event;
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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JTextField;

public class ProjectM07FTPClient extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuBar;
	static ProjectM07FTPClient frame;
	private JTextField textFieldHost;
	private JTextField textFieldUser;
	private JPasswordField fieldPassword;
	private JTextField textFieldPort;
	private JButton btnConnect;
	private ProjectM07FTPDadesConnexio dadesConnexio;
	private JMenuItem menuItemFile;
<<<<<<< Upstream, based on branch 'master' of https://github.com/pablosanchez1999/ProjectM07FTP
	private JMenu mnH;
	private JButton btnToolBarSiteManager;
=======
	private JMenuItem mntmOpenWelcomeDialog;
	private JMenuItem menuItemExport;
	private JMenuItem menuItemFaqs;
	private JMenuItem menuItemReportBug;
	private JMenuItem menuItemAddBookmark;
>>>>>>> 2a5a00e add dialogs i controllers

	public ProjectM07FTPClient() {
		dadesConnexio = new ProjectM07FTPDadesConnexio();
		setBounds(new Rectangle(0, 0, 0, 0));
		setLocation(new Point(200, 170));
		addWindowListener(new MyWindowAdapter());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(40, 32767));
		contentPane.setPreferredSize(new Dimension(700, 550));
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
		panel.setBounds(10, 44, 680, 46);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(0, 15, 47, 15);
		panel.add(lblHost);

		JLabel lblUsuari = new JLabel("Username:");
		lblUsuari.setBounds(111, 15, 74, 15);
		panel.add(lblUsuari);

		JLabel lblContrasea = new JLabel("Password:");
		lblContrasea.setBounds(282, 15, 70, 15);
		panel.add(lblContrasea);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(459, 15, 36, 15);
		panel.add(lblPort);

		btnConnect = new JButton("Connect");
		btnConnect.setBounds(555, 10, 90, 25);
		panel.add(btnConnect);

		JMenuBar menuBarFastConn = new JMenuBar();
		menuBarFastConn.setBounds(650, 12, 20, 21);
		panel.add(menuBarFastConn);

		JMenu menu = new JMenu("");
		menu.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarFlecha.png")));
		menuBarFastConn.add(menu);

		JMenuItem mntmCleanBar = new JMenuItem("Clean Bar");
		menu.add(mntmCleanBar);

		JMenuItem mntmCleanHistory = new JMenuItem("Clean History");
		menu.add(mntmCleanHistory);

		textFieldHost = new JTextField();
		textFieldHost.setBounds(37, 13, 64, 19);
		panel.add(textFieldHost);
		textFieldHost.setColumns(10);

		textFieldUser = new JTextField();
		textFieldUser.setBounds(187, 13, 90, 19);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);

		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(354, 13, 98, 19);
		panel.add(fieldPassword);
		fieldPassword.setColumns(10);

		textFieldPort = new JTextField();
		textFieldPort.setBounds(496, 13, 47, 19);
		panel.add(textFieldPort);
		textFieldPort.setColumns(10);

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

		btnToolBarSiteManager = new JButton("");
		btnToolBarSiteManager.setFocusable(false);
		btnToolBarSiteManager.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarSiteManager.setOpaque(false);
		btnToolBarSiteManager.setMargin(new Insets(0, 0, 0, 25));
		btnToolBarSiteManager.setToolTipText("Open the Site Manager");
		btnToolBarSiteManager
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconServerToolBar.png")));
		toolBar.add(btnToolBarSiteManager);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setPreferredSize(new Dimension(10, 2));
		menuBar_1.setOpaque(false);
		menuBar_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolBar.add(menuBar_1);

		mnH = new JMenu("");
		mnH.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarFlecha.png")));
		menuBar_1.add(mnH);
		mnH.setFocusable(false);
		mnH.setBorder(new EmptyBorder(0, 0, 0, 0));
		mnH.setMaximumSize(new Dimension(20, 32767));
		mnH.setPreferredSize(new Dimension(25, 27));

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setMaximumSize(new Dimension(15, 30));
		separator.setPreferredSize(new Dimension(0, 1));
		toolBar.add(separator);

		JButton btnToolBarRefresh = new JButton("");
		btnToolBarRefresh.setFocusable(false);
		btnToolBarRefresh.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarRefresh.setToolTipText("Refresh the file and folder lists");
		btnToolBarRefresh.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarRefresh.png")));
		toolBar.add(btnToolBarRefresh);

		JButton btnToolBarCancel = new JButton("");
		btnToolBarCancel.setFocusable(false);
		btnToolBarCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarCancel.setToolTipText("Cancels the current operation");
		btnToolBarCancel
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconCancelToolBar.png")));
		toolBar.add(btnToolBarCancel);

		JButton btnToolBarServerDisconnect = new JButton("");
		btnToolBarServerDisconnect.setFocusable(false);
		btnToolBarServerDisconnect.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarServerDisconnect.setToolTipText("Disconnects from the currently visible server");
		btnToolBarServerDisconnect.setIcon(new ImageIcon(
				ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarServerDisconnect.png")));
		toolBar.add(btnToolBarServerDisconnect);

		JButton btnToolBarServerConnect = new JButton("");
		btnToolBarServerConnect.setFocusable(false);
		btnToolBarServerConnect.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToolBarServerConnect.setToolTipText("Reconnects to the last used server");
		btnToolBarServerConnect.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconToolBarServerConnect.png")));
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
		menuItemSettigs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ProjectM07FTPSettingsDialog dialog;
				try {
					dialog = new ProjectM07FTPSettingsDialog();
					dialog.setModal(true);
					dialog.setVisible(true);
				} catch (HeadlessException | URISyntaxException | AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		menuItemSettigs.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarSettings.png")));

		menuItemSettigs.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarSettings.png")));
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
		menuBar.add(menuView);

		JMenuItem menuItemRefresh = new JMenuItem("Refresh");
		menuItemRefresh.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarRefresh.png")));
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

		menuItemAddBookmark = new JMenuItem("Add bookmark...");
		menuItemAddBookmark.setIcon(
				new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarBookmark.png")));
		menuItemAddBookmark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		menuBookmarks.add(menuItemAddBookmark);

		JMenuItem menuItemManageBookmarks = new JMenuItem("Manage bookmarks...");
		menuItemManageBookmarks.setMnemonic('M');
		menuItemManageBookmarks
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menuBookmarks.setMnemonic(KeyEvent.VK_F1);
		menuBookmarks.add(menuItemManageBookmarks);

	}

	private void menuFile() {

		JMenu menuFile = new JMenu("File");
		menuFile.setMnemonic('F');

		menuBar.add(menuFile);

		menuItemFile = new JMenuItem("Site Manager");
//		menuItemFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				ProjectM07FTPSiteManagerDialog siteManager = new ProjectM07FTPSiteManagerDialog();
//				siteManager.setModal(true);
//				siteManager.setVisible(true);
//
//			}
//		});
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
		menuItemImport
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarImport.png")));
		menuFile.add(menuItemImport);

		menuItemExport = new JMenuItem("Export");
		menuItemExport
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarExport.png")));

		menuFile.add(menuItemExport);

		JSeparator separator_2 = new JSeparator();
		menuFile.add(separator_2);

		JMenuItem menuItemClose = new JMenuItem("Close");
		menuItemClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuItemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menuFile.add(menuItemClose);

	}

	private void menuHelp() {
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic('H');
		menuBar.add(menuHelp);

		JMenuItem menuItemCheckupdates = new JMenuItem("Check for updates...");
		menuItemCheckupdates
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarUpdate.png")));
		menuItemCheckupdates.setMnemonic('u');
		menuHelp.add(menuItemCheckupdates);

		mntmOpenWelcomeDialog = new JMenuItem("Open welcome dialog");
		menuHelp.add(mntmOpenWelcomeDialog);

		JSeparator separator_2 = new JSeparator();
		menuHelp.add(separator_2);

		menuItemFaqs = new JMenuItem("Faqs...");
		menuItemFaqs
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarFaq.png")));
		menuItemFaqs.setMnemonic('F');
		menuHelp.add(menuItemFaqs);

		menuItemReportBug = new JMenuItem("Report a bug...");
		menuItemReportBug.setMnemonic('R');
		menuItemReportBug.setSelected(true);
		menuHelp.add(menuItemReportBug);

		JSeparator separator_3 = new JSeparator();
		menuHelp.add(separator_3);

		JMenuItem menuItemAbout = new JMenuItem("About...");
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		menuItemAbout
				.setIcon(new ImageIcon(ProjectM07FTPClient.class.getResource("/activities/img/IconMenuBarAbout.png")));
		menuItemAbout.setMnemonic('A');
		menuHelp.add(menuItemAbout);
	}

	class MyWindowAdapter extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {

			String op[] = { "Exit", "Cancel" };

			int n = JOptionPane.showOptionDialog(e.getComponent(), "Do you want to exit?", "Close",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

			if (n == JOptionPane.YES_OPTION) {
				((Window) e.getComponent()).dispose();

			}

		}

	}

	public String getHostFastConn() {
		return textFieldHost.getText();
	}

	public void setHostFastConn(String text) {
		textFieldHost.setText(text);
	}

	public String getUserFastConn() {
		return textFieldUser.getText();
	}

	public void setUserFastConn(String text_1) {
		textFieldUser.setText(text_1);
	}

	public JPasswordField getFieldPasswordFastConn() {
		return fieldPassword;
	}

	public String getPortTextFastConn() {
		return textFieldPort.getText();
	}

	public void setPortTextFastConn(String text_2) {
		textFieldPort.setText(text_2);
	}

	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JMenuItem getMenuItemFile() {
		return menuItemFile;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/pablosanchez1999/ProjectM07FTP
	public JMenu getMenuSiteManagerToolBar() {
		return mnH;
	}
	public JButton getBtnToolBarSiteManager() {
		return btnToolBarSiteManager;
=======

	public JMenuItem getMntmOpenWelcomeDialog() {
		return mntmOpenWelcomeDialog;
	}

	public JMenuItem getMenuItemExport() {
		return menuItemExport;
	}
	public JMenuItem getMenuItemFaqs() {
		return menuItemFaqs;
	}
	public JMenuItem getMenuItemReportBug() {
		return menuItemReportBug;
	}
	public JMenuItem getMenuItemAddBookmark() {
		return menuItemAddBookmark;
>>>>>>> 2a5a00e add dialogs i controllers
	}
}
