import javax.swing.*;
import javax.swing.JLabel.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.io.File.*;
import java.io.PrintWriter.*;
import java.util.Date.*;
import java.text.DateFormat;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;


public class GUIEx extends JPanel implements ActionListener
{
    private JLabel Wlcm;
    
    private JLabel myLabel;
    private JButton myButton;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JButton btnReset;
    private ButtonGroup bg;
    private JTextField txtEmail;
    
    
    
    
    
    public void UserInfo(){
        
        Wlcm = new JLabel ("Welcome To Theme Park Application");
        
        
        
        myLabel=new JLabel("");
        
        myButton=new JButton("OK");
        myButton.addActionListener(this);
        
        btnReset=new JButton("Reset");
        btnReset.addActionListener(this);
        
        rbMale=new JRadioButton("Male");
        rbMale.addActionListener(this);
        rbFemale=new JRadioButton("Female");
        rbFemale.addActionListener(this);
        
        bg=new ButtonGroup();
        
        txtEmail = new JTextField();
        
        
        
        
        
        
        
        
        
        //bg.add(rbMale);
        //bg.add(rbFemale);
        //add(myLabel);
        //add(myButton);
        //add(btnReset);
        //add(rbMale);
        //add(rbFemale);
        
        //add(txtEmail);
        
        add(Wlcm);
        
        
        
        setBackground(Color.white);
        setPreferredSize(new Dimension(900,700));
        
        
        
    }
    
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource(); // source bagitahu button mana nak guna
        if(source==myButton){
            //JOptionPane.showMessageDialog(null, "myButton is clicked");
            //System.out.println("myButton is clicked");
            String email=txtEmail.getText();
            //myLabel.setText("btnOK");
            myLabel.setText(email);
            txtEmail.setEditable(false);
            
        }
        
        else if(source==btnReset){
            //JOptionPane.showMessageDialog(null, "btnRest is clicked");
            //myLabel.setText("btnReset");
            txtEmail.setText(" ");
        }
        
        else if(source==rbMale){
            JOptionPane.showMessageDialog(null, "rbMale is clicked");
        }
        
        else if(source==rbFemale){
            JOptionPane.showMessageDialog(null, "rbFemale is clicked");
        }
    }
    
    
        
    
    
    
    public static void main(String[] args)
    {
        JFrame frame= new JFrame("Theme Park Application");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,200);
        
        
        
        //This will center the JFrame in the middle of the screen
        frame.setLocationRelativeTo(null);
        
        //Create the JTable using the ExampleTableModel implementing
        //the AbstractTableModel abstract class
        JTable table = new JTable(new ExTableModel());
        
        //Set the column sorting functionality on
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(30);
        
        //Set height for individual row
        table.setRowHeight(3,60);
        
        //Uncomment the next line if you want to turn the grid lines off
        // table.setShowGrid(false);
        
        //Change the colour of the table - yellow for gridlines
        //blue for background
        table.setGridColor(Color.BLACK);
        table.setBackground(Color.WHITE);
        
        /*//Place the JTable object in a JScrollPane for a scrolling table
        JScrollPane tableScrollPane = new JScrollPane(table);
        frame.add(tableScrollPane);
        frame.setVisible(true);*/
        
        GUIEx objPanel=new GUIEx();
        objPanel.UserInfo();
        frame.getContentPane().add(objPanel);
        frame.pack();
        frame.setVisible(true);
        
        
    }
}