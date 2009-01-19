/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.parser.terminalrules.parser.antlr.internal.InternalTerminalRulesTestLanguageLexer;
import org.eclipse.xtext.parser.terminalrules.parser.antlr.internal.InternalTerminalRulesTestLanguageParser;

public class TerminalRulesTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalTerminalRulesTestLanguageLexer lexer = new InternalTerminalRulesTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalTerminalRulesTestLanguageParser parser = new InternalTerminalRulesTestLanguageParser(
				stream, factory, grammarAccess.getGrammar());
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
		return "Model";
	}
}
