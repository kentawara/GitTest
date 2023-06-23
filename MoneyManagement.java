package Vending;

import java.util.Scanner;
//金銭管理クラス
public class MoneyManagement implements Account{
	String name;
	String money_str;
	static String goods_name;

	int[] array = new int[200]; //入力バッファ配列
	
	int num;//整数型用変数
	int hasNext_count=0;//入力個数カウント
	int i=0;
	
	static int sales_check_flag = 0;

	static int tmp_stock;
	
	Scanner sc;//keybordスキャナーインスタンス宣言
	Scanner scan = null;//stringスキャナーインスタンス宣言
	
	public int  put_money = 0;//投入金額
	public int refund;//返金
	public int sum = 0;//投入金額合計
	
	int earning;
	int count_bill = 0;  //カウント変数
	int count_coin_500 = 0;//カウント変数
	int count_coin_100 = 0;//カウント変数
	int count_coin_50 = 0;//カウント変数
	int count_coin_10 = 0;//カウント変数
	int tmp_sum = 0;  //計算用バッファ変数
	int coinCheck_flag = 0;  //コインチェックフラグ
	
	boolean coinflag = false;//入力金額が正しいかの判定
	boolean refundflag = false;
	boolean sumflag = false;
	
	MoneyManagement(){
		this.name ="";
		this.num=0;//整数型用変数
		this.hasNext_count=0;//入力個数カウント
		this.i=0;//array配列入力用添え字
		//InputMoney();//投入金額合計sumを返す
	}
	
	//金銭入力
	public void InputMoney(){
		
		Maintenance mt = new Maintenance();
		sc = new Scanner(System.in);//keybord入力
		
		while(true){
			try{
				while(true) {
					System.out.println("記入例(商品,～円,～円,...)>");
					System.out.print("商品を指定して、お金を投入してください >");
					
					String str = sc.nextLine();//全行を文字列に格納
	
					if("q".equals(str)){
						break;
					}
	
					if("rb".equals(str)){
						Lever();
						continue;
					}
					
					if("mtnc".equals(str)) {
						System.out.println("intoMaintenance");
						while(true) {
							System.out.print("maintenance->");
							str = sc.nextLine();
							mt.mtnc(str);
							System.out.println();
							if("qm".equals(str)) {
								break;
							}
						}
						
					}
					
					scan = new Scanner(str).useDelimiter(",|\n");//区切り文字指定
					
					while (scan.hasNext()){
						//区切り文字の確認
						if(hasNext_count < 1) {
							name = scan.next();//区切り文字ごとに格納
							goods_name = name;
							if(Sale_sys.goods_select(goods_name)) {
								sales_check_flag = 1;
							}else {
								System.out.println(goods_name+"商品はありません");
							}
						}else{
							money_str = scan.next();
							coin_bill_check(money_str);
						}
						hasNext_count++;//入力文字カウント（カンマ区切り） 
					}
					
					if(!("rb".equals(str)) && limitCheck()) {
						hold_money();
					}
					
					if(sales_check_flag == 1) {
						sum = Sale_sys.purchase(sum,Sale_sys.goods_index(goods_name),goods_name);
						sales_check_flag = 0;
					}
					
					buffer_index_clear();
				}
				break;
			
			}catch (Exception e){
				System.out.println("入力の形式:(name,money,money,...)");
				i=0;//リセット
				sum=0;//リセット
				hasNext_count=0;//リセット
			}
		}
		scan.close();
		sc.close();
	}
	
	//返却レバーメソッド
	public void Lever()
	{
		System.out.println("返金します");
		System.out.println("返金額:"+sum);
		tmp_sum =sum;
		while(tmp_sum/1000 > 0) {
			tmp_sum = tmp_sum-1000;
			count_bill++;
		}
		while(tmp_sum/500 > 0) {
			tmp_sum = tmp_sum-500;
			count_coin_500++;
		}
		while(tmp_sum/100 > 0) {
			tmp_sum = tmp_sum-100;
			count_coin_100++;
		}
		while(tmp_sum/50 > 0) {
			tmp_sum = tmp_sum-50;
			count_coin_50++;
		}
		while(tmp_sum/10 > 0) {
			tmp_sum = tmp_sum-10;
			count_coin_10++;
		}
		System.out.println("おつり:"+"1000円:"+count_bill+"枚  "+"500円:"+count_coin_500+"枚  "
				+"100円:"+count_coin_100+"枚  "+"50円:"+count_coin_50+"枚  "+"10円:"+count_coin_10+"枚  ");
		count_coin_500 = 0;
		count_coin_100 = 0;
		count_coin_50 = 0;
		count_coin_10 = 0;
		count_bill = 0;
		sum = 0;
	}
	
	//合計が1990円以上なら
	public boolean limitCheck(){
		int reimburse = 0;
		int tmp = 0;
		
		for(int i=0;i< this.array.length;i++) {
			tmp = tmp + this.array[i];//バッファ変数から投入金額
        }
		
		if(tmp>1990){
			reimburse = tmp;
			System.out.println("返金します");
			System.out.println("返金額:"+reimburse+"円");
			System.out.println("投入金額合計は1990円以下にしてください");
			return false;
		}else{
			return true;
		}
	}
	
	public void coin_bill_check(String money_str){
		money_str = money_str.replace(" ", "");//文字列から空白を削除
		money_str = money_str.replace(",", "");//文字列からカンマを削除
	    
	    for(int i=0;i<coin.length;i++) {
	    	//数値を配列に格納
	    	//System.out.println("check");
			if(money_str.equals(coin[i])){
				coinCheck_flag = 1;
			}
		}
		if(coinCheck_flag == 1){
			num = Integer.parseInt(money_str);//文字列を数値に変換
			array[i] = num;
			i++;
			coinCheck_flag = 0;
		}
		//coincheckが0なら
		else{
			System.out.println("有効な金銭を入力してください");
		}
		
	}
	
	public void hold_money() {
		
		for(int i=0;i< this.array.length;i++) 
		{
        	sum = sum + this.array[i];//バッファ変数から投入金額
        }
		System.out.println("販売機内金額:"+sum+"円");
	}
	
	public void buffer_index_clear() {
		for(int i=0;i<200;i++) 
		{
			this.array[i] = 0;
		}
		i=0;
		hasNext_count=0;//入力個数カウントリセット
	}
	
	public static String getGoodsName() {
		return goods_name;
	}

}
