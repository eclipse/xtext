/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;

public class DatatypeRulesTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public DatatypeRulesTestLanguagePackratParser(IParseResultFactory parseResultFactory, DatatypeRulesTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected DatatypeRulesTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new DatatypeRulesTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected DatatypeRulesTestLanguageGrammarAccess getGrammarAccess() {
		return (DatatypeRulesTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
