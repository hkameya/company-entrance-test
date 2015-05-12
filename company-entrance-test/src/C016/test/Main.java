package C016.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

	private static Map<String, String> translateMap = new HashMap<String, String>();

	private static final Pattern PATTERN = Pattern.compile("^[A-Z0-9]*$");

	private static void initialTranslateMap() {

		translateMap.put("A", "4");
		translateMap.put("E", "3");
		translateMap.put("G", "6");
		translateMap.put("I", "1");
		translateMap.put("O", "0");
		translateMap.put("S", "5");
	}

	static {

		initialTranslateMap();
	}

	/**
	 * 入力チェック.
	 * 
	 * @param inputStr 入力値
	 */
	private static void check(String inputStr) {

		if (inputStr.length() < 1 || inputStr.length() > 100) {

			System.out.println("不正な文字数。プログラムを終了します。");
			System.exit(-1);
		}

		if (!PATTERN.matcher(inputStr).find()) {

			System.out.println("不正な入力値。プログラムを終了します。");
			System.exit(-1);
		}
	}

	/**
	 * 変換処理.
	 * 
	 * @param inputStr 入力値
	 * @return String 変換後の値
	 */
	private static String translate(String inputStr) {

		for (Map.Entry<String, String> entry : translateMap.entrySet()) {

			inputStr = inputStr.replaceAll(entry.getKey(), entry.getValue());
		}

		return inputStr;
	}

	/**
	 * Main.
	 * 
	 * @param args String[]
	 */
	public static void main(String args[]) {

		String inputStr = "";// 入力値
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			inputStr = br.readLine();
		} catch (IOException e) {
			
			System.out.println("IOエラー。プログラムを終了します。");
			System.exit(-1);
		}

		check(inputStr);

		// 結果表示
		System.out.println(translate(inputStr));
	}
}