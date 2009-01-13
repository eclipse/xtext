/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal.InternalTransientValuesTestLexer;
import org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal.InternalTransientValuesTestParser;

public class TransientValuesTestParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalTransientValuesTestLexer lexer = new InternalTransientValuesTestLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalTransientValuesTestParser parser = new InternalTransientValuesTestParser(
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
		return "Root";
	}
}
