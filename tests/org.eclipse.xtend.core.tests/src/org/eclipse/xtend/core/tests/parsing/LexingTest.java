package org.eclipse.xtend.core.tests.parsing;

import static org.eclipse.xtext.util.Tuples.*;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
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
	private Lexer lexer;
	
	@Inject
	private ITokenDefProvider tokenDefProvider;

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
}
