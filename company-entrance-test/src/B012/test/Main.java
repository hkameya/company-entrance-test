package B012.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String args[]) {

        int n = 0; //�s��
        ArrayList<String> creditData_sList = new ArrayList<>();//��������N���W�b�g�J�[�h�ԍ��f�[�^���X�g

        //====���͏���==========================
        //�s������
        try {
            boolean isCorrectRowNum = false;
            while (!isCorrectRowNum) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();

                //���͍s���𕶎��񂩂琔���֕ϊ�
                Pattern linePattern = Pattern.compile("^[0-9]*$");
                Matcher lineMatch = linePattern.matcher(line);
                if (lineMatch.find()) {
                    n = Integer.parseInt(line);
                } else {
                    System.out.println("�s�����s���ȓ��͒l�A�ē��͂��ĉ�����");
                    continue;
                }

                //���͐��`�F�b�N
                if (n < 1 || n > 100) {
                    System.out.println("�s���ȓ��͐��A�ē��͂��ĉ������B");
                    continue;
                }
                isCorrectRowNum = true;
            }
        } catch (IOException e) {
            System.out.println("IO�G���[�A�v���O�������I�����܂��B");
            System.exit(-1);
        }

        //�J�[�h�ԍ�����
        try {
            int dataCount = 0;
            while (dataCount < n) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();

                //�������`�F�b�N
                if (line.length() != 16) {
                    System.out.println("16�����ł͂Ȃ��f�[�^���܂܂�Ă��܂��B�ē��͂��ĉ������B");
                    continue;
                }

                //�����𐔎���X�̕����ɕ���
                String numData_s = line.substring(0, 15);
                String xData_s = line.substring(15);

                //�����`�F�b�N
                Pattern NumDataPattern = Pattern.compile("^[0-9]*$");
                Matcher NumDataMatch = NumDataPattern.matcher(numData_s);
                if (!NumDataMatch.find()) {
                    System.out.println("�J�[�h����15�����ڂ܂łɐ����łȂ����̂��܂܂�Ă��܂��B�ē��͂��ĉ�����");
                    continue;
                }
                if (!xData_s.equals("X")) {
                    System.out.println("�J�[�h���̖�����X�ł͂���܂���B�ē��͂��ĉ������B");
                    continue;
                }

                creditData_sList.add(numData_s + "0"); //X�̑���Ɍ��ʂɉe���̂Ȃ�0�����Ă���
                dataCount++;
            }
        } catch (IOException e) {
            System.out.println("IO�G���[");
        }

        //====���͂��ꂽ�eX�����߂�=======================
        for (String checkingData : creditData_sList) {

            int even = 0;//�������̑��a
            int odd = 0; //����̑��a
            int x = 0; //����
            int resultCount = 0; //�K����(�����K���A�K���Ȃ��̏ꍇ�̃G���[�`�F�b�N�p)

            //�e���̏���
            for (int i = 1; i <= 16; i++) {

                //�������錅��ǂݍ���
                int loadIndexBegin = 16 - i;
                int loadIndexEnd = 17 - i;
                int tmpDigitNum = Integer.parseInt(checkingData.substring(loadIndexBegin, loadIndexEnd));

                //�����E��ʏ���
                if (i % 2 == 0) {
                    tmpDigitNum = tmpDigitNum * 2;
                    if (tmpDigitNum >= 10) {//2���ɂȂ����ꍇ
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

            //0~9�܂ő�������X�K���`�F�b�N
            for (int i = 0; i < 10; i++) {
                if ((even + odd + i) % 10 == 0) {
                    x = i;
                    resultCount++;
                }
            }

            //���ʕ\��
            if (resultCount == 1) {
                System.out.println(String.valueOf(x));
            } else {
                System.out.println(String.valueOf("�`�F�b�N�f�W�b�g���s"));//�d��,�K���Ȃ�
            }
        }
    }
}