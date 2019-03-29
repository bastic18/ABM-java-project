package bank;

import java.io.IOException;
import java.util.*;

public class Lab5Main{

    private ArrayList<String[]> accountData = new ArrayList<String[]>();
    private static ArrayList<String> logData = new ArrayList<String>();
    // ToDo: Create a private ArrayList to hold a single type that can
    // be used to access client and account information.
    // e.g.
    static ArrayList<Client> clientData;
    private static ArrayList<BusinessClient> BusinessClients;
    private static ArrayList <PersonalClient> PersonalClients;
    // change YOUR_CLASS to reflect the actual class whose instances
    // will be in the clientData ArrayList;
	fileread f= new fileread();
	 int Index;
	 private void createObjects() throws IOException {
		accountData= fileread.Read("bis.txt", ",");
        String[] accountInfo, ai;
        PersonalClients = new ArrayList<PersonalClient>();
        BusinessClients= new ArrayList<BusinessClient>();
        clientData = new ArrayList<Client>();
        PersonalClient c;
		BusinessClient b;
        ArrayList<String> clientIdList = new ArrayList<String>();
        String clid;
		ArrayList<String> AL= new ArrayList<String>();
		String [] bas= {"HWA12","DIG01","WUU88","SHA47","KPK24"}; 
		AL.addAll(Arrays.asList(bas));
        int clientIndex;
        for (int i=0; i<accountData.size(); i++ ) {
            // ai = accountData.get(i);
            ai = accountData.get(i);
            // columns: 0-id, 1-name, 2-accType, 3-balance, 4-address, 5-parish, 6-phone
            clid = ai[0];
            clientIndex = clientIdList.indexOf(clid); 
            if (!AL.contains(ai[0])){
              //  c = clientData.get(clientIndex);
               // System.out.println("Found " + clid);
               // Address addr = new Address(ai[4], ai[5]);
		   c = new PersonalClient(ai[0], ai[1]+ " "+ai[2],ai[5], ai[7],ai[8],ai[2],ai[9],ai[10],ai[11],ai[12],ai[13],ai[14]);
			  c.addAccount(ai[3], Double.parseDouble(ai[4]));
                PersonalClients.add(c);
           } else {
                //clientIndex = clientIdList.size();
                //clientIdList.add(clid);
                b= new BusinessClient(ai[0], ai[1]+ " "+ ai[2], ai[5], ai[7],ai[8],ai[2],ai[9],ai[10],ai[11],ai[12],ai[13]);
				b.addAccount(ai[3], Double.parseDouble(ai[4]));
                BusinessClients.add(b);
            }
            
        }
    }

    public double totalFunds(){

        double mgmtTotal = 0;
        // ToDo:
        // complete this method that will loop through clientData to 
        // extract the balance for accounts contained within to 
        // general a total that is then returned.
        for (Client k: PersonalClients){
            ArrayList<Account> accs = k.getAccounts();
            for (int i = 0; i < accs.size(); i++){
                mgmtTotal += accs.get(i).currentBalance();
            }
        }
        for (Client k: BusinessClients){
            ArrayList<Account> accs = k.getAccounts();
            for (int i = 0; i < accs.size(); i++){
                mgmtTotal += accs.get(i).currentBalance();
            }
        }
        return mgmtTotal;
    }
    
	// check the id business clients to see if its valid using the business list
	public boolean CheckIdBusiness(String ID) {
		
		boolean test= false;
		for(int b=0; b<BusinessClients.size(); b++) {
			String Id= BusinessClients.get(b).getCardNum();
			String ID1= BusinessClients.get(b).getpassword();
			//System.out.println(Id);
			//System.out.println(ID1);
			if (ID.equalsIgnoreCase(Id)) {
				test= true;
				break;
			} else {
				test= false;
			}
		}
		return test;
	}
	
	
	
	public String CheckpinBusiness(String ID) {
		
		String test="";
		for(int b=0; b<BusinessClients.size(); b++) {
			String Id= BusinessClients.get(b).getCardNum();
			//String ID1= BusinessClients.get(b).getCardNum();
			//System.out.println(Id);
			//System.out.println(ID1);
			if (ID.equalsIgnoreCase(Id)) {
				test= BusinessClients.get(b).getpassword();
				return test;	
			}
		}
		System.out.println(test);
		return test;
	}
	
	
	
	
	
	public String CheckpinPersonal(String ID) {
		
		String test="";
		for(int b=0; b<PersonalClients.size(); b++) {
			String Id= PersonalClients.get(b).getCardNum();
			//String ID1= BusinessClients.get(b).getCardNum();
			//System.out.println(Id);
			//System.out.println(ID1);
			if (ID.equalsIgnoreCase(Id)) {
				test= PersonalClients.get(b).getpassword();
				return test;	
			}
		}
		return test;
	}
	
	public String password(String cardnum) {
		//String c= "4455668800113355";
		String p = "2134";
		String p1 ="2233";
	
		if (cardnum.equalsIgnoreCase("4455668800113355")) {
			p="1234";
			return p;
		}else if (cardnum.equalsIgnoreCase("1122334477889966")) {
			p="2233";
			return p;
		}else if (cardnum.equalsIgnoreCase("9098800888234567")) {
			p="5555";
			return p;
		}else if (cardnum.equalsIgnoreCase("8888777713456500")){
			p="9090";
			return p;
		}else if (cardnum.equalsIgnoreCase("3310124476543276")){
			p="9123";
			return p;
		}else if (cardnum.equalsIgnoreCase("1001300045008348")){
			p="8118";
			return p;
		}else if (cardnum.equalsIgnoreCase("1221399945118365")){
			p="8908";
			return p;
		}else if (cardnum.equalsIgnoreCase("3333000013490524")){
			p="4356";
			return p;
		}else if (cardnum.equalsIgnoreCase("5555000013006500")){
			p="8245";
			return p;
		}else if (cardnum.equalsIgnoreCase("8800907713456588")){
			p="1113";
			return p;
		}else if (cardnum.equalsIgnoreCase("1190877665522314")) {
			p="2134";
			return p;
		}else if (cardnum.equalsIgnoreCase("5943876474676418")) {
			p="2138";
			return p;
		}else if (cardnum.equalsIgnoreCase("8102983745601834")) {
			p="8980";
			return p;
		}
		return p;
	}
	
	
	public double balance(String card,String pass) {
		Account a = Baccountcheck(card);
		Account p = Paccountcheck(card);
		double x = 0;
		
		if(CheckIdPersonal(card) && password(card).equalsIgnoreCase(pass)) {
			Account bal;
			
			for(int b=0; b<PersonalClients.size(); b++) {
				Account bal1 = PersonalClients.get(b).getAccount(b);
				x = p.currentBalance();
				return x;
			}
		}else if (CheckIdBusiness(card) && password(card).equalsIgnoreCase(pass)) {
			Account bal;
			
			for(int b=0; b<BusinessClients.size(); b++) {
				Account bal1 = BusinessClients.get(b).getAccount(b);
				x = a.currentBalance();
				return x;
			}
		}
		
		return x ;
	}
	
	
	
	// check the id of personal clients  using the personal client arraylist
public boolean CheckIdPersonal(String ID) {
		
		boolean test= false;
		for(int b=0; b<PersonalClients.size(); b++) {
			String Id= PersonalClients.get(b).getCardNum();
			//System.out.println(Id);
		//	String ID1= PersonalClients.get(b).getpassword();
		
		//	System.out.println(ID1);
			if (ID.equalsIgnoreCase(Id)) {
				
				test= true;
				break;
			} else {
				test= false;
			}
		}
		return test;
	}
	
	
	
private boolean CheckIdBusiness(String ID,String pass) {
	
	boolean test= false;
	for(int b=0; b<BusinessClients.size(); b++) {
		String Id= BusinessClients.get(b).getCardNum();
	//	System.out.println(Id);
		String ID1= BusinessClients.get(b).getpassword();
	
		//System.out.println(ID1);
		if (ID.equalsIgnoreCase(Id)) {
			if (ID1.equalsIgnoreCase(pass)) {
				test=true;
				break;
			} else {test=false;
			break;}
			//test= true;
			//break;
		} else {
			test= false;
		}
	}
	System.out.println(test);
	return test;
}
	


    private void initialize(){
        // This method just adds some test data to the accountData arraylist
        // You will write code in the method: createObjects to loop through
        // the array initialized here to create instances of your classes
        // You probably shouldn't modify this method - unless:
        // you're adding some new sample data

        // elements in the array  :Client ID, surname, firstname, Acc type, balance, address, Parish, phone num
       // accountData.add(new String[]{"JBX09", "Bond", "James", "savings", "15984789.74", "Main St., Oracabessa", "St. Mary", "1-876-987-5583"});
      //  accountData.add(new String[]{"SHW34", "Holmes", "Sherlock", "investment", "6489546.0", "Brigade St. Santa Cruz", "St. Elizabeth", "1-876-759-4441"});
      //  accountData.add(new String[]{"THW03", "Hardy", "Thomas", "investment", "6548.40", "Brigade St. Santa Cruz", "St. Elizabeth", "1-876-345-9703"});
      //  accountData.add(new String[]{"NDW58", "Drew", "Nancy", "investment", "48827.50", "12 High St., Black River", "St. Elizabeth", "1-876-859-8089"});
      //  accountData.add(new String[]{"JJX12", "Jones", "Jessica", "direct banking", "85169.08", "15 Old Hope Road, Kgn 5", "KSA", "1-876-893-5197"});
     //   accountData.add(new String[]{"JBC85", "Bourne", "Jason", "direct banking", "416.0", "9 Fearon Ave, May Pen", "Clarendon", "1-876-424-4743"});
     //   accountData.add(new String[]{"HDW05", "Dent", "Harvey", "savings", "4658416.0", "144 Barnett St., Montego Bay", "St. James", "1-876-484-6108"});
     //   accountData.add(new String[]{"PCW44", "Coulson", "Phil", "savings", "7436546.0", "Propsper Rd., Lucea", "Hanover", "1-876-598-2378"});

        // Array Items listed below are business clients with chequing and investment accounts
        // elements in the array  :ClientID, Common Name, Full Name, account type, balance, address, parish, phone numbers
      //  accountData.add(new String[]{"HWA12", "Huwawei Jamaica", "Shenzen Telecoms Caribbean Ltd.", "chequing", "145689214.35", "14 Constant Sprint Road, Kgn 10", "Kingston and St. Andrew", "1-876-633-1859, 1-876-631-5587"});
      //  accountData.add(new String[]{"DIG01", "Digicel", "Mossel Jamaica Ltd.", "investment", "3245455249.75", "15 Ocean Boulevard, Kingston", "Kingston and St. Andrew", "1-876-633-1000, 1-876-631-5000"});
       // accountData.add(new String[]{"WUU88", "Western Photo Ltd.", "Western Photo Ltd.", "chequing", "2586492.09", "8 Main Street, Savannah-la-mar", "Westmoreland", "1-876-945-6688", "1-876-945-6689"});
      //  accountData.add(new String[]{"SHA47", "Sharkie\'s Seafood Restaurant", "Sharkie\'s Seafood Restaurant", "chequing", "14340048.93", "Howard Cook Boulevard, Montego Bay", "St. James", "1-876-954-8469"});
       // accountData.add(new String[]{"KPK24", "Sassy Super Salon", "Emily Ramson t/a Sassy Super Salon", "chequing", "486975.00", "Chudleigh District, Christiana", "Manchester", "1-876-355-3534"});
    }

    // this method prints out both sets of clients list
    public void data() {	
		System.out.println("\n\nClients\n*********************\n");
        for (PersonalClient q: PersonalClients){
            System.out.println(q);
            System.out.println("-----------------------------------------------");
        }
        System.out.println("\n\n\n Business Clients\n");
        for (BusinessClient q: BusinessClients){
            System.out.println(q);
            System.out.println("-----------------------------------------------");
        }
		}
    
    // This method uses the account class as a type. This method basically looks for account of a business client when the client id is entered
 private Account  Baccountcheck(String data)  {
	 Account bdata= new Account();
	 for (int b=0; b<BusinessClients.size(); b++) {
		 String id= BusinessClients.get(b).getCardNum();
		 if (data.equalsIgnoreCase(id)) {
			 bdata= BusinessClients.get(b).getAccount(0);
			 
		 }
	 }
	 return bdata;
 }
 
 
 // enter the personal client id and it will return the corresponding account for that client
 private Account  Paccountcheck(String data)  {
	 Account pdata= new Account();
	 for (int b=0; b<PersonalClients.size(); b++) {
		 String id= PersonalClients.get(b).getCardNum();
		 if (data.equalsIgnoreCase(id)) {
			 pdata= PersonalClients.get(b).getAccount(0);
		 }
	 }
	 return pdata;
 }
 
 
 
 
 private Account  Paccountcheck_using_Account_number(String data)  {
	 Account pdata= new Account();
	 for (int b=0; b<PersonalClients.size(); b++) {
		 String id= PersonalClients.get(b).getAccountNumber();
		 if (data.equalsIgnoreCase(id)) {
			 pdata= PersonalClients.get(b).getAccount(0);
		 }
	 }
	 return pdata;
 }
 
 
 
 private Account  Baccountcheck_using_Account_number(String data)  {
	 Account pdata= new Account();
	 for (int b=0; b<BusinessClients.size(); b++) {
		 String id= BusinessClients.get(b).getAccountNumber();
		 if (data.equalsIgnoreCase(id)) {
			 pdata= BusinessClients.get(b).getAccount(0);
		 }
	 }
	 return pdata;
 }
 
 
 
 
 
 
 private int Pcheck(String data)  {
	// Account pdata= new Account();
	 int b;
	 for (b=0; b<PersonalClients.size(); b++) {
		 String id= PersonalClients.get(b).getCardNum();
		 if (data.equalsIgnoreCase(id)) {
			 return b;
		 }
	 }
	 return b;
 }
 
 
 private int bcheck(String data)  {
		// Account pdata= new Account();
		 int b;
		 for (b=0; b<BusinessClients.size(); b++) {
			 String id= BusinessClients.get(b).getCardNum();
			 if (data.equalsIgnoreCase(id)) {
				 return b;
			 }
		 }
		 return b;
	 }
	 
 
 
 
 
 
 private int Bcheck(String data)  {
		// Account pdata= new Account();
		 int b;
		 for (b=0; b<BusinessClients.size(); b++) {
			 String id= BusinessClients.get(b).getCardNum();
			 if (data.equalsIgnoreCase(id)) {
				 return b;
			 }
		 }
		 return b;
	 }
 
 
 
 
 
 private boolean CheckAccountPersonal(String ID) {
		
		boolean test= false;
		for(int b=0; b<PersonalClients.size(); b++) {
			String Id= PersonalClients.get(b).getAccountNumber();
			if (ID.equalsIgnoreCase(Id)) {
				
				test= true;
				break;
			} else {
				test= false;
			}
		}
		return test;
	}
 
 
  
 
private boolean CheckAccountBusiness(String ID) {
		
		boolean test= false;
		for(int b=0; b<BusinessClients.size(); b++) {
			String Id= BusinessClients.get(b).getAccountNumber();
			if (ID.equalsIgnoreCase(Id)) {
				
				test= true;
				break;
			} else {
				test= false;
			}
		}
		return test;
	}
	
	public void finalDeposit1 (String idin,String idin1, String amt1){
		Scanner garf= new Scanner(System.in);
	
		double amt=0;
		System.out.println("1- deposit here 2-deposit in another account");
		int dpt= Integer.parseInt(garf.nextLine());
		try{
			if (CheckIdPersonal(idin) && password(idin).equalsIgnoreCase(idin1)  )       // Check if client id is personal						
			{
				Account p = Paccountcheck(idin);			// account instantiated by this method

				//System.out.println("\n Enter the amount \n");
				amt= Double.parseDouble(amt1);
				p.deposit(amt);
				double marv= p.currentBalance();
				System.out.println("\n The balance is "+ marv);
			 
				String st=PersonalClients.get(Pcheck(idin)).combinenames()+" The current balance:  "+ marv+ " The amount deposited:  "+amt+" TRN: "+ PersonalClients.get(Pcheck(idin)).gettrn()+" Account Number: "+ PersonalClients.get(Pcheck(idin)).getAccountNumber()	 ;
				logData.add(st);
				fileread.Write("log.txt", logData, ",");	
				// fileread.Writelist("C:\\Users\\BASTIC\\Desktop\\New folder\\lab5\\src\\lab5pkg\\data.txt", accountData, ",");
			
			} else if (CheckIdBusiness(idin) && password(idin).equalsIgnoreCase(idin1)) // check if client is a business client . This check with data in the arraylist 
			{
				Account b= Baccountcheck(idin);	//  create a instance of the account on which deposit or withdraw will take place
	
				//System.out.println("\n Enter the amount \n");
				amt= Double.parseDouble(amt1);
				b.deposit(amt);
				double marv= b.currentBalance(); 
				System.out.println("\n The balance is "+ marv);
				
				String st=BusinessClients.get(bcheck(idin)).getFullname()+" The current balance:  "+ marv+ " The amount deposited:  "+amt+" TRN: "+ BusinessClients.get(bcheck(idin)).gettrn()+" Account Number: "+ BusinessClients.get(bcheck(idin)).getAccountNumber()	 ;
				logData.add(st);
				fileread.Write("log.txt", logData, ",");	
			} else if (idin.equalsIgnoreCase("444555") && idin1.equalsIgnoreCase("4321")) {
				//System.exit(1);
				System.out.println("The program will shut down shortly");
				System.exit(0);
			}
		}catch(IOException e){
			System.out.println("IOException thrown");
		}
	}
	
	public void finalDeposit2(String idin, String idin1, String amt1, String acc){
			System.out.println("Please enter account number of the desired account");
			double amt=0;
			//acc= garf.nextLine();
			Account pa= Paccountcheck_using_Account_number(acc);
			Account ba= Baccountcheck_using_Account_number(acc);
			try{
				if(CheckAccountPersonal(acc)) {
			//		System.out.println("\n Enter the amount \n");
					amt= Double.parseDouble(amt1);
					pa.deposit(amt);
					double marv= pa.currentBalance();
					System.out.println("\n The balance is "+ marv);
					System.out.println("\n The deposit was succesful");
					String st=BusinessClients.get(Pcheck(idin)).getFullname()+" The current balance:  "+ marv+ " The amount deposited:  "+amt+" TRN: "+ BusinessClients.get(Pcheck(idin)).gettrn()+" Account Number: "+ BusinessClients.get(Pcheck(idin)).getAccountNumber()	 ;
					logData.add(st);
					fileread.Write("log.txt", logData, ",");	
				} else if (CheckAccountBusiness(acc)) {
		
					//System.out.println("\n Enter the amount \n");
					amt= Double.parseDouble(amt1);
					ba.deposit(amt);
					double marv= ba.currentBalance();
					System.out.println("\n The balance is "+ marv);
					System.out.println("\n The deposit was succesful");
			
					String st=BusinessClients.get(bcheck(idin)).getFullname()+" The current balance:  "+ marv+ " The amount deposited:  "+amt+" TRN: "+ BusinessClients.get(bcheck(idin)).gettrn()+" Account Number: "+ BusinessClients.get(bcheck(idin)).getAccountNumber()	 ;
					logData.add(st);
					fileread.Write("log.txt", logData, ",");	
				}
			}catch(IOException e){
				//Do Nothing
			}
	}





public void finalwithdraw (String idin,String idin1){
	Scanner garf= new Scanner(System.in);
	double amt=0;
	try{
	if (CheckIdPersonal(idin) && password(idin).equalsIgnoreCase(idin1)  )       // Check if client id is personal						
	{
		Account p= Paccountcheck(idin);			// account instantiated by this method

	
        System.out.println("\n Enter the amount \n");
		amt= Double.parseDouble(garf.nextLine());
		p.withdraw(amt);
		double marv= p.currentBalance();
		System.out.println("\n The balance is "+ marv);
			 
		String st=PersonalClients.get(Pcheck(idin)).combinenames()+" The current balance:  "+ marv+ " The amount withdraw:  "+amt+" TRN: "+ PersonalClients.get(Pcheck(idin)).gettrn()+" Account Number: "+ PersonalClients.get(Pcheck(idin)).getAccountNumber()	 ;
		logData.add(st);
		fileread.Write("log.txt", logData, ",");	
				
    } else if (CheckIdBusiness(idin) && password(idin).equalsIgnoreCase(idin1)) // check if client is a business client . This check with data in the arraylist 
		{
			Account b = Baccountcheck(idin);	//  create a instance of the account on which deposit or withdraw will take place
	
		
                System.out.println("\n Enter the amount \n");
			 amt= Double.parseDouble(garf.nextLine());
				b.withdraw(amt);
				double marv= b.currentBalance();
				System.out.println("\n The balance is "+ marv);
				
			 String st=BusinessClients.get(bcheck(idin)).getFullname()+" The current balance:  "+ marv+ " The amount withdrawn:  "+amt+" TRN: "+ BusinessClients.get(bcheck(idin)).gettrn()+" Account Number: "+ BusinessClients.get(bcheck(idin)).getAccountNumber()	 ;
				logData.add(st);
			 fileread.Write("log.txt", logData, ",");	
				
        
		} else if (idin.equalsIgnoreCase("444555") && idin1.equalsIgnoreCase("4321")) {
			//System.exit(1);
			System.out.println("The program will shut down shortly");
		System.exit(0);
		}
		
				}catch(IOException e){
				//Do Nothing
			}
}
 
 // error message method for invalid client
 private void errorclient() {
	 System.out.println("Errror!!!! no client exist of this particular entry");
 }
// message that reminds the user to deposit or withdraw
 private void depwt() {
	 System.out.println("Please enter correct option for withdraw or deposit");
 }

    
    public Lab5Main(){
        // instantiate accountData, the arraylist with string arrays
        
      //  initialize();
		try{
			createObjects();
		}catch (IOException e){
			//Do Nothing
		}
		
    }
	Lab5Main m;

   public static void main(String[] args) {
        Lab5Main m = new Lab5Main();
        double fundsUnderManagement = m.totalFunds();
        System.out.printf("The total sum under management is %,.2f",
                          fundsUnderManagement);
        // ToDo: print out some of the values in clientData
        // no more than 6 entries.
		m.data();// print out the business client list and personal client list
		String idin;
		String idin1;
		String idin2;
        
		Scanner garf= new Scanner(System.in);
		boolean flow= true;
		while(flow) {
			System.out.println("Please enter a valid card number to be checked and process");
			idin = garf.nextLine();		// This accepts the business or personal client id to be check. if true their account will be instantiated
			System.out.println("Please enter a valid pin to be checked and process");
			idin1= garf.nextLine();
			//System.out.println("Please enter the amount");
			//idin2= garf.nextLine();
		//double yes= m.Businessbalance(idin,idin1);
		//	System.out.println(yes);	
			//System.out.println("\nPlease select option D for deposit W for withdraw\n");
				//String ans= garf.nextLine();
			
			
				m.finalwithdraw(idin, idin1);
			
			

		flow= true;	
		}	
    }	
}
