/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.terminalrules.parser.antlr.internal.InternalXtextTerminalsTestLanguageLexer;
import org.eclipse.xtext.parser.terminalrules.parser.antlr.internal.InternalXtextTerminalsTestLanguageParser;

public class XtextTerminalsTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected ITokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		InternalXtextTerminalsTestLanguageLexer lexer = new InternalXtextTerminalsTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		InternalXtextTerminalsTestLanguageParser parser = new InternalXtextTerminalsTestLanguageParser(
				stream, getElementFactory(), grammarAccess.getGrammar());
		parser.setTokenTypeMap(antlrTokenDefProvider.getTokenDefMap());
		try {
			if(ruleName != null) {
				return parser.parse(ruleName);
			} else {
				return parser.parse();
			}
		} catch (Exception re) {
			throw new ParseException(re.getMessage(),re);
		}
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Grammar";
	}
}
