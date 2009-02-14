/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess;

public class LexerTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public LexerTestLanguagePackratParser(IParseResultFactory parseResultFactory, LexerTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected LexerTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new LexerTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected LexerTestLanguageGrammarAccess getGrammarAccess() {
		return (LexerTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
