package org.eclipse.xtend.core.tests.parsing;

import static org.eclipse.xtext.util.Tuples.*;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.util.Pair;
import org.junit.Test;

import com.google.inject.Inject;

@SuppressWarnings("unchecked")
public class LexingTest extends AbstractXtendTestCase {
	
	@Inject
	private ITokenDefProvider tokenDefProvider;

	@Test public void testIdentifier_01() throws Exception {
		assertLexing("String", pair("String","RULE_ID"));
		assertLexing("String", pair("String","RULE_ID"));
	}
	@Test public void testIdentifier_void() throws Exception {
		assertLexing("void", pair("void","RULE_ID"));
		assertLexing("void", pair("void","RULE_ID"));
	}
	@Test public void testIdentifier_02() throws Exception {
		assertLexing("i3", pair("i3","RULE_ID"));
		assertLexing("^i3", pair("^i3","RULE_ID"));
	}
	@Test public void testIdentifier_03() throws Exception {
		assertLexing("\u03b1\u03c1\u03b5\u03c4\u03b7", pair("\u03b1\u03c1\u03b5\u03c4\u03b7","RULE_ID"));
		assertLexing("^\u03b1\u03c1\u03b5\u03c4\u03b7", pair("^\u03b1\u03c1\u03b5\u03c4\u03b7","RULE_ID"));
	}
	@Test public void testIdentifier_04() throws Exception {
		assertLexing("MAX_VALUE", pair("MAX_VALUE","RULE_ID"));
		assertLexing("^MAX_VALUE", pair("^MAX_VALUE","RULE_ID"));
	}
	@Test public void testIdentifier_05() throws Exception {
		assertLexing("isLetterOrDigit", pair("isLetterOrDigit","RULE_ID"));
		assertLexing("^isLetterOrDigit", pair("^isLetterOrDigit","RULE_ID"));
	}
	@Test public void testIdentifier_06() throws Exception {
		assertLexing("\\u0060", pair("\\u0060","RULE_ID"));
		assertLexing("^\\u0060", pair("^\\u0060","RULE_ID"));
	}
	@Test public void testIdentifier_07() throws Exception {
		assertLexing("\\u006f\\u006F", pair("\\u006f\\u006F","RULE_ID"));
		assertLexing("^\\u006f\\u006F", pair("^\\u006f\\u006F","RULE_ID"));
	}
	
	@Test public void testRichString() throws Exception {
		assertLexing("''' foo bar '''", pair("''' foo bar '''","RULE_RICH_TEXT"));
		assertLexing("''' foo bar «", pair("''' foo bar «","RULE_RICH_TEXT_START"));
		assertLexing("» foo bar «", pair("» foo bar «","RULE_RICH_TEXT_INBETWEEN"));
		assertLexing("» foo bar '''", pair("» foo bar '''","RULE_RICH_TEXT_END"));
	}
	
	@Test public void testRichString_01() throws Exception {
		assertLexing("''''''}", pair("''''''","RULE_RICH_TEXT"),pair("}","'}'"));
	}
	
	@Test public void testRichString_02() throws Exception {
		assertLexing("'''«", pair("'''«", "RULE_RICH_TEXT_START"));
	}
	
	@Test public void testRichString_03() throws Exception {
		assertLexing("''''«", pair("''''«", "RULE_RICH_TEXT_START"));
		assertLexing("'''' «", pair("'''' «", "RULE_RICH_TEXT_START"));
		assertLexing("''' '«", pair("''' '«", "RULE_RICH_TEXT_START"));
	}
	
	@Test public void testRichString_04() throws Exception {
		assertLexing("'''''«", pair("'''''«", "RULE_RICH_TEXT_START"));
		assertLexing("''''' «", pair("''''' «", "RULE_RICH_TEXT_START"));
		assertLexing("''' ''«", pair("''' ''«", "RULE_RICH_TEXT_START"));
	}
	
	@Test public void testRichString_05() throws Exception {
		assertLexing("»«", pair("»«", "RULE_RICH_TEXT_INBETWEEN"));
	}
	
	@Test public void testRichString_06() throws Exception {
		assertLexing("»'«", pair("»'«", "RULE_RICH_TEXT_INBETWEEN"));
		assertLexing("»' «", pair("»' «", "RULE_RICH_TEXT_INBETWEEN"));
		assertLexing("» '«", pair("» '«", "RULE_RICH_TEXT_INBETWEEN"));
	}
	
	@Test public void testRichString_07() throws Exception {
		assertLexing("»''«", pair("»''«", "RULE_RICH_TEXT_INBETWEEN"));
		assertLexing("»'' «", pair("»'' «", "RULE_RICH_TEXT_INBETWEEN"));
		assertLexing("» ''«", pair("» ''«", "RULE_RICH_TEXT_INBETWEEN"));
	}
	
	@Test public void testRichString_08() throws Exception {
		assertLexing("»''««", pair("»''«", "RULE_RICH_TEXT_INBETWEEN"), pair("«", "RULE_ANY_OTHER"));
		assertLexing("»'' ««", pair("»'' «", "RULE_RICH_TEXT_INBETWEEN"), pair("«", "RULE_ANY_OTHER"));
		assertLexing("» ''««", pair("» ''«", "RULE_RICH_TEXT_INBETWEEN"), pair("«", "RULE_ANY_OTHER"));
	}
	
	@Test public void testRichString_09() throws Exception {
		assertLexing("»«'", pair("»«", "RULE_RICH_TEXT_INBETWEEN"), pair("'", "RULE_ANY_OTHER"));
		assertLexing("»'«'", pair("»'«", "RULE_RICH_TEXT_INBETWEEN"), pair("'", "RULE_ANY_OTHER"));
		assertLexing("»' «'", pair("»' «", "RULE_RICH_TEXT_INBETWEEN"), pair("'", "RULE_ANY_OTHER"));
		assertLexing("» '«'", pair("» '«", "RULE_RICH_TEXT_INBETWEEN"), pair("'", "RULE_ANY_OTHER"));
	}
	
	@Test public void testFunctionSig() throws Exception {
		assertLexing("class X { foo() ''' foo ''' }",
				pair("class","'class'"),
				pair(" ","RULE_WS"),
				pair("X","RULE_ID"),
				pair(" ","RULE_WS"),
				pair("{","'{'"),
				pair(" ","RULE_WS"),
				pair("foo","RULE_ID"),
				pair("(","'('"),
				pair(")","')'"),
				pair(" ","RULE_WS"),
				pair("''' foo '''","RULE_RICH_TEXT"),
				pair(" ","RULE_WS"),
				pair("}","'}'")
				);
	}
	
	protected void assertLexing(String input, Pair<String,String>... expectedTokens) {
		Lexer lexer = new InternalXtendLexer(null);
		CharStream stream = new ANTLRStringStream(input);
		lexer.setCharStream(stream);
		XtextTokenStream tokenStream = new XtextTokenStream(lexer, tokenDefProvider);
		List<?> tokens = tokenStream.getTokens();
		assertEquals(input + " / " + tokens, expectedTokens.length, tokens.size());
		for(int i = 0;i < tokens.size(); i++) {
			Token token = (Token) tokens.get(i);
			assertEquals(token.toString(), expectedTokens[i].getFirst(), token.getText());
			final String expected = expectedTokens[i].getSecond();
			String actual = tokenDefProvider.getTokenDefMap().get(token.getType());
			assertEquals("expected "+expected+" but was "+actual, expected, actual);
		}
	}
	
	protected ITokenDefProvider getTokenDefProvider() {
		return tokenDefProvider;
	}
}
