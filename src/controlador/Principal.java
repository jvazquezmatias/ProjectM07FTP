package controlador;

import java.awt.EventQueue;

import model.ProjectM07FTPDadesConnexio;
import vista.ProjectM07FTPClient;
import vista.ProjectM07FTPSiteManagerDialog;

public class Principal {

	 
	
	public static void main(String[] args) {
		
		ProjectM07FTPSiteManagerDialog siteManager = new ProjectM07FTPSiteManagerDialog();
		ProjectM07FTPClient frame = new ProjectM07FTPClient();
		ProjectM07FTPDadesConnexio dadesConnexio = new ProjectM07FTPDadesConnexio();		
		SiteManagerController siteManagerController = new SiteManagerController(dadesConnexio,frame,siteManager);
		
		
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
