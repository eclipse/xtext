/*
Generated with Xtext
*/
package org.eclipse.xtext.generator.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.generator.services.LowerCaseNamedTestLanguageGrammarAccess;

public class LowerCaseNamedTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public LowerCaseNamedTestLanguagePackratParser(IParseResultFactory parseResultFactory, LowerCaseNamedTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected LowerCaseNamedTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new LowerCaseNamedTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected LowerCaseNamedTestLanguageGrammarAccess getGrammarAccess() {
		return (LowerCaseNamedTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
