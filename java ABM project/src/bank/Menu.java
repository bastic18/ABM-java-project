package bank;

public class Menu{
	private static String accounts = "Select An Account Type\n\n1 - Savings\n2 - Chequing\n3 - Investment\n4 - DirectBanking";
	private static String actions = "Select An Action\n\n1 - Balance Inquiry\n2 - Deposit\n3 - Withdraw";
	private static String investAction = "Select An Action\n\n1 - Balance Inquiry\n2 - Deposit";
	
	public static String getInvest(){
		return investAction;
	}
	
	public static String getDisplay(){
		return accounts;
	}
	
	public static String getActions(){
		return actions;
	}
} 