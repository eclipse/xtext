/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parser;

import org.antlr.runtime.ANTLRInputStream;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.service.Inject;

import org.eclipse.xtext.resource.metamodel.parser.internal.InternalMultiValueFeatureTestLanguageLexer;
import org.eclipse.xtext.resource.metamodel.parser.internal.InternalMultiValueFeatureTestLanguageParser;

public class MultiValueFeatureTestLanguageParser extends org.eclipse.xtext.parser.AbstractParser {
	
	@Inject 
    protected AntlrTokenDefProvider antlrTokenDefProvider;
	
	@Override
	protected IParseResult parse(String ruleName, ANTLRInputStream in, IAstFactory factory) {
		InternalMultiValueFeatureTestLanguageLexer lexer = new InternalMultiValueFeatureTestLanguageLexer(in);
		XtextTokenStream stream = new XtextTokenStream(lexer);
		InternalMultiValueFeatureTestLanguageParser parser = new InternalMultiValueFeatureTestLanguageParser(
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
		return "Start";
	}
}
