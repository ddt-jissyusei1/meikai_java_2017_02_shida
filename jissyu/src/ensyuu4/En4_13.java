package ensyuu4;
import java.util.Scanner;

/*
 * 1から入力された値までの和を求めるList4-10(p.112)をfor文で実現せよ
 */

public class En4_13 {
	//積を求めるというプログラム説明文の定数
	private static final String SUM_PROGRAM_MESSAGE = "1から入力された値までの和を求めます。";
	//1からの積を求める整数の入力を促す文の定数
	private static final String INPUT_NUMBER_MESSAGE = "1からの積を求める正の整数値を入力してください:";

	public static void main(String[] args) {
		//キーボードからの読み込みを行うためのプログラム
		Scanner inputStream = new Scanner(System.in);

		//プログラムの内容を説明する文を出力する
		System.out.println(SUM_PROGRAM_MESSAGE);

		int sumEndNumber;						//入力された値を代入するための変数を用意する

		//0以下の値が入力された場合を考慮して、1以上の値が入力されるまで入力を促す文を繰り返し出力する
		do{
			//1からの和を求める整数値の入力を促す文を出力する
			System.out.print(INPUT_NUMBER_MESSAGE);
			//入力された値をsumEndNumberに代入する
			sumEndNumber = inputStream.nextInt();
		//sumEndNumberの値が0以下である間、do文を繰り返す制御式
		}while(sumEndNumber <= 0);
		//値の入力が終了したので開いていたリソースを閉じる
		inputStream.close();

		int sum = 0;					//1からの積の合計値を入れるための変数sumを用意し、0で初期化する
		int count;						//1から入力された値までの和をカウントするための変数を用意する

		/*ここから1から入力された値までの積を求める繰り返し処理
		 * for文の初期化部でcountを0で初期化し、countの値がsumEndNumber以下の間処理を繰り返す
		 * 繰り返し毎に積の処理後にcountの値を1インクリメントする
		 */
		for(count = 0; count <= sumEndNumber; count++){
			//変数sumにcountの値を足して代入する
			sum += count;
		}

		//1から入力された値までの和が入っているsumの値を出力する
		System.out.println("1から入力された値までの和は、" + sum + "です。");

	}

}