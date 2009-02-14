/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;

public class LookaheadTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public LookaheadTestLanguagePackratParser(IParseResultFactory parseResultFactory, LookaheadTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected LookaheadTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new LookaheadTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected LookaheadTestLanguageGrammarAccess getGrammarAccess() {
		return (LookaheadTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
