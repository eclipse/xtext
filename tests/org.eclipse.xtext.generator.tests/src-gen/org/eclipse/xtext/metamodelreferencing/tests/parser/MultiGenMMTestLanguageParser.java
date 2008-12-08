/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMultiGenMMTestLanguageLexer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.internal.InternalMultiGenMMTestLanguageParser;

public class MultiGenMMTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalMultiGenMMTestLanguageLexer lexer = new InternalMultiGenMMTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalMultiGenMMTestLanguageParser parser = new InternalMultiGenMMTestLanguageParser(
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
		return "Foo";
	}
}
