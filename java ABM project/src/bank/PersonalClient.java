package bank;

import java.util.*;

public class PersonalClient extends Client {
private String surname, givenNames,telephone;
private String dob;


public PersonalClient(String clid, String name_, String address_, String parish_,
                  String tel_,String surname, String Signatory, String trn, String account_number,String dob,String cardnum,String password ){
	super (clid,name_,address_,parish_,tel_,Signatory, trn ,account_number,cardnum,password);
	this.surname= surname; 
	this.givenNames=name_;
	//this.telephone=tele; 
	this.dob=dob;
	
	
}
public String combinenames() {
	return givenNames+"  "+surname;
}


public  String getFullname(){
	return this.givenNames;
}
	
public  String getName(){
	return this.surname;
}




}