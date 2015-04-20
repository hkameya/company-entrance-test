package D006.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {
        int n = 0; //����
        String s = "";//�P��

        //=====����==============
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("IO�G���[�B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //���̓f�[�^����
        String tmpStr[] = line.split(" ");
        if (tmpStr.length != 2) {
            System.out.println("�s���ȓ��̓f�[�^�B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //���̓`�F�b�N
        Pattern linePattern = Pattern.compile("^[0-9]*$");
        Matcher distanceMatch = linePattern.matcher(tmpStr[0]);
        if (!distanceMatch.find()) {
            System.out.println("�����̓��͒l���s���ł��B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        n = Integer.parseInt(tmpStr[0]);
        if (n < 1 || n > 1000) {
            System.out.println("�����̓��͒l���s���ł��B�v���O�������I�����܂��B");
            System.exit(-1);
        }
        s = tmpStr[1];

        //=====�P�ʕϊ�==========
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
            System.out.println("�P�ʂ̓��͒l���s���ł��B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //���ʕ\��
        System.out.println(result);
    }
}