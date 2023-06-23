package Vending;

public class Auto_Bending implements Account{
	
	public static void main(String[] args) {
		
		AB_Display display = new AB_Display();
		
		MoneyManagement mm = new MoneyManagement();//入力のインスタンス
		
		display.dis_1();
		mm.InputMoney();

		System.out.println("End Bending Machine System.");
		
        
	}

}
