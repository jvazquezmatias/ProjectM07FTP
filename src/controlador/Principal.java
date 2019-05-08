package controlador;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URISyntaxException;

import model.ProjectM07FTPDadesConnexio;
import vista.ProjectM07FTPAddBookmarksDialog;
import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPManegesBookmarks;
import vista.ProjectM07FTPSettingsDialog;
import vista.ProjectM07FTPSiteManagerDialog;

public class Principal {

	 
	
	public static void main(String[] args) throws HeadlessException, URISyntaxException, AWTException, IOException {
		
		
		ProjectM07FTPSiteManagerDialog siteManager = new ProjectM07FTPSiteManagerDialog();
		ProjectM07FTPClient frame = new ProjectM07FTPClient();
		ProjectM07FTPDadesConnexio dadesConnexio = new ProjectM07FTPDadesConnexio();		
		new SiteManagerController(dadesConnexio,frame,siteManager);
		ProjectM07FTPManegesBookmarks manage = new ProjectM07FTPManegesBookmarks();
		ProjectM07FTPAddBookmarksDialog book = new ProjectM07FTPAddBookmarksDialog();
		new ExplorarController(frame);
		new FaqsController(frame);
		new ReportABugController(frame);
		new BookmarksController(frame, manage, book);
		WelcomeController welcomeController = new WelcomeController(frame ); 
		welcomeController.openWelcomeDialog();
		ProjectM07FTPSettingsDialog settings = new ProjectM07FTPSettingsDialog();
		new SettingsController(settings,frame);

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
					frame.setSize(700, 550);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
