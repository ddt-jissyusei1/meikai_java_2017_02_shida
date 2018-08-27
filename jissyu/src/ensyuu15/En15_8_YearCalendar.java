package ensyuu15;

import static java.util.Calendar.*;

import java.util.GregorianCalendar;

/**
 * 指定年のカレンダーのためのクラス</br>
 * @author y.Shida
 *
 */
public class En15_8_YearCalendar extends En15_8_AbsCalendar {
    private GregorianCalendar specifiedYearCalendar;

    //年間カレンダーのためのコンストラクタ
    public En15_8_YearCalendar(String year) {
        this.specifiedYearCalendar = new GregorianCalendar(Integer.parseInt(year), 1, 1);
    }

    /**
     * 出力するカレンダーの年の情報を文字列として返却するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @return String 表示するカレンダー情報の文字列
     */
    @Override
    public String toString() {
        //年の値を取得して文字列として呼び出し元に返却する
        return   "コマンドライン引数が年のみのため、年間カレンダーを表示します。\n\n" + specifiedYearCalendar.get(YEAR) + "年";
    }

    /**
     * カレンダーを出力するためのメソッド</br>
     * 作成日：2018/08/22</br>
     * 作成者：志田</br>
     *
     * @param monthMaxDays 月ごとの最大日数を保持する配列
     * @param monthDays 出力処理で使用する月の最大日数を保持する
     * @param startday 出力する月の開始曜日を保持する
     * @param weekLoop 週の繰り返し処理で使用するループカウンタ変数
     * @param weekdayLoop 曜日の繰り返し処理で使用するループカウンタ変数
     */
    @Override
    public void outputCalendar() {
        int specifiedYear = specifiedYearCalendar.get(YEAR);        //指定年の値の取得
        int calendarMonth = specifiedYearCalendar.get(MONTH);       //指定年の初月の値の取得
        int calendarDay = specifiedYearCalendar.get(DATE);          //月の初日の値の取得

        //各月の最大日数のための配列の宣言
        int[] monthMaxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //閏年であった場合、2月の最大日数に1加算するための条件式
        if(specifiedYearCalendar.isLeapYear(specifiedYear)){
            //2月の最大日数の要素に1加算する
            monthMaxDays[1] +=1;
        }

        //月ごとの出力をするための繰り返し処理
        for(int monthLoop = 0; monthLoop < 12;monthLoop++){
            //出力する月の最大日数を変数に保持する
            int monthDays = monthMaxDays[monthLoop];
            //出力する月の開始曜日を取得し変数に保持する
            int startday = specifiedYearCalendar.get(GregorianCalendar.DAY_OF_WEEK);
            //月と曜日情報を表示するための出力
            System.out.println(calendarMonth + "月\n日　月　火　水　木　金　土");

            //週ごとに出力するための繰り返し処理
            for(int weekLoop = 0; calendarDay <= monthDays; weekLoop++){
                //曜日列の出力のための繰り返し処理
                for(int weekdayLoop = 0; weekdayLoop < 7; weekdayLoop++){
                    //月の開始曜日から日にちを出力するための条件式
                    if(weekdayLoop >= startday && weekLoop == 0 || calendarDay > 1 && calendarDay <= monthDays){
                        //日にちを表示するための出力
                        System.out.printf("%02d  ",calendarDay);
                        //次の日の表示のため一日加算
                        calendarDay++;
                    //上記条件以外の場合に実行する処理のための分岐
                    } else {
                        //空白を表示するための出力
                        System.out.print("    ");
                    }
                }
                //次の行に表示するための改行の出力
                System.out.println();
            }
            //次の月と表示を区切るための改行の出力
            System.out.println();
            //次月の情報にするための月の値の加算
            calendarMonth++;
            //month++;
            //次月のカレンダー表示のため日にちの値を1で初期化
            calendarDay = 1;
        }
    }

}
