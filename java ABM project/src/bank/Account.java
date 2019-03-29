package bank;

public class Account{

    private final AccountType type;
    private double balance;
	private double interestRate;
	
	public Account() {
		this.balance=0.0;
		type=AccountType.savings;
	}
    public Account(AccountType accType, double accBalance){

        type = accType;
        balance = accBalance;
    }

    public String getType(){
        return type.longName();
    }

    public AccountType getAccountType(){
        return type;
    }

    public double currentBalance(){
        return balance;
    }

    public double calcInterest(int days){
        double totalInterest, daysInterest;
        totalInterest = balance * type.interestRate();
        daysInterest = totalInterest * ((double)days/365.25);
        return daysInterest;
    }
	
	
	

	AccountType xy= AccountType.investment;
	AccountType zy= AccountType.chequing;
	
	
	double x= currentBalance();
	
	/*
	public double deposit(double amt){
		for (AccountType a: AccountType.values()){
           
                if (getAccountType().equalsIgnoreCase(xy.name())){
					x= x+ amt-120.00;
					return x;
				} else{ x= x+amt;
				return x;
				}
            
        }
		
	} 
	
	public double withdraw(double amt){
		for (AccountType b: AccountType.values()){
           // if (getAccountType().equalsIgnoreCase(b.longName())){
			   
			   
               if (getAccountType().equalsIgnoreCase(zy.name())){
					x= x- (amt+15.00);
					return x;
				} else{ x= x-amt;
				return x;
				}
            
        }
		
	} 
	
}**/

	/*
public void multiple(double cash)	{
	if(cash>1000) {
		int x=cash/1000;
		if ()
	}
}  */
	
	
public void withdraw(double amt){
	if (amt%100==0) {
	if (getType().equalsIgnoreCase("investment")) {
		
			System.out.println("Invalid account type");
		
	}else {
		if (balance>amt) {
			String bills= bills(amt);
			balance-=amt;
			System.out.println("Bills"+ bills);
			
		} else {
			System.out.println("Not enough money");
		}
		
	}
	}else if (amt%100!=0)
	{
		System.out.println("Not a mutiple of hundred");
	} 
}
public void deposit (double amt){
	if (getType().equalsIgnoreCase("Investment")) {
		balance= balance+amt;
		
	} else {
		balance+= amt;
	}
}




public static String bills(double amt) {
	int b1000=0,b500=0,b100=0,c=0;
	String mon= " ";
	double fin=amt;
	
	
	
	while(amt>=1000) {
		
		
		b1000=(int)(amt/1000);
		amt= amt%1000;
		mon+= b1000+ "X "+ "$1000+ ";
		break;
	}
	
while(amt>=500) {
		
		
		b500=(int)(amt/500);
		amt= amt%500;
		mon+= b500+ "X "+ "$500+ ";
		break;
	}
	
	
	
	
while(amt>=100) {
	
	
	b100=(int)(amt/100);
	amt= amt%100;
	mon+= b100+ "X "+ "$100+ ";
	break;
}	

c= b1000+ b500+ b100;
return mon.substring(0,mon.length()-2)+" = "+ String.format("%.2f", fin);



	
	
}






}