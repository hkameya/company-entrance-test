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
	 * ���̓`�F�b�N.
	 * 
	 * @param inputStr ���͒l
	 */
	private static void check(String inputStr) {

		if (inputStr.length() < 1 || inputStr.length() > 100) {

			System.out.println("�s���ȕ������B�v���O�������I�����܂��B");
			System.exit(-1);
		}

		if (!PATTERN.matcher(inputStr).find()) {

			System.out.println("�s���ȓ��͒l�B�v���O�������I�����܂��B");
			System.exit(-1);
		}
	}

	/**
	 * �ϊ�����.
	 * 
	 * @param inputStr ���͒l
	 * @return String �ϊ���̒l
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

		String inputStr = "";// ���͒l
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			inputStr = br.readLine();
		} catch (IOException e) {
			
			System.out.println("IO�G���[�B�v���O�������I�����܂��B");
			System.exit(-1);
		}

		check(inputStr);

		// ���ʕ\��
		System.out.println(translate(inputStr));
	}
}