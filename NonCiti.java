public class NonCiti extends Person
{
    private String passportNo;
    
    public NonCiti(String n, int a, String g, int nT, String pack, String typeC, String p){
        super(n, a, g, nT, pack, typeC);
        passportNo=p;
    }
    
    public String getPassport(){
        return passportNo;
    }
    
    public String toString(){
        return(super.toString() + "\r\nPassport number: " + passportNo);
    }
    
    public double calcPriceNC(){
        double price=0.0, pricePNC=0.0;
        
        if(super.getPack().equalsIgnoreCase("A")){
            price=super.getNumT() * 50.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("B")){
            price=super.getNumT() * 60.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("C")){
            price=super.getNumT() * 55.00;
        }
        
        else if(super.getPack().equalsIgnoreCase("D")){
            price=super.getNumT() * 65.00;
        }
        
        return price;
    }
    
    //Disc untuk non-citizen yg walk-in
    public double calcDisc(double totalP){
        double disc=0.2, totalAll=0.0;
        
        if(totalP >= 300){
            totalAll=totalP*0.8;
        }
        
        else
            totalAll=totalP;     
        
        return totalAll;
    }
    
    //Disc untuk customerNonCiti yg dah booked drpd file
    public double calcDiscF(double totalP){
        double disc=0.3, totalAll=0.0;
        
        if(totalP >= 200){
            totalAll=totalP*0.7;
        }
        
        else
            totalAll=totalP;     
        
        return totalAll;
    }  
}