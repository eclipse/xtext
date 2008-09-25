/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.core.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.ui.core.parser.internal.InternalTestLanguageLexer;
import org.eclipse.xtext.ui.core.parser.internal.InternalTestLanguageParser;


public class TestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalTestLanguageLexer lexer = new InternalTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalTestLanguageParser parser = new InternalTestLanguageParser(
				stream, factory, grammarAccess.getGrammar());
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
		return "File";
	}
}
