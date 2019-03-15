package activities;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.KeyEvent;

public class ProjectM07FTPClient extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuHelp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectM07FTPClient frame = new ProjectM07FTPClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectM07FTPClient() {
		setLocation(new Point(200, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile();
		menuEdit();

		menuView();

		menuServer();
		menuTransfer();
		menuHelp();
		pack();

	}

	private void menuTransfer() {
		JMenu menuTransfer = new JMenu("Transfer");
		menuBar.add(menuTransfer);
		JMenuItem menuProcessQueue = new JMenuItem("Process Queue");
		menuTransfer.add(menuProcessQueue);
		JSeparator separator = new JSeparator();
		menuTransfer.add(separator);
	}

	private void menuFile() {

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItemFile = new JMenuItem("Site Manager");
		menuFile.add(menuItemFile);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuItemNewWindow = new JMenuItem("New Window");
		menuFile.add(menuItemNewWindow);

		JMenuItem menuItemCloseWindow = new JMenuItem("Close Window");
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
		menuFile.add(menuItemClose);

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
		menuBar.add(menuView);

		JMenuItem menuItemRefresh = new JMenuItem("Refresh");
		menuItemRefresh.setMnemonic(KeyEvent.VK_F1);
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

	private void menuHelp() {
		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		JMenuItem menuItemCheckupdates = new JMenuItem("Check for updates");
		menuItemCheckupdates.setMnemonic('u');
		menuHelp.add(menuItemCheckupdates);

		JSeparator separator_2 = new JSeparator();
		menuHelp.add(separator_2);
		
		JMenuItem menuItemFaqs = new JMenuItem("Faqs");
		menuItemFaqs.setMnemonic('F');
		menuHelp.add(menuItemFaqs);
		
		JMenuItem menuItemReportBug = new JMenuItem("Report a bug");
		menuItemReportBug.setMnemonic('R');
		menuItemReportBug.setSelected(true);
		menuHelp.add(menuItemReportBug);

		JSeparator separator_3 = new JSeparator();
		menuHelp.add(separator_3);
		
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuItemAbout.setMnemonic('A');
		menuHelp.add(menuItemAbout);
	}

}
