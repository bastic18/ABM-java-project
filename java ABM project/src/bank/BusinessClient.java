package bank;

import java.util.*;

public class BusinessClient extends Client {
private String tradingName, officialName,telephone, telephone2;
public ArrayList<PersonalClient> signatories= new ArrayList<PersonalClient>();


public BusinessClient(String clid, String name_, String address_, String parish_,
                  String tel_,String tradingname,String Signatory, String trn, String account_number,String cardnum,String password){
	super (clid,name_,address_,parish_,tel_,Signatory, trn ,account_number,cardnum,password);
	this.tradingName= tradingname; 
	this.officialName=name_;
	//this.telephone=tele;
	//this.telephone2=tele2;
	  
	
	
}


public String getFullname(){
	return this.officialName;
}
	
public String getName(){
	return this.tradingName;
}



 

}