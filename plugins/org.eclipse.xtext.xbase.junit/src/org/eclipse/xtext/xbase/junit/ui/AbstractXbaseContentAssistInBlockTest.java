package org.eclipse.xtext.xbase.junit.ui;

import org.junit.Test;

public abstract class AbstractXbaseContentAssistInBlockTest extends AbstractXbaseContentAssistTest {

	protected static String[] VARIABLE_DECL = {"val", "var"};
	
	@Override
	@Test public void testEmptyInput() throws Exception {
		newBuilder().assertText(expect(getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_01() throws Exception {
		newBuilder().append("''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_03() throws Exception {
		newBuilder().append("''.").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_04() throws Exception {
		newBuilder().append("''+''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_10() throws Exception {
		newBuilder().append("'' ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_12() throws Exception {
		newBuilder().append("'' .").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_13() throws Exception {
		newBuilder().append("'' + ''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_28() throws Exception {
		newBuilder().append("''.toString.toString").assertTextAtCursorPosition(".", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_30() throws Exception {
		newBuilder().append("('')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_32() throws Exception {
		newBuilder().append("(''.toString)").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_34() throws Exception {
		newBuilder().append("''.toString ").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_35() throws Exception {
		newBuilder().append("''.toString .").assertTextAtCursorPosition("g .", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testOnStringLiteral_36() throws Exception {
		newBuilder().append("''.toString +''").assertTextAtCursorPosition("+", expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_01() throws Exception {
		newBuilder().append("''+''").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_02() throws Exception {
		newBuilder().append("'' + ''+''").assertTextAtCursorPosition("''+", 2, expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_03() throws Exception {
		newBuilder().append("(''+'')").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Override
	@Test public void testAfterBinaryOperation_05() throws Exception {
		newBuilder().append("((''+''))").assertText(expect(STRING_OPERATORS, CAST_INSTANCEOF, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Test public void testForLoop_06() throws Exception {
		super.newBuilder().append("for (String this: null) ").assertText(expect(new String[]{"this"}, getStringFeatures(), getKeywordsAndStatics()));
	}
	
	@Test public void testForLoop_07() throws Exception {
		newBuilder().append("for (String this: null) ").assertText(expect(new String[]{"this"}, getStringFeatures(), getKeywordsAndStatics()));
	}
	
	@Test public void testAfterVariableDeclaration_01() throws Exception {
		newBuilder().appendNl("var x = '';").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Test public void testAfterVariableDeclaration_02() throws Exception {
		newBuilder().appendNl("var x = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), VARIABLE_DECL));
	}
	
	@Test public void testAfterVariableDeclaration_03() throws Exception {
		newBuilder().appendNl("var x = ''").assertText(expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Test public void testAfterVariableDeclaration_04() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"x"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS));
	}
	
	@Test public void testAfterVariableDeclaration_05() throws Exception {
		newBuilder().appendNl("var this = '';").assertText(expect(new String[] {"this"}, getKeywordsAndStatics(), VARIABLE_DECL, getStringFeatures()));
	}
	
	@Test public void testAfterVariableDeclaration_06() throws Exception {
		newBuilder().appendNl("var this = '';").appendNl("var y = '';").assertTextAtCursorPosition("var y", expect(new String[] {"this"}, getKeywordsAndStatics(), VARIABLE_DECL, getStringFeatures()));
	}
	
	@Test public void testAfterVariableDeclaration_07() throws Exception {
		newBuilder().appendNl("var this = ''").assertText(expect(new String[] {"this"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS, getStringFeatures()));
	}
	
	@Test public void testAfterVariableDeclaration_08() throws Exception {
		newBuilder().appendNl("var this = ''").appendNl("var y = ''").assertTextAtCursorPosition("var y", expect(new String[] {"this"}, getKeywordsAndStatics(), CAST_INSTANCEOF, VARIABLE_DECL, STRING_OPERATORS, getStringFeatures()));
	}
	
	@Test public void testAfterVariableDeclaration_09() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("var y = ").assertText(expect(new String[] {"x"}, getKeywordsAndStatics()));
	}
	
	@Test public void testAfterVariableDeclaration_10() throws Exception {
		newBuilder().appendNl("var this = ''").appendNl("var y = ").assertText(expect(new String[] {"this"}, getKeywordsAndStatics(), getStringFeatures()));
	}
	
	@Test public void testAfterVariableDeclaration_11() throws Exception {
		newBuilder().appendNl("var x = ''").appendNl("x.").assertText(expect(getStringFeatures()));
	}

}
