package activities;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.KeyEvent;

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
	
		menuEdicion();
		
		menuVer();

		menuServidor();

		pack();

	}
	
	private void menuEdicion() {
		JMenu menuVer = new JMenu("Edición");
		menuBar.add(menuVer);

		JMenuItem menuItemEdicion = new JMenuItem("Limpiar información privada...");
		menuVer.add(menuItemEdicion);
		
		JSeparator separator = new JSeparator();
		menuVer.add(separator);
		
		JMenuItem menuItemOpciones = new JMenuItem("Opciones...");
		menuVer.add(menuItemOpciones);		

	}

	private void menuServidor() {
		JMenu menuVer = new JMenu("Servidor");
		menuBar.add(menuVer);

		JMenuItem menuItemOperacionActual = new JMenuItem("Cancelar operacion actual");
		menuVer.add(menuItemOperacionActual);
		
		JSeparator separator = new JSeparator();
		menuVer.add(separator);
		
		JMenuItem menuItemReconectar = new JMenuItem("Reconectar");
		menuVer.add(menuItemReconectar);		
		JMenuItem menuItemDesconectar = new JMenuItem("Desconectar");
		menuVer.add(menuItemDesconectar);			
		JSeparator separator2 = new JSeparator();
		menuVer.add(separator2);
		JMenuItem menuItemMostrarArchivosOcultos = new JMenuItem("Mostrar archivos ocultos");
		menuVer.add(menuItemMostrarArchivosOcultos);	
		
	}

	public void menuVer() {
		JMenu menuVer = new JMenu("Ver");
		menuBar.add(menuVer);
	
		JMenuItem menuItemVerActualizar = new JMenuItem("Actualizar");
		menuItemVerActualizar.setMnemonic(KeyEvent.VK_F1);
		menuVer.add(menuItemVerActualizar);

		JSeparator separator = new JSeparator();
		menuVer.add(separator);

		JCheckBoxMenuItem checkBarraYEstados = new JCheckBoxMenuItem("Barra y estado de lista de archivos");
		checkBarraYEstados.setSelected(true);
		menuVer.add(checkBarraYEstados);

		JSeparator separator_1 = new JSeparator();
		menuVer.add(separator_1);

		JCheckBoxMenuItem checkBarraHerramientas = new JCheckBoxMenuItem("Barra de herramientas");
		checkBarraHerramientas.setSelected(true);
		menuVer.add(checkBarraHerramientas);

		JCheckBoxMenuItem checkBarraConexionRapida = new JCheckBoxMenuItem("Barra de conexión rápida");
		checkBarraConexionRapida.setSelected(true);
		menuVer.add(checkBarraConexionRapida);

		JCheckBoxMenuItem checkRegistroMensajes = new JCheckBoxMenuItem("Registro de mensajes");
		checkRegistroMensajes.setSelected(true);
		menuVer.add(checkRegistroMensajes);

		JCheckBoxMenuItem checkArbolLocal = new JCheckBoxMenuItem("Árbol de directorio local");
		checkArbolLocal.setSelected(true);
		menuVer.add(checkArbolLocal);

		JCheckBoxMenuItem checkArbolRemoto = new JCheckBoxMenuItem("Árbol de directorio remoto");
		checkArbolRemoto.setSelected(true);
		menuVer.add(checkArbolRemoto);

		JCheckBoxMenuItem checkColaTransferencia = new JCheckBoxMenuItem("Cola de transferencia");
		checkColaTransferencia.setSelected(true);
		menuVer.add(checkColaTransferencia);
	}

}
