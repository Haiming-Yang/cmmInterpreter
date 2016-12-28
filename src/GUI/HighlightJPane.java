package GUI;

/**
 * Created by TangJiong on 2016/1/4.
 * 能高亮显示关键字的JTextPane
 */
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

public class HighlightJPane extends JTextPane {
    /**
     *
     */
  //  private static final long serialVersionUID = -66377652770879651L;
    protected StyleContext m_context;
    protected DefaultStyledDocument m_doc;
    private MutableAttributeSet keyAttr, normalAttr;
    private MutableAttributeSet bracketAttr;
    private MutableAttributeSet inputAttributes = new RTFEditorKit()
            .getInputAttributes();
    /**
     * 所有关键字
     */
    private final static String[] _keys = new String[] { "int", "real",
            "if", "else", "read", "write", "while"};
    /**
     * 所与排除字符集
     */
    private final static char[] _character = new char[] { '(', ')', ',', ';',
            ':', '\t', '\n', '+', '-', '*', '/' };
    /**
     * 初始化，包括关键字颜色，和非关键字颜色
     */
    public HighlightJPane() {
        super();
        m_context = new StyleContext();
        m_doc = new DefaultStyledDocument(m_context);
        this.setDocument(m_doc);
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                dealSingleRow();
            }
        });
        // 定义关键字显示属性
        keyAttr = new SimpleAttributeSet();
        StyleConstants.setForeground(keyAttr, Color.RED);
        // 定义一般文本显示属性
        normalAttr = new SimpleAttributeSet();
        StyleConstants.setBold(normalAttr, false);
        StyleConstants.setForeground(normalAttr, Color.BLACK);
        bracketAttr = new SimpleAttributeSet();
        StyleConstants.setForeground(bracketAttr, Color.BLUE);
        StyleConstants.setBold(bracketAttr, true);
    }
    /**
     * 设置大括号颜色
     * @param _text
     */
    private void setBracketColor(String _text) {
        int len = _text.length();
        for (int i = 0; i < len; i++) {
            char ch = _text.charAt(i);
            if (ch == '{' || ch == '}') {
                m_doc.setCharacterAttributes(i, 1, bracketAttr, false);
            }
        }
    }
    /**
     * 判断字符是不是在排除字符行列
     * @param _ch
     * @return
     */
    private boolean isCharacter(char _ch) {
        for (int i = 0; i < _character.length; i++) {
            if (_ch == _character[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * 设置关键字颜色
     * @param _key
     * @param _start
     * @param _length
     * @return
     */
    private int setKeyColor(String _key, int _start, int _length) {
        for (int i = 0; i < _keys.length; i++) {
            int li_index = _key.indexOf(_keys[i]);
            if (li_index < 0) {
                continue;
            }
            int li_legnth = li_index + _keys[i].length();
            if (li_legnth == _key.length()) {
                if (li_index == 0) {//处理单独一个关键字的情况，例如：if else 等
                    m_doc.setCharacterAttributes(_start, _keys[i].length(),
                            keyAttr, false);
                } else {//处理关键字前面还有字符的情况，例如：)if ;else 等
                    char ch_temp = _key.charAt(li_index - 1);
                    if (isCharacter(ch_temp)) {
                        m_doc.setCharacterAttributes(_start + li_index,
                                _keys[i].length(), keyAttr, false);
                    }
                }
            } else {
                if (li_index == 0) {//处理关键字后面还有字符的情况，例如：if(  end;等
                    char ch_temp = _key.charAt(_keys[i].length());
                    if (isCharacter(ch_temp)) {
                        m_doc.setCharacterAttributes(_start, _keys[i].length(),
                                keyAttr, false);
                    }
                } else {//处理关键字前面和后面都有字符的情况，例如：)if( 等
                    char ch_temp = _key.charAt(li_index - 1);
                    char ch_temp_2 = _key.charAt(li_legnth);
                    if (isCharacter(ch_temp) && isCharacter(ch_temp_2)) {
                        m_doc.setCharacterAttributes(_start + li_index,
                                _keys[i].length(), keyAttr, false);
                    }
                }
            }
        }
        return _length + 1;
    }
    /**
     * 处理一行的数据
     * @param _start
     * @param _end
     */
    private void dealText(int _start, int _end) {
        String text = "";
        try {
            text = m_doc.getText(_start, _end - _start).toUpperCase();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        if (text == null || text.equals("")) {
            return;
        }
        int xStart = 0;
        // 析关键字---
        m_doc.setCharacterAttributes(_start, text.length(), normalAttr, false);
        MyStringTokenizer st = new MyStringTokenizer(text);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s == null)
                return;
            xStart = st.getCurrPosition();
            setKeyColor(s.toLowerCase(), _start + xStart, s.length());
        }
        setBracketColor(text);
        inputAttributes.addAttributes(normalAttr);
    }
    /**
     * 在进行文本修改的时候
     * 获得光标所在行，只对该行进行处理
     */
    private void dealSingleRow() {
        Element root = m_doc.getDefaultRootElement();
        // 光标当前行
        int cursorPos = this.getCaretPosition(); // 前光标的位置
        int line = root.getElementIndex(cursorPos);// 当前行
        Element para = root.getElement(line);
        int start = para.getStartOffset();
        int end = para.getEndOffset() - 1;// 除\r字符
        dealText(start, end);
    }
    /**
     * 在初始化面板的时候调用该方法，
     * 查找整个篇幅的关键字
     */
    public void syntaxParse() {
        Element root = m_doc.getDefaultRootElement();
        int li_count = root.getElementCount();
        for (int i = 0; i < li_count; i++) {
            Element para = root.getElement(i);
            int start = para.getStartOffset();
            int end = para.getEndOffset() - 1;// 除\r字符
            dealText(start, end);
        }
    }
}
/**
 * 在分析字符串的同时，记录每个token所在的位置
 *
 */
class MyStringTokenizer extends StringTokenizer {
    String sval = " ";
    String oldStr, str;
    int m_currPosition = 0, m_beginPosition = 0;
    MyStringTokenizer(String str) {
        super(str, " ");
        this.oldStr = str;
        this.str = str;
    }
    public String nextToken() {
        try {
            String s = super.nextToken();
            int pos = -1;
            if (oldStr.equals(s)) {
                return s;
            }
            pos = str.indexOf(s + sval);
            if (pos == -1) {
                pos = str.indexOf(sval + s);
                if (pos == -1)
                    return null;
                else
                    pos += 1;
            }
            int xBegin = pos + s.length();
            str = str.substring(xBegin);
            m_currPosition = m_beginPosition + pos;
            m_beginPosition = m_beginPosition + xBegin;
            return s;
        } catch (java.util.NoSuchElementException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    // 返回token在字符串中的位置
    public int getCurrPosition() {
        return m_currPosition;
    }
}
