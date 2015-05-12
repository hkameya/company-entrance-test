package helper;

import java.io.IOException;
import java.io.InputStream;

/**
 * �W�����͂ɑ΂��A��������͂��s��
 * @see http://d.hatena.ne.jp/kencoba/20120831/1346398388
 */
public class StandardInputSnatcher extends InputStream {

    private StringBuilder buffer = new StringBuilder();
    private static String crlf = System.getProperty("line.separator");

    /**
     * ���������͂���B���s�͎����I�ɍs��
     * @param str ���͕�����
     */
    public void inputln(String str) {
        buffer.append(str).append(crlf);
    }

    @Override
    public int read() throws IOException {
        if (buffer.length() == 0) {
            return -1;
        }
        int result = buffer.charAt(0);
        buffer.deleteCharAt(0);
        return result;
    }
}