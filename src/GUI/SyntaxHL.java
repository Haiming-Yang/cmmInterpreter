package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.util.HashSet;

public class SyntaxHL implements DocumentListener{
	private HashSet<String>Typewords;
	private HashSet<String>Causewords;
	private HashSet<String>operator;
	private Style TypeStyle;
	private Style CauseStyle;
	private Style NormalStyle;
	private Style CommentStyle;
	private Style ConstantStyle;
	private Style OperatorStyle;
	
	public SyntaxHL(JTextPane editor) {
		TypeStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		CauseStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		NormalStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		CommentStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		ConstantStyle =  ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		OperatorStyle =  ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);
		StyleConstants.setForeground(TypeStyle, new Color(212, 215, 214));
		StyleConstants.setForeground(CauseStyle, new Color(141, 193, 73));
		StyleConstants.setForeground(NormalStyle, new  Color(81, 154, 186));
		StyleConstants.setForeground(CommentStyle, new  Color(77, 90, 94));
		StyleConstants.setForeground(ConstantStyle, new Color(160, 116, 196));
		StyleConstants.setForeground(OperatorStyle, new Color(204, 62, 68));
		//增加关键字
		this.Typewords= new HashSet<String>();
		this.Causewords= new HashSet<String>();
		this.operator = new HashSet<String>();
		Typewords.add("double");
		Typewords.add("int");
		Causewords.add("write");
		Causewords.add("if");
		Causewords.add("else");
		Causewords.add("while");
		Causewords.add("Break");
		operator.add("=");
		operator.add(";");
		operator.add(",");
		operator.add(">");
		operator.add("<");
		operator.add("|");
		operator.add("*");
		operator.add("/");
		operator.add("%");
		operator.add("+");
		operator.add("-");
		//scroll仅仅用于更新滚动
		
	}
	
	
	public void colouring(StyledDocument doc, int pos, int len) throws BadLocationException {
		// 取得插入或者删除后影响到的单词.
		// 例如"public"在b后插入一个空格, 就变成了:"pub lic", 这时就有两个单词要处理:"pub"和"lic"
		// 这时要取得的范围是pub中p前面的位置和lic中c后面的位置
		int start = indexOfWordStart(doc, pos);
		int end = indexOfWordEnd(doc, pos + len);

		char ch;
		int comment_stat = 0;
		/*
		 * 0 init
		 * 1 //
		 * 2 /*
		 * 3 /**\/
		 * 
		 */
		//*
		while (start < end) {
			ch = getCharAt(doc, start);
//			if( comment_stat == 1 ){
//				if(ch=='\n')comment_stat=0;
//				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, CommentStyle));
//				++start;
//				continue;
//			}else if (comment_stat == 2) {
//				if(ch=='*' &&  getCharAt(doc, start+1)=='/')comment_stat = 3;
//				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, CommentStyle));
//				++start;
//				continue;
//			}else if(comment_stat == 3) {
//				comment_stat=0;
//				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, CommentStyle));
//				++start;
//				continue;
//			}
			
//			if (ch == '/' ) {
//				char ch2= getCharAt(doc, start+1);
//				if(ch2=='/'){
//					comment_stat = 1;
//					SwingUtilities.invokeLater(new coloringrun(doc, start, 1, CommentStyle));
//					++start;
//				}else if(ch2=='*'){
//					comment_stat = 2;
//					SwingUtilities.invokeLater(new coloringrun(doc, start, 1, CommentStyle));
//					++start;
//				}else{
//					SwingUtilities.invokeLater(new coloringrun(doc, start, 1, OperatorStyle));
//					++start;
//				}
//			}
//			else
			if(Character.isLetter(ch) || ch == '_') {
				// 如果是以字母或者下划线开头, 说明是单词
				// pos为处理后的最后一个下标
				start = colouringWord(doc, start);
			} else if(Character.isDigit(ch)){
				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, ConstantStyle));
				++start;
			}else if(operator.contains(String.valueOf(ch))){
				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, OperatorStyle));
				++start;
			}else{
				
				SwingUtilities.invokeLater(new coloringrun(doc, start, 1, NormalStyle));
				++start;
			}
		}
	}
	
	/**
	 * 对单词进行着色, 并返回单词结束的下标.
	 * 
	 * @param doc
	 * @param pos
	 * @return
	 * @throws BadLocationException
	 */
	public int colouringWord(StyledDocument doc, int pos) throws BadLocationException {
		int wordEnd = indexOfWordEnd(doc, pos);
		String word = doc.getText(pos, wordEnd - pos);

		if (Typewords.contains(word)) {
			// 如果是关键字, 就进行关键字的着色, 否则使用普通的着色.
			// 这里有一点要注意, 在insertUpdate和removeUpdate的方法调用的过程中, 不能修改doc的属性.
			// 但我们又要达到能够修改doc的属性, 所以把此任务放到这个方法的外面去执行.
			// 实现这一目的, 可以使用新线程, 但放到swing的事件队列里去处理更轻便一点.
			SwingUtilities.invokeLater(new coloringrun(doc, pos, wordEnd - pos, TypeStyle));
		}else if(Causewords.contains(word)) {
			SwingUtilities.invokeLater(new coloringrun(doc, pos, wordEnd - pos, CauseStyle));
		}
		else  {
			SwingUtilities.invokeLater(new coloringrun(doc, pos, wordEnd - pos, NormalStyle));
		}

		return wordEnd;
	}

	/**
	 * 取得在文档中下标在pos处的字符.
	 * 
	 * 如果pos为doc.getLength(), 返回的是一个文档的结束符, 不会抛出异常. 如果pos<0, 则会抛出异常.
	 * 所以pos的有效值是[0, doc.getLength()]
	 * 
	 * @param doc
	 * @param pos
	 * @return
	 * @throws BadLocationException
	 */
	public char getCharAt(Document doc, int pos) throws BadLocationException {
		return doc.getText(pos, 1).charAt(0);
	}

	/**
	 * 取得下标为pos时, 它所在的单词开始的下标. Â±wor^dÂ± (^表示pos, Â±表示开始或结束的下标)
	 * 
	 * @param doc
	 * @param pos
	 * @return
	 * @throws BadLocationException
	 */
	public int indexOfWordStart(Document doc, int pos) throws BadLocationException {
		// 从pos开始向前找到第一个非单词字符.
		for (; pos > 0 && isWordCharacter(doc, pos - 1); --pos);

		return pos;
	}

	/**
	 * 取得下标为pos时, 它所在的单词结束的下标. Â±wor^dÂ± (^表示pos, Â±表示开始或结束的下标)
	 * 
	 * @param doc
	 * @param pos
	 * @return
	 * @throws BadLocationException
	 */
	public int indexOfWordEnd(Document doc, int pos) throws BadLocationException {
		// 从pos开始向前找到第一个非单词字符.
		for (; isWordCharacter(doc, pos); ++pos);

		return pos;
	}

	/**
	 * 如果一个字符是字母, 数字, 下划线, 则返回true.
	 * 
	 * @param doc
	 * @param pos
	 * @return
	 * @throws BadLocationException
	 */
	public boolean isWordCharacter(Document doc, int pos) throws BadLocationException {
		char ch = getCharAt(doc, pos);
		if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '_') { return true; }
		return false;
	}
	
	/**
	 * 全体扫描注释
	 *  @param doc
	 *  @return
	 *  @throws BadLocationException
	 */
	public void commentcolor(StyledDocument doc) throws BadLocationException {
		int i=0;
		int comment_stat = 0;
		/*
		 * 0 init
		 * 1 //
		 * 2 /*
		 * 3 /**\/
		 * 
		 */
		while(i<doc.getLength())
		{
			
			char ch=getCharAt(doc,i);
			char ch2 = getCharAt(doc, i+1);
			
			if(comment_stat == 0){
					if(ch=='/' && ch2=='/'){
						comment_stat = 1;
						SwingUtilities.invokeLater(new coloringrun(doc, i, 1, CommentStyle));
					}else if(ch=='/' && ch2=='*'){
						SwingUtilities.invokeLater(new coloringrun(doc, i, 1, CommentStyle));
						comment_stat = 2;
					}
			}else if(comment_stat == 1){
					if(ch!='\n');
					else comment_stat=0;
					SwingUtilities.invokeLater(new coloringrun(doc, i, 1, CommentStyle));
			}else if(comment_stat == 2){
				if(ch=='*' && ch2=='/')comment_stat=3;
				SwingUtilities.invokeLater(new coloringrun(doc, i, 1, CommentStyle));
			}else if(comment_stat==3){
				SwingUtilities.invokeLater(new coloringrun(doc, i, 1, CommentStyle));
				comment_stat=0;
			}
				i++;
			}
		
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			colouring((StyledDocument) e.getDocument(), e.getOffset(), e.getLength());
			commentcolor((StyledDocument) e.getDocument());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			colouring((StyledDocument) e.getDocument(), e.getOffset(), 0);
			commentcolor((StyledDocument) e.getDocument());
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

}
