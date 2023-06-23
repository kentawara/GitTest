package Vending;

public class Stock implements Account{

		public static boolean stock(int index) {

			if(stock[index] == 0) {
				System.out.println("売り切れ");
				return false;
			}else {
				System.out.println("在庫->"+beverage[index]+":"+stock[index]);
				return true;
			}
		
		}
}
