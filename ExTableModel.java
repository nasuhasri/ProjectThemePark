import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

public class ExTableModel extends AbstractTableModel
{
    private String code[] = new String[4];
    private double priceC[] = new double[4];
    
    //Two arrays used for the table data
    String[] columnNames = {"Package Name", "Price for Citizens", "Price for Non-Citizens"};
        
    Object[][] data = 
    {
        {"Neuro Kingdoms", "RM 35.00", "RM 50.00", false},
        {"Inviso Adventure", "RM 45.00", "RM 60.00",false},
        {"Techno City", "RM 40.00", "RM 55.00", false},
        {"Kombat Miniland", "RM 50.00", "RM 65.00", false},
    };
        
    @Override
    public int getRowCount(){
        return data.length;
    }
        
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
     
    @Override
    public Object getValueAt(int row, int column){
        return data[row][column];
    }
        
    //Used by the JTable object to set the column names
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
        
    //Used by the JTable object to render different
    //functionality based on the data type
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
        
    @Override
    public boolean isCellEditable(int row, int column){
        if (column == 0 || column == 1){
            return false;
        }
            
        else{
            return true;
        }
    }
    
    public ExTableModel(){
        
        code[0]="Do717"; priceC[0]= 171; 
        code[1]="Do766"; priceC[1]= 211;  
        code[2]="Do881"; priceC[2]= 330; 
        code[3]="Do990"; priceC[3]= 250; 
        
    }
}
    