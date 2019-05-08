package controlador;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class TableController extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"File name",
                                    "File size",
                                    "File type",
                                    "Last day modified"};
    private String path;
    private ArrayList<Object[]>  data;
   // private Object[][] data ;
    
    public TableController(String path) {
    	

    	//data = (Object) f.listFiles();
    	data =  new ArrayList<Object[]>();
    	File f = new File(path);
        for (File file : f.listFiles()) {
        	Object[] aux = new Object[4];
        	aux[0] = file.getName();
			if(file.isDirectory()) {
				aux[1] = "";
				aux[2] = "directory";
			}
			else {
				aux[1] = file.length();
    			if(getFileExtension(file).equals("")) aux[2] = "file";
    			else aux[2] = getFileExtension(file)+"-file";
			}			
			aux[3]= new Date(f.lastModified());
			
			addRow(aux);
		}
    }
    public void addRow(Object[] o) {
    	data.add(o);
    }
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
      
        Object[] aux = new Object[4];
        aux[col] = value;
        data.set(row, aux);
        
        fireTableCellUpdated(row, col);

    }
}