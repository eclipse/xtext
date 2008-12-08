/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.parsetree.reconstr.parser.internal.InternalComplexReconstrTestLanguageLexer;
import org.eclipse.xtext.parsetree.reconstr.parser.internal.InternalComplexReconstrTestLanguageParser;

public class ComplexReconstrTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalComplexReconstrTestLanguageLexer lexer = new InternalComplexReconstrTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalComplexReconstrTestLanguageParser parser = new InternalComplexReconstrTestLanguageParser(
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
		return "Op";
	}
}
