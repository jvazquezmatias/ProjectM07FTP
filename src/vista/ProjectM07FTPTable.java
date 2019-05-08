package vista;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import vista.ColorEditor;
import vista.ColorRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import controlador.TableController;

/**
 * This is like TableDemo, except that it substitutes a
 * Favorite Color column for the Last Name column and specifies
 * a custom cell renderer and editor for the color data.
 */

public class ProjectM07FTPTable extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
    private String path;
    public ProjectM07FTPTable(String path) {
        super(new GridLayout(1,0));
        this.path = path;
        JTable table = new JTable(new TableController(path));
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Set up renderer and editor for the Favorite Color column.
        table.setDefaultRenderer(Color.class,new ColorRenderer(true));
        table.setDefaultEditor(Color.class,new ColorEditor());

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

}