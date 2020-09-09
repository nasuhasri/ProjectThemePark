public class Person
{
    protected String name;
    protected int age;
    protected String gen;
    protected int numTicks;
    protected String pack;
    protected String typeCiti;
    
    
    public Person(String n, int a, String g, int nT, String p, String typeC)
    {
        name=n;
        age=a;
        gen=g;
        numTicks=nT;
        pack=p;
        typeCiti=typeC;
    }
    
    public String getNm(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getGen(){
        return gen;
    }
    
    public int getNumT(){
        return numTicks;
    }
    
    public String getPack(){
        return pack;
    }
    
    public String getTypeC(){
        return typeCiti;
    }
    
    public String toString(){
        String dispP=" ";
        
        if(getPack().equalsIgnoreCase("A")){
            dispP="Neuro Kingdoms";
        }
        
        else if(getPack().equalsIgnoreCase("B")){
            dispP="Inviso Adventure";
        }
        
        else if(getPack().equalsIgnoreCase("C")){
            dispP="Techno City";
        }
        
        else if(getPack().equalsIgnoreCase("D")){
            dispP="Kombat Miniland";
        }
        
        return("\r\nName: " + name + "\r\nAge: " + age + "\r\nGender: " + gen + "\r\nNumber of tickets: " + numTicks + "\r\nPackage: " + dispP + "\r\nType of citizen: " + typeCiti);
    }
}