package Vending;

public class Sale_sys implements Account{

	static int earning = 0;    //売上金

	public static void goods_display() {
		System.out.println("商品一覧　1.メロンソーダ　2.アールグレイティー　3.コーラ　4.ほうじ茶　5.ミルクティー　6.グレイプジュース 7.オレンジジュース 8.水");
		System.out.println("値段一覧　1.120円　2.120円　3.130円　4.110円　5.150円　6.160円 7.160円 8.100円");
		System.out.print("商品を選択してください:");
	}
	
	public static boolean goods_select(String str) {

		boolean cflag = false;
		
		for(int i = 0;i < beverage.length;i++) {
			if(str.equals(beverage[i])){
				cflag = true;
			}
		}
		return cflag;
	}
	
	public static int goods_index(String str) {

		int index = 0;
		
		for(int i = 0;i < beverage.length;i++) {
			if(str.equals(beverage[i])){
				index = i;
			}
		}
		return index;
	}
	
	public static int purchase(int sum, int selection, String goods_name) {
		
		if(sum-price[selection]>=0) {
			//残金から購入可能か判断
			if(stock[selection]>0) {
				//在庫があるか確認
				sum = sum-price[selection];
				stock[selection] = stock[selection]-1;
				earning = earning + price[selection];//売上金額に計上
				System.out.println("残金:"+sum);
				System.out.println(goods_name+"在庫："+ stock[selection]);
				System.out.println("売上1:"+earning);
			}
			else {
				System.out.println("商品の在庫がありません");
			}
		}else {
			System.out.println("お金が足りません");
		}
		return sum;
		
	}
}
