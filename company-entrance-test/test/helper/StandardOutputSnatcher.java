package helper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

/**
 * �W���o�͂ɑ΂��A�ǂݏo�����ł���悤�ɂ���
 * @see http://d.hatena.ne.jp/kencoba/20120831/1346398388
 */
public class StandardOutputSnatcher extends PrintStream {
    private BufferedReader buffer = new BufferedReader(new StringReader(""));

    public StandardOutputSnatcher() {
        super(new ByteArrayOutputStream());
    }

    /**
     * 1�s���̕������ǂݍ���
     * @return ���s���܂܂Ȃ������B�I�[�̏ꍇ��null
     */
    public String readLine() {
        try {
            String line = "";
            if ((line = buffer.readLine()) != null) {
                return line;
            } else {
                buffer = new BufferedReader(new StringReader(out.toString()));
                ((ByteArrayOutputStream) out).reset();
                return buffer.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}