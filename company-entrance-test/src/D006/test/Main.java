package D006.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {
        int n = 0; //距離
        String s = "";//単位

        //=====入力==============
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("IOエラー。プログラムを終了します。");
            System.exit(-1);
        }

        //入力データ分割
        String tmpStr[] = line.split(" ");
        if (tmpStr.length != 2) {
            System.out.println("不正な入力データ。プログラムを終了します。");
            System.exit(-1);
        }

        //入力チェック
        Pattern linePattern = Pattern.compile("^[0-9]*$");
        Matcher distanceMatch = linePattern.matcher(tmpStr[0]);
        if (!distanceMatch.find()) {
            System.out.println("距離の入力値が不正です。プログラムを終了します。");
            System.exit(-1);
        }

        n = Integer.parseInt(tmpStr[0]);
        if (n < 1 || n > 1000) {
            System.out.println("距離の入力値が不正です。プログラムを終了します。");
            System.exit(-1);
        }
        s = tmpStr[1];

        //=====単位変換==========
        int result = 0;
        switch (s) {
        case "cm":
            result = n * 10;
            break;
        case "m":
            result = n * 10 * 100;
            break;
        case "km":
            result = n * 10 * 100 * 1000;
            break;
        default:
            System.out.println("単位の入力値が不正です。プログラムを終了します。");
            System.exit(-1);
        }

        //結果表示
        System.out.println(result);
    }
}