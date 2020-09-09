import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;
import java.util.Date;
import java.nio.file.Paths;
import java.nio.file.Path;

public class MainTheme
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            String key=JOptionPane.showInputDialog("Press 1 to start or 0 to exit:");
            //User have to choose type of user first
            
            while(key.equalsIgnoreCase("1")){
                String typeU=JOptionPane.showInputDialog("Choose type of user \n1. User \n2. Admin \n3. Print Receipt for walk-in customer");
                
                if(typeU.equalsIgnoreCase("1")){
                    JFrame frame=new JFrame("Theme Park Application Program");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                    GUI objPanelPark=new GUI();
                        
                    frame.getContentPane().add(objPanelPark);
                    frame.pack();
                    frame.setVisible(true);
                }
                
                else if(typeU.equalsIgnoreCase("2")){
                    //Data from file
                
                    FileReader fr=new FileReader("DiscHolder.txt");
                    BufferedReader br=new BufferedReader(fr);
                        
                    String name;
                    int age;
                    String gen, pack;
                    int qty;
                    String ic, passport;
                        
                    String inline=br.readLine();
                    
                    //Count how many ppl that has booked from file DiscHolder
                    int count=0;
                    
                    while(inline!=null){
                        inline=br.readLine();
                        count++;
                    }
                    
                    br.close();
                    
                    //Open DiscHolder file and declare the array
                    FileReader fr1=new FileReader("DiscHolder.txt");
                    BufferedReader br1=new BufferedReader(fr1);
                        
                    Person P[]=new Person[count];
                        
                        //tambah date. Kena == date dalam
                    for(int i=0; i<count; i++)
                    {
                        String line=br1.readLine();
                        StringTokenizer st=new StringTokenizer(line, "#");
                            
                        name=st.nextToken();
                        age=Integer.parseInt(st.nextToken());
                        gen=st.nextToken();
                        qty=Integer.parseInt(st.nextToken());
                        pack=st.nextToken();
                            
                        String typeCiti=st.nextToken();
                            
                        if(typeCiti.equalsIgnoreCase("C")){
                            ic=st.nextToken();
                            P[i]=new Citizen(name, age, gen, qty, pack, typeCiti, ic);
                        }
                            
                        else if(typeCiti.equalsIgnoreCase("NC")){
                            passport=st.nextToken();
                            P[i]=new NonCiti(name, age, gen, qty, pack, typeCiti, passport);
                        }                
                    }
            
                    //Insert date by cust yg dah booked lepas tu ==
                    //Count the total price of citizen & non-citizen respectively
                    double totalC=0.0, totalP=0.0, PADiscC=0.0;
                    double totalNC=0.0, totalPNC=0.0, PADiscNC=0.0;
                    int countC=0, countNC=0;
                    
                    //Create new file-Citizen & Non-Citizen file
                    //Count how many citizen & non-citizen that has booked and display
                    FileWriter fw=new FileWriter("Citizen.txt");
                    BufferedWriter bw=new BufferedWriter(fw);
                    PrintWriter pw=new PrintWriter(bw);
                        
                    FileWriter fw1=new FileWriter("Non-Citizen.txt");
                    BufferedWriter bw1=new BufferedWriter(fw1);
                    PrintWriter pw1=new PrintWriter(bw1);
                    
                    for(int i=0; i<count; i++)
                    {
                        if(P[i] instanceof Citizen){
                            Citizen C=(Citizen)P[i];
                            
                            totalP = C.calcPriceC();
                            PADiscC = C.calcDiscF(totalP);
                            totalC=totalC + totalP; 
                            
                            pw.println(C.toString() + "\r\nSubtotal Price(RM): " + totalP + "\r\nPrice after discount(RM): " + PADiscC);
                            countC++;
                        }
                            
                        else if(P[i] instanceof NonCiti){
                            NonCiti NC=(NonCiti)P[i];
                            
                            totalPNC = NC.calcPriceNC();
                            PADiscNC = NC.calcDiscF(totalPNC);
                            totalNC=totalNC + NC.calcPriceNC(); 
                            
                            pw1.println(NC.toString()+ "\r\nSubtotal Price(RM): " + totalPNC + "\r\nPrice after discount(RM): " + PADiscNC);
                            countNC++;
                        }
                    }
                    
                    double totalAll=totalC + totalNC;
                    double avgCustF=totalAll/count;
                    
                    pw.close();
                    pw1.close();
                    
                    //Display the information
                    JOptionPane.showMessageDialog(null, "\t\t   DETAILS OF CUSTOMER WHO HAS BOOKED THE TICKETS");
                    JOptionPane.showMessageDialog(null, "\t\t   TOTAL NUMBER \nCitizen: " + countC + "\nNon-citizen: " + countNC); 
                    JOptionPane.showMessageDialog(null, "\t\t   TOTAL PRICE(RM) \nCitizen: RM " + totalC + "\nNon-citizen: RM " + totalNC); 
                    JOptionPane.showMessageDialog(null, "\t\t   TOTAL PRICE FOR CUSTOMER HAS BOOKED (RM): " + totalAll);
                    JOptionPane.showMessageDialog(null, "\t\t   AVERAGE PRICE FOR CUSTOMER HAS BOOKED (RM): " + avgCustF);
                }
                
                else if(typeU.equalsIgnoreCase("3")){
                    Path path = Paths.get("Details on cust walk-in using GUI.txt");
                    Scanner sc = new Scanner(path);
                    //System.out.println("Read text file using Scanner");
                    int countFG=0;
                    
                    
                    System.out.println("Receipt Customer Walk-in");
                    while(sc.hasNextLine()){
                        
                        String line = sc.nextLine();
                        System.out.println(line);
                        //System.out.println("\n");
                    }
                    sc.close();
                    
                    JOptionPane.showMessageDialog(null, "Thank you for choosing us as your holiday destination!");
                }
                
                else 
                    key=JOptionPane.showInputDialog("Press 1 to continue or 0 to exit:");
                    
                key=JOptionPane.showInputDialog("Press 1 to continue or 0 to exit:");
            }
        }
            
            
           
            
               
                
           
            
            
            //Data untuk walk-in customer guna JOption
            /*String name;
            int age;
            String gen, pack;
            int qty;
            String ic, passport;
          
            
            Scanner sc=new Scanner(System.in);
            
            String input=JOptionPane.showInputDialog("Insert how many person to enter: ");
            int numP=Integer.parseInt(input);
            
            Person P1[]=new Person[numP];
            
            for(int i=0; i<numP; i++)
            {
                JOptionPane.showMessageDialog(null, "Package                   | Citizen Price | Non-Citizen Price | \nA.Neuro Kingdoms| RM 35.00          | RM50.00 | \nB.Inviso Adventure | RM 45.00         | RM 60.00 | \nC.Techno City         | RM 40.00          | RM 55.00 | \nD.Kombat Miniland | RM 50.00         | RM 65.00 | "); 
                String packP=JOptionPane.showInputDialog("Insert Package: "); 
                input=JOptionPane.showInputDialog("Insert number of ticket(s) you want to purchase: ");
                int qtyP=Integer.parseInt(input);
                String nameP=JOptionPane.showInputDialog("Insert Name: ");
                input=JOptionPane.showInputDialog("Insert age: ");
                int ageP=Integer.parseInt(input);
                String genP=JOptionPane.showInputDialog("Insert gender: ");
                String typeCitiP=JOptionPane.showInputDialog("Insert type of citizen [Citizen: C / Non-Citizen: NC]: ");
                
                if(typeCitiP.equalsIgnoreCase("C")){
                    String icP=JOptionPane.showInputDialog("Insert IC number: ");
                    P1[i]=new Citizen(nameP, ageP, genP, qtyP, packP, typeCitiP, icP);
                }
                
                else if(typeCitiP.equalsIgnoreCase("NC")){
                    String passportP=JOptionPane.showInputDialog("Insert passport number: ");
                    P1[i]=new NonCiti(nameP, ageP, genP, qtyP, packP, typeCitiP, passportP);
                }                
            }
            
            double totalCP=0.0, discC=0.0, totalPriceC=0.0;
            double totalNCP=0.0, discNC=0.0, totalPriceNC=0.0;
            
            for(int i=0; i<numP; i++)
            {
                if(P1[i] instanceof Citizen){
                    Citizen C = (Citizen) P1[i];
                    totalCP = C.calcPriceC(); 
                    
                    if(totalCP >= 100){
                        JOptionPane.showMessageDialog(null, "Congratulations! You are eligible for our discount!");
                    }
                    
                    else
                        JOptionPane.showMessageDialog(null, "Sorry! You are not eligible for our discount!");
                    
                    discC=C.calcDisc(totalCP);  
                    
                    JOptionPane.showMessageDialog(null, "Subtotal Citizen(RM): " + totalCP);
                    JOptionPane.showMessageDialog(null, "Price after discount for Citizen(RM): " + discC);
                    
                    totalPriceC=totalPriceC + discC;
                }
                
                else if(P1[i] instanceof NonCiti){
                    NonCiti NC = (NonCiti) P1[i];
                    totalNCP = NC.calcPriceNC();
                    
                    if(totalNCP >= 300){
                        JOptionPane.showMessageDialog(null, "Congratulations! You are eligible for our discount!");
                    }
                    
                    else
                        JOptionPane.showMessageDialog(null, "Sorry! You are not eligible for our discount!");
                    
                    discNC=NC.calcDisc(totalNCP);
                    
                    JOptionPane.showMessageDialog(null, "Subtotal Non-Citizen(RM): " + totalNCP);
                    JOptionPane.showMessageDialog(null, "Price after discount for Non-Citizen(RM): " + discNC);
                    
                    totalPriceNC=totalPriceNC + discNC;
                }
            }
            
            
            JOptionPane.showMessageDialog(null, "\t\t Total Price for Walk-in Customer" + "\n1.Citizen " + "RM " + totalPriceC + "\n2.Non-Citizen " + "RM " + totalPriceNC);
            
            FileWriter fwW=new FileWriter("Details on walk-in customer.txt", true);
            BufferedWriter bwW = new BufferedWriter(fwW);
            PrintWriter pwW = new PrintWriter(bwW);
            
            for(int i=0; i<numP; i++){
                
                if(P1[i] instanceof Citizen){
                    Citizen C=(Citizen)P1[i];
                    
                    pwW.println(C.toString());                
                }
                
                else if(P1[i] instanceof NonCiti){
                    NonCiti NC=(NonCiti)P1[i];
                    
                    pwW.println(NC.toString());              
                }         
            }
            
            pwW.close();*/
            
            
    
        
        catch(FileNotFoundException fnf){
                System.out.println(fnf.getMessage());
        }
        
        catch(EOFException eof){
            System.out.println(eof.getMessage());
        }
        
        
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        
        finally{
            //System.out.println("System end here! Thank you.");
        }    
    }
}

