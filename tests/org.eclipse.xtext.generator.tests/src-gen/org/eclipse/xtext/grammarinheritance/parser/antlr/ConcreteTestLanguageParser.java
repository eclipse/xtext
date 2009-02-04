/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.antlr;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

import org.eclipse.xtext.grammarinheritance.parser.antlr.internal.InternalConcreteTestLanguageLexer;
import org.eclipse.xtext.grammarinheritance.parser.antlr.internal.InternalConcreteTestLanguageParser;

public class ConcreteTestLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject 
    protected ITokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in) {
		InternalConcreteTestLanguageLexer lexer = new InternalConcreteTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer, antlrTokenDefProvider);
		InternalConcreteTestLanguageParser parser = new InternalConcreteTestLanguageParser(
				stream, getElementFactory(), grammarAccess.getGrammar());
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
		return "RootRule";
	}
}
