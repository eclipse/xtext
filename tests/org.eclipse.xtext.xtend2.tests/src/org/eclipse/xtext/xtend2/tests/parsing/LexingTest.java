package org.eclipse.xtext.xtend2.tests.parsing;

import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.inject.Inject;

import static org.eclipse.xtext.util.Tuples.pair;

@SuppressWarnings("unchecked")
public class LexingTest extends AbstractXtend2TestCase {
	
	@Inject
	private Lexer lexer;
	
	@Inject
	private ITokenDefProvider tokenDefProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testRichString() throws Exception {
		assertLexing("''' foo bar '''", pair("''' foo bar '''",6));
		assertLexing("''' foo bar «", pair("''' foo bar «",7));
		assertLexing("» foo bar «", pair("» foo bar «",8));
		assertLexing("» foo bar '''", pair("» foo bar '''",9));
	}
	
	public void testRichString_01() throws Exception {
		assertLexing("''''''}", pair("''''''",6),pair("}",27));
	}
	
	public void testFunctionSig() throws Exception {
		assertLexing("class X { foo() ''' foo ''' }",
				pair("class",23),
				pair(" ",14),
				pair("X",4),
				pair(" ",14),
				pair("{",26),
				pair(" ",14),
				pair("foo",4),
				pair("(",28),
				pair(")",29),
				pair(" ",14),
				pair("''' foo '''",6),
				pair(" ",14),
				pair("}",27)
				);
	}
	
	protected void assertLexing(String input, Pair<String,Integer>... expectedTokens) {
		CharStream stream = new ANTLRStringStream(input);
		lexer.setCharStream(stream);
		XtextTokenStream tokenStream = new XtextTokenStream(lexer, tokenDefProvider);
		List<?> tokens = tokenStream.getTokens();
		assertEquals(input, expectedTokens.length, tokens.size());
		for(int i = 0;i < tokens.size(); i++) {
			Token token = (Token) tokens.get(i);
			assertEquals(token.toString(), expectedTokens[i].getFirst(), token.getText());
			final Map<Integer, String> types = tokenDefProvider.getTokenDefMap();
			assertEquals(types.get(expectedTokens[i].getSecond())+" but was "+types.get(token.getType()), expectedTokens[i].getSecond(), (Integer)token.getType());
		}
	}
}
