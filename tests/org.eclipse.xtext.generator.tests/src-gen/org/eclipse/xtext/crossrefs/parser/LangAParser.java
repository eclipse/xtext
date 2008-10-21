/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.crossrefs.parser.internal.InternalLangALexer;
import org.eclipse.xtext.crossrefs.parser.internal.InternalLangAParser;

public class LangAParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalLangALexer lexer = new InternalLangALexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalLangAParser parser = new InternalLangAParser(
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
		return "Main";
	}
}
