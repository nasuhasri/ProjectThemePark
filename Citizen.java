public class Citizen extends Person
{
    private String IC;
   
    public Citizen(String n, int a, String g, int nT, String p, String typeC, String ic){
        super(n, a, g, nT, p, typeC);
        IC=ic;
    }
    
    public String getIC(){
        return IC;
    }
    
    public String toString(){
        return(super.toString() + "\r\nIC number: " + IC);
    }
    
    //Kira total price utk citizen yg walk-in
    public double calcPriceC(){
        double price=0.0, pricePC=0.0;
        
        if(super.getPack().equalsIgnoreCase("A")){
            price=super.getNumT() * 35.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("B")){
            price=super.getNumT() * 45.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("C")){
            price=super.getNumT() * 40.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("D")){
            price=super.getNumT() * 50.00;
        }
        
        return price;
    }
    
    //Disc untuk citizen yg walk-in
    public double calcDisc(double totalP){
        double disc=0.2, totalAll=0.0;
        
        if(totalP >= 100){
            totalAll=totalP*0.8;
        }
        
        else
            totalAll=totalP;        
        
        return totalAll;
    }
    
    //Disc untuk customerCiti yg dah booked drpd file
    public double calcDiscF(double totalP){
        double disc=0.5, totalAll=0.0;
        
        if(totalP >= 100){
            totalAll=totalP*0.5;
        }
        
        else
            totalAll=totalP;        
        
        return totalAll;
    }
}