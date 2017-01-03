package GUI;

import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class coloringrun implements Runnable{
	private StyledDocument doc;
	private Style style;
	private int pos;
	private int len;

	public coloringrun(StyledDocument doc, int pos, int len, Style style) {
		this.doc = doc;
		this.pos = pos;
		this.len = len;
		this.style = style;
	}

	public void run() {
		try {
			// ������Ƕ��ַ�������ɫ
			doc.setCharacterAttributes(pos, len, style, true);
		} catch (Exception e) {}
	}
}
