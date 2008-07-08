/*
Generated with Xtext
*/
package org.eclipse.xtext.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.parser.internal.InternalPreferenceLexer;
import org.eclipse.xtext.parser.internal.InternalPreferenceParser;


public class PreferenceParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalPreferenceLexer lexer = new InternalPreferenceLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalPreferenceParser parser = new InternalPreferenceParser(
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
		return "Description";
	}
}
