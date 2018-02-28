package ensyuu12;

//銀行口座のためのクラス
class En12_2_BankAccount {
	private String accountName;                                        //口座名義のためのフィールド変数
	private int accountNumber;                                         //口座番号のためのフィールド変数
	private long accountBalance;                                       //預金残高のためのフィールド変数
	private En12_1_Day accountOpenedDate;                              //口座開設日のためのフィールド変数


	//銀行口座クラスのためのコンストラクター
	En12_2_BankAccount(String accountName, int accountNumber, long accountBalance, En12_1_Day accountOpenedDate) {
		this.accountName = accountName;									//口座名義のフィールドに仮引数の値を代入するための代入式
		this.accountNumber = accountNumber;								//口座番号のフィールドに仮引数の値を代入するための代入式
		this.accountBalance = accountBalance;							//預金残高のフィールドに仮引数の値を代入するための代入式
		this.accountOpenedDate = new En12_1_Day(accountOpenedDate);		//口座開設日のフィールドに仮引数の値を代入するための代入式
	}

	//口座名義を取得するためのゲッターメソッド
	public String getAccountName() {
		//呼び出し元に取得した口座名義の値を返却するreturn文
		return accountName;
	}

	//口座番号を取得するためのゲッターメソッド
	public int getAccountNumber() {
		//呼び出し元に取得した口座番号の値を返却するreturn文
		return accountNumber;
	}

	//預金残高を取得するためのゲッターメソッド
	public long getAccountBalance() {
		//呼び出し元に取得した預金残高の値を返却するreturn文
		return accountBalance;
	}

	//口座開設日を取得するためのゲッターメソッド
	public En12_1_Day getAccountOpenedDate(){
		//呼び出し元に口座開設日の値への参照を返却するreturn文
		return accountOpenedDate;
	}

	//預金時の計算をするためのメソッド
	void deposit(long amountOfDeposit){
		//口座の預金残高に預金する金額を加算し代入する演算式
		accountBalance += amountOfDeposit;
	}

	//預金から引き出し時の計算をするためのメソッド
	void withdraw(long amountOfWithdraw){
		//口座の残高から引き出す金額を減算し代入する演算式
		accountBalance -= amountOfWithdraw;
	}


	//口座情報を文字列表現として返却するためのメソッド
	public String toString(){
		//呼び出し元に値を文字列表現として返却するためのreturn文
		return String.format("\n%sさんの口座\n　■口座名義：%s\n　■口座番号：%6d\n　■預金残高：%d円\n",
									getAccountName(), getAccountName(), getAccountNumber(),
									getAccountBalance());
	}

    //普通預金と定期預金の合計額を比較した結果を返却するためのメソッド
    public static int compBalance(En12_2_TimeDepoAccount userAccountFirst, En12_2_TimeDepoAccount userAccountSecond) {
        int compareResult;                        //比較した結果を保持するための変数
        int sumBalanceFirstResult = 0;           //一人目の合計残高のための変数
        int sumBalanceSecondResult = 0;          //二人目の合計残高のための変数

        //一人目の合計残高を計算し比較するための変数に代入する
        sumBalanceFirstResult = (int) (userAccountFirst.getAccountBalance() + userAccountFirst.getmTimeBalance());
        //一人目の残高の合計を表示するための出力
        System.out.printf("\n%sさんの残高合計：%d円\ns",userAccountFirst.getAccountName(), sumBalanceFirstResult);

        //二人目の合計残高を計算し比較するための変数に代入する
        sumBalanceSecondResult = (int) (userAccountSecond.getAccountBalance() + userAccountSecond.getmTimeBalance());
        //二人目の残高の合計を表示するための出力
        System.out.printf( "%sさんの残高合計：%d円", userAccountSecond.getAccountName(), sumBalanceSecondResult);

        //二人の全残高の比較の結果を判定するための条件分岐
        //一人目の残高が多い場合に実行する処理
        if(sumBalanceFirstResult >sumBalanceSecondResult){
            //一人目の残高が大きいという判定の数値を返却用変数に代入する
            compareResult = 1;
        //二人目の残高が多い場合に実行する処理
        }else if(sumBalanceFirstResult <sumBalanceSecondResult){
            //二人目の残高が大きいという判定の数値を返却用メソッドに代入する
            compareResult = -1;

        //どちらの残高も等しい場合に実行する処理
        }else{
            //等しいという判定の数値を返却用メソッドに代入する
            compareResult = 0;
        }

        //比較結果を呼び出し元に返却する
        return compareResult;

    }



}
