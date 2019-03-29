package bank;

import java.util.ArrayList;

public abstract class Client {

   
	protected String trn;
    protected ArrayList<Address> addresses;
    protected ArrayList<Account> accounts;
   protected ArrayList<String> telephoneslist = new ArrayList<String>();
	
	protected String clientid, name,accountnumber,signatory,cardnumber,mainpassword;

	
	    public Client(String clid, String name_, String address_, String parish_,
                  String tel_,String Signatory, String trn, String account_number,String cardnum,String password){
        accounts = new ArrayList<Account>();
        addresses = new ArrayList<Address>();
        // Parish pa = Parish.KingstonStAndrew;  // default parish
        Parish pa = Parish.findByName(parish_);
		
        addresses.add(new Address(address_, pa));
        telephoneslist.add(tel_);
        name = name_;
		this.trn= trn;
		this.signatory= Signatory; 
		this.accountnumber= account_number;
        clientid = clid;
        cardnumber=cardnum;
        mainpassword=password;
    }
	
	
	
	public String gettrn() {
		return this.trn;
	}	
	
	
	
	public String getCardNum() {
		return this.cardnumber;
	}	
	
	
	public String getpassword() {
		return this.mainpassword;
	}	
	
	
	public String getAccountNumber() {
		return this.accountnumber;
	}
	 public String getSignatory() {
		 return this.signatory;
	 }
	  
	 public ArrayList<String> getTelenumber(){
		 return this.telephoneslist;
	 } 
	 public void addTelephonenumber(String tele) {
		 telephoneslist.add(tele);
	 }
    
	public abstract String getFullname();
	
	public abstract String getName();
	
	
    public void addAccount(Account account){
        accounts.add(account);
    }
    public void addAccount(String type, double balance){
        type = String.join("", type.split(" "));
        AccountType act = AccountType.valueOf(type);
        addAccount(new Account(act, balance));
    }
    public void addAddress(Address addr_){
        addresses.add(addr_);
    }

    public Account getAccount(int seq){
        if (seq < accounts.size())
            return accounts.get(seq);
        else
            return null;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }

    public Parish getPrimaryParish(){
        Address p;
        try{
            p = this.addresses.get(0);
        }
        catch(Exception e){
            p = null;
        }
        return p.getParish();
    }
    
    
    public String getid() {
    	return this.clientid;
    }

    public String toString(){
        String f = "Client: %s (%s)\n  Tel:%s %s%s";
        String aa, ac;
        String telephone_number="";
         for (String t: telephoneslist) {
        	 
        	 telephone_number= t+ "\n";
         }
        
        	
        
        ac = "\n  Accounts:";
        
        
        for (Account a : accounts){
            ac += String.format("\n    %-20s:    $%,12.2f", a.getType(), a.currentBalance());
        }
        aa = "\n  Address:";
        for (Address b: addresses){
            aa += String.format("\n    %s", b.toString());
        }
        return String.format(f, getFullname(), clientid, telephone_number, ac, aa);

    }
}