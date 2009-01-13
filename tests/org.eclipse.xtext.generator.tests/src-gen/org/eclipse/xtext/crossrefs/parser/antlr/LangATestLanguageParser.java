/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.crossrefs.parser.antlr.internal.InternalLangATestLanguageLexer;
import org.eclipse.xtext.crossrefs.parser.antlr.internal.InternalLangATestLanguageParser;

public class LangATestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalLangATestLanguageLexer lexer = new InternalLangATestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalLangATestLanguageParser parser = new InternalLangATestLanguageParser(
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
