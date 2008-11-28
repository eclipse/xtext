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

import org.eclipse.xtext.crossrefs.parser.internal.InternalImportUriTestLanguageLexer;
import org.eclipse.xtext.crossrefs.parser.internal.InternalImportUriTestLanguageParser;

public class ImportUriTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalImportUriTestLanguageLexer lexer = new InternalImportUriTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalImportUriTestLanguageParser parser = new InternalImportUriTestLanguageParser(
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
