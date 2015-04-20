package C016.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {

        //=====����==============
        String S = "";//���͒l
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            S = br.readLine();
        } catch (IOException e) {
            System.out.println("IO�G���[�B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //���̓`�F�b�N
        if (S.length() < 1 || S.length() > 100) {
            System.out.println("�s���ȕ������B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        Pattern pattern = Pattern.compile("^[A-Z0-9]*$");
        Matcher matcher = pattern.matcher(S);
        if (!matcher.find()) {
            System.out.println("�s���ȓ��͒l�B�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //=====�ϊ�����==========
        char[] curStr = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
            curStr[i] = S.charAt(i);
            switch (curStr[i]) {
            case 'A':
                curStr[i] = '4';
                break;
            case 'E':
                curStr[i] = '3';
                break;
            case 'G':
                curStr[i] = '6';
                break;
            case 'I':
                curStr[i] = '1';
                break;
            case 'O':
                curStr[i] = '0';
                break;
            case 'S':
                curStr[i] = '5';
                break;
            case 'Z':
                curStr[i] = '2';
                break;
            }
        }

        //���ʕ\��
        System.out.println(String.valueOf(curStr));
    }
}