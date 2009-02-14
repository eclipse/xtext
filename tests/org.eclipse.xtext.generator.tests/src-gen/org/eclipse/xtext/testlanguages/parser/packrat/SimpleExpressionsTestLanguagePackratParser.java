/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;

public class SimpleExpressionsTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public SimpleExpressionsTestLanguagePackratParser(IParseResultFactory parseResultFactory, SimpleExpressionsTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected SimpleExpressionsTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new SimpleExpressionsTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected SimpleExpressionsTestLanguageGrammarAccess getGrammarAccess() {
		return (SimpleExpressionsTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
