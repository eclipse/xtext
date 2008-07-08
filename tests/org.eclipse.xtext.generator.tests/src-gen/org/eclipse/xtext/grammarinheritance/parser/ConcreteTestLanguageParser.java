/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import org.eclipse.xtext.grammarinheritance.parser.internal.InternalConcreteTestLanguageLexer;
import org.eclipse.xtext.grammarinheritance.parser.internal.InternalConcreteTestLanguageParser;


public class ConcreteTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalConcreteTestLanguageLexer lexer = new InternalConcreteTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalConcreteTestLanguageParser parser = new InternalConcreteTestLanguageParser(
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
		return "ConcreteParserRule";
	}
}
