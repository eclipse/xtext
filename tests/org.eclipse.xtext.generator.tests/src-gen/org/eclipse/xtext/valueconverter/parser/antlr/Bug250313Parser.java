/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.valueconverter.parser.antlr.internal.InternalBug250313Lexer;
import org.eclipse.xtext.valueconverter.parser.antlr.internal.InternalBug250313Parser;

public class Bug250313Parser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalBug250313Lexer lexer = new InternalBug250313Lexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalBug250313Parser parser = new InternalBug250313Parser(
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
		return "Ref2";
	}
}
