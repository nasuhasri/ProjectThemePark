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


public class GUI extends JPanel implements ActionListener 
{
    private JLabel lblPackage, lblPriceC, lblPriceNC;
    
    private JLabel lblNeuro;
    private JLabel lblInviso;
    private JLabel lblTechno;
    private JLabel lblKombat;
    
    private JLabel lblNeuroCP;
    private JLabel lblInvisoCP;
    private JLabel lblTechnoCP;
    private JLabel lblKombatCP;
    
    private JLabel lblNeuroNCP;
    private JLabel lblInvisoNCP;
    private JLabel lblTechnoNCP;
    private JLabel lblKombatNCP;
    
    private JLabel lblPack;
    private JTextField txtPack;
    /*private ButtonGroup bgP;
    private JRadioButton rbPNeuro;
    private JRadioButton rbPInviso;
    private JRadioButton rbPTechno;
    private JRadioButton rbPKombat;*/
    
    private JLabel lblNumTicks;
    private JTextField txtNumTicks;
    
    private JLabel lblTypeCiti;
    //private JTextField txtTypeC;
    private ButtonGroup bgC;
    private JRadioButton rbCiti;
    private JRadioButton rbNCiti;
    
    private JLabel lblNm;
    private JTextField txtNm;
    
    private JLabel lblAge;
    private JTextField txtAge;
    
    private JLabel lblGen;  
    private ButtonGroup bgG;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    
    //Nak mencantikkan gui
    private JLabel lbl01, lbl02, lbl03, lbl04, lbl05, lbl06, lbl07, lbl08, lbl09, lbl10;
    private JLabel lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20;
    
    private JLabel lblSubTotal;
    private JLabel lblPrice;
    
    private JLabel lblDiscP;
    private JLabel DiscP;
    
    private JLabel lblPriceADisc;
    private JLabel ADisc;
    
    private JButton btnOK;
    private JButton btnCalc;
    private JButton btnReset;
    
    private JLabel lblDate;
    
    
    
    
    
    public GUI(){
        setLayout(new GridLayout(18,25));
        
        //AutomaticDate
        Date now = new Date();
        lblDate = new JLabel();
        lblDate.setText(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(now));
        
        //Table price for package
        lblPackage = new JLabel("Package Name");
        lblPriceC = new JLabel("Price for Citizen");
        lblPriceNC = new JLabel("Price for Non-Citizen");
        
        lblNeuro = new JLabel("A. Neuro Kingdoms");
        lblInviso = new JLabel("B. Inviso Adventure");
        lblTechno = new JLabel("C. Techno City");
        lblKombat = new JLabel("D. Kombat Miniland");
        
        lblNeuroCP = new JLabel("RM 35.00");
        //lblNeuroCP.setBounds(50,100, 250,20);  
        lblInvisoCP = new JLabel("RM 45.00");
        lblTechnoCP = new JLabel("RM 40.00");
        lblKombatCP = new JLabel("RM 50.00");
        
        lblNeuroNCP = new JLabel("RM 50.00");
        lblInvisoNCP = new JLabel("RM 60.00");
        lblTechnoNCP = new JLabel("RM 55.00");
        lblKombatNCP = new JLabel("RM 65.00");
                
        lblPack=new JLabel("Choose Package [A/B/C/D]: ");
        txtPack = new JTextField();
        /*rbPNeuro=new JRadioButton("Neuro Kingdoms");
        rbPNeuro.addActionListener(this);
        rbPInviso=new JRadioButton("Inviso Adventure");
        rbPInviso.addActionListener(this);  
        rbPTechno=new JRadioButton("Techno City");
        rbPTechno.addActionListener(this);  
        rbPKombat=new JRadioButton("Kombat Miniland");
        rbPKombat.addActionListener(this);*/
        
        //Number of ticket yg user kena masukkan
        lblNumTicks=new JLabel("Number of ticket(s) to purchase:");
        txtNumTicks=new JTextField();
        
        //User kena pilih Citizen/Non-Citizen
        lblTypeCiti=new JLabel("Type of citizen: ");
        //txtTypeC=new JTextField();
        rbCiti=new JRadioButton("Citizen");
        rbCiti.addActionListener(this);
        rbNCiti=new JRadioButton("Non-Citizen");
        rbNCiti.addActionListener(this); 
        
        //User key-in name
        lblNm=new JLabel("Full Name: ");        
        txtNm=new JTextField();
        
        //User key-in age
        lblAge=new JLabel("Age(years): ");
        txtAge=new JTextField();
        
        //User choose gender
        lblGen=new JLabel("Gender: ");
        rbMale=new JRadioButton("Male");
        rbMale.addActionListener(this);
        rbFemale=new JRadioButton("Female");
        rbFemale.addActionListener(this);  
        
        //Price before disc
        lblSubTotal=new JLabel("Sub Total Price(RM): ");        
        lblPrice=new JLabel("0.0");
        
        //Disc price
        lblDiscP=new JLabel("Discount Price(RM): ");
        DiscP=new JLabel("0.0");
        
        //Price after disc
        lblPriceADisc=new JLabel("Total Price After Disc(RM): ");
        ADisc=new JLabel("0.0");
        
        btnOK=new JButton("OK");
        btnOK.addActionListener(this);
        
        btnCalc=new JButton("CALCULATE");
        btnCalc.addActionListener(this);
        
        btnReset=new JButton("RESET");
        btnReset.addActionListener(this);
        
        
        
        lbl01=new JLabel("\t\t\t\t\t\t"); lbl02=new JLabel("\t\t\t\t\t\t");
        lbl03=new JLabel("\t\t\t\t\t\t"); lbl04=new JLabel("\t\t\t\t\t\t");
        lbl05=new JLabel("\t\t\t\t\t\t"); lbl06=new JLabel("");
        lbl07=new JLabel("\t\t\t\t\t\t"); lbl08=new JLabel("\t\t\t\t\t\t");
        lbl09=new JLabel("\t\t\t\t\t\t"); lbl10=new JLabel("\t\t\t\t\t\t");
        lbl11=new JLabel("\t\t\t\t\t\t"); lbl12=new JLabel("\t\t\t\t\t\t");
        lbl13=new JLabel(""); lbl14=new JLabel("");
        lbl15=new JLabel(""); lbl16=new JLabel("");
        lbl17=new JLabel(""); lbl18=new JLabel("");
        lbl19=new JLabel(""); lbl20=new JLabel("");
        
        
        add(lblPackage); add(lblPriceC); add(lblPriceNC);
        add(lblNeuro); add(lblNeuroCP); add(lblNeuroNCP); 
        add(lblInviso); add(lblInvisoCP); add(lblInvisoNCP); 
        add(lblTechno); add(lblTechnoCP); add(lblTechnoNCP); 
        add(lblKombat); add(lblKombatCP); add(lblKombatNCP); add(lbl03);
        
        add(lblPack); add(txtPack); //add(lbl07); 
        /*add(rbPNeuro); add(lbl03);
        add(rbPInviso); add(lbl04);
        add(rbPTechno); add(lbl05);
        add(rbPKombat);
        bgP=new ButtonGroup();
        bgP.add(rbPNeuro);
        bgP.add(rbPInviso);
        bgP.add(rbPTechno);
        bgP.add(rbPKombat);    */ 
                
        
        add(lbl04); add(lblNumTicks); add(txtNumTicks); 
        
        add(lbl05); add(lblNm); add(txtNm); 
        
        add(lbl06); add(lblAge); add(txtAge); 
        
        add(lbl07); add(lblGen);
        add(rbMale); add(lbl01); add(lbl08);
        add(rbFemale);        
        bgG=new ButtonGroup();
        bgG.add(rbMale);
        bgG.add(rbFemale); 
        
        add(lbl09); add(lblTypeCiti);
        add(rbCiti); add(lbl02); add(lbl10);
        add(rbNCiti);        
        bgC=new ButtonGroup();
        bgC.add(rbCiti);
        bgC.add(rbNCiti); 
        
        add(lbl11); add(lblSubTotal); add(lblPrice);
        
        add(lbl12); add(lblDiscP); add(DiscP);
        
        add(lbl13); add(lblPriceADisc); add(ADisc);
        
        add(lbl14); add(btnOK);
        //add(btnCalc);
        add(btnReset);
        add(lblDate);
        
        setBackground(Color.white);
        setPreferredSize(new Dimension(900,700));
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object source=e.getSource();
        
        double price = 0.0, disc=0.0, PADisc=0.0;
        double totalPriceC=0.0, totalPriceNC=0.0;
        
        //When user click 'Citizen', automatic it will count the price
        if(source==rbCiti && rbCiti.isSelected()){
            String icP=JOptionPane.showInputDialog("Insert IC number [Eg: 000210-04-xxxx]: ");
            
            String pack=(txtPack.getText());
            String typeC=rbCiti.getText();
            int numTicks = (Integer.parseInt(txtNumTicks.getText()));
            
            if(pack.equalsIgnoreCase("A")){
                price=numTicks * 35.00;
                lblPrice.setText(price + "");
                    
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                //Data from walk-in user will be write in file
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package Name: Neuro Kingdoms"); 
                    out.println("\nNumber of Ticket(s) Purchased: " + numTicks);
                    out.println("\nTotal Price after Discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + icP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("B")){
                price=numTicks * 45.00;
                lblPrice.setText(price + "");
                        
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                 
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                 
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Inviso Adventure"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + icP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("C")){
                String packF="Techno City";
                price=numTicks * 40.00;
                lblPrice.setText(price + "");
                        
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Techno City"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + icP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("D")){
                String packF="Kombat Miniland";
                price=numTicks * 50.00;
                lblPrice.setText(price + "");
                        
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Kombat Miniland"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + icP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
            
        }
        
        //When user click 'Non-Citizen', it will count the price automatically
        else if(source==rbNCiti && rbNCiti.isSelected()){
            String passportP=JOptionPane.showInputDialog("Insert passport number [Eg: 93216742]: ");
            
            String pack=(txtPack.getText());
            String typeC=rbNCiti.getText();
            int numTicks = (Integer.parseInt(txtNumTicks.getText()));
            
            if(pack.equalsIgnoreCase("A")){
                price=numTicks * 50.00;
                lblPrice.setText(price + "");
                    
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Neuro Kingdoms"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + passportP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("B")){
                 price=numTicks * 60.00;
                 lblPrice.setText(price + "");
                        
                 disc=calcDisc(price, typeC);
                 DiscP.setText(disc + "");
                 
                 PADisc=calcPriceADisc(price, disc);
                 ADisc.setText(PADisc + "");
                 
                 try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Inviso Adventure"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + passportP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("C")){
                price=numTicks * 55.00;
                lblPrice.setText(price + "");
                        
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Techno City"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + passportP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
                
            else if(pack.equalsIgnoreCase("D")){
                price=numTicks * 65.00;
                lblPrice.setText(price + "");
                        
                disc=calcDisc(price, typeC);
                DiscP.setText(disc + "");
                
                PADisc=calcPriceADisc(price, disc);
                ADisc.setText(PADisc + "");
                
                try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
                {
                    out.println("Package name: Kombat Miniland"); 
                    out.println("\nNumber of ticket(s) purchased: " + numTicks);
                    out.println("\nTotal price after discount(RM): " + PADisc);
                    out.println("\nType of Citizen: " + typeC);
                    out.println("\nIC Number: " + passportP);
                }
                
                catch(IOException e1){
                    System.err.println("Error");
                    e1.printStackTrace();
                }
            }
            
            //totalPriceNC=totalPriceNC + PADisc;
        }
        
        //When user click 'OK', user cannot edit the information anymore and it write to the file
        if(source==btnOK)
        {
            txtNm.setEditable(false);
            txtAge.setEditable(false);
            txtNumTicks.setEditable(false);
            txtPack.setEditable(false);
            Date now = new Date();
        //lblDate = new JLabel();
        //lblDate.setText(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(now));*/
            try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
            {
                out.println("Name: " + txtNm.getText());
                out.println("Age: " + txtAge.getText());
                out.println("Date receipt print: " + (DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM).format(now)));
                out.println("\n");
            }
                
            catch(IOException e1){
                System.err.println("Error");
                e1.printStackTrace();
            }
            
            
        }
         
        if(source==rbMale){
            try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
            {
                out.println("Gender: " + rbMale.getText());
            }
                
            catch(IOException e1){
                System.err.println("Error");
                e1.printStackTrace();
            }
        }
        
        else if(source==rbFemale){
            try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("Details on cust walk-in using GUI.txt",true))))
            {
                out.println("Gender: " + rbFemale.getText());
            }
                
            catch(IOException e1){
                System.err.println("Error");
                e1.printStackTrace();
            }
        }       
        
        //When user click 'Reset', then all the info will be default. 
        if(source==btnReset)
        {
            txtNm.setText("");
            txtNm.setEditable(true);
            
            txtAge.setText("");
            txtAge.setEditable(true);
            
            txtNumTicks.setText("");
            txtNumTicks.setEditable(true);
            
            txtPack.setText("");
            txtPack.setEditable(true);
            
            lblPrice.setText("0.00" );
            DiscP.setText("0.00");
            ADisc.setText("0.00");
            
            bgG.clearSelection();
            bgC.clearSelection();
            //bgP.clearSelection();
        }        
    }    
    
    //Method to calc disc for Citizen & Non-Citizen
    public double calcDisc(double price, String typeC){
        double disc=0.0;
        
        if(typeC.equalsIgnoreCase("Citizen")){
            if(price >= 100){
                JOptionPane.showMessageDialog(null, "Congratulations! You are eligible for our discount!");
                disc = price * 0.20; 
            }
            
            else 
                JOptionPane.showMessageDialog(null, "Sorry! You are not eligible for our discount.");
        }
        
        else if(typeC.equalsIgnoreCase("Non-Citizen")){
            if(price >= 300){
                JOptionPane.showMessageDialog(null, "Congratulations! You are eligible for our discount!");
                disc = price * 0.20; 
            }
            
            else
                JOptionPane.showMessageDialog(null, "Sorry! You are not eligible for our discount.");
        }
        
        return disc;
    }
    
    //Method to calc price after disc
    public double calcPriceADisc(double price, double disc){
        double ADisc=price-disc;
        
        return ADisc;
    }
    
    
    
    
    
       
    
    /*public static void main(String[] args) throws IOException
    {
            JFrame frame=new JFrame("Theme Park Application Program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
        
            GUI objPanelStud=new GUI();
            
            /*FileWriter fw=new FileWriter("studentData.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);*/
            
            //frame.getContentPane().add(objPanelStud);
            //frame.pack();
            //frame.setVisible(true);
    //}*/
    
}