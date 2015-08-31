package B012.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static final Pattern LINE_PATTERN = Pattern.compile("^[0-9]*$");
	
	public static void main(String args[]) {

		int n = 0; // 行数
		List<String> creditData_sList = new ArrayList<String>();// 処理するクレジットカード番号データリスト

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ====入力処理==========================
		// 行数入力
		try {
			boolean isCorrectRowNum = false;
			while (!isCorrectRowNum) {

				String line = br.readLine();

				// 入力行数を文字列から数字へ変換
				if (LINE_PATTERN.matcher(line).find()) {
					n = Integer.parseInt(line);
				} else {
					System.out.println("行数が不正な入力値、再入力して下さい");
					continue;
				}

				// 入力数チェック
				if (n < 1 || n > 100) {
					System.out.println("不正な入力数、再入力して下さい。");
					continue;
				}
				isCorrectRowNum = true;
			}
		} catch (IOException e) {
			System.out.println("IOエラー、プログラムを終了します。");
			System.exit(-1);
		}

		// カード番号入力
		try {
			int dataCount = 0;
			while (dataCount < n) {
				String line = br.readLine();

				// 文字数チェック
				if (line.length() != 16) {
					System.out.println("16文字ではないデータが含まれています。再入力して下さい。");
					continue;
				}

				// 文字を数字とXの部分に分割
				String numData_s = line.substring(0, 15);
				String xData_s = line.substring(15);

				// 文字チェック
				Pattern NumDataPattern = Pattern.compile("^[0-9]*$");
				Matcher NumDataMatch = NumDataPattern.matcher(numData_s);
				if (!NumDataMatch.find()) {
					System.out
							.println("カード情報の15文字目までに数字でないものが含まれています。再入力して下さい");
					continue;
				}
				if (!xData_s.equals("X")) {
					System.out.println("カード情報の末尾がXではありません。再入力して下さい。");
					continue;
				}

				creditData_sList.add(numData_s + "0"); // Xの代わりに結果に影響のない0を入れておく
				dataCount++;
			}
		} catch (IOException e) {
			System.out.println("IOエラー");
		}

		// ====入力された各Xを求める=======================
		for (String checkingData : creditData_sList) {

			int even = 0;// 偶数桁の総和
			int odd = 0; // 奇数桁の総和

			// 各桁の処理
			for (int i = 1; i <= 16; i++) {

				// 処理する桁を読み込む
				int tmpDigitNum = Integer.parseInt(String.valueOf(checkingData
						.charAt(16 - i)));

				// 偶数・奇数別処理
				if (i % 2 == 0) {
					tmpDigitNum = tmpDigitNum * 2;
					if (tmpDigitNum >= 10) {// 2桁になった場合
						int onesPlace = tmpDigitNum % 20;
						int tensPlace = tmpDigitNum / 10 % 10;
						even += onesPlace + tensPlace;
					} else {
						even += tmpDigitNum;
					}
				} else {
					odd += tmpDigitNum;
				}
			}

			int x = 0; // 結果
			int resultCount = 0; // 適合回数(複数適合、適合なしの場合のエラーチェック用)

			// 0~9まで総当たりX適合チェック
			for (int i = 0; i < 10; i++) {
				if ((even + odd + i) % 10 == 0) {
					x = i;
					resultCount++;
				}
			}

			// 結果表示
			System.out.println(resultCount == 1 ? String.valueOf(x)
					: "チェックデジット失敗");
		}
	}
}