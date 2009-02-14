/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.ui.integration.services.TestLanguageGrammarAccess;

public class TestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public TestLanguagePackratParser(IParseResultFactory parseResultFactory, TestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected TestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new TestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected TestLanguageGrammarAccess getGrammarAccess() {
		return (TestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
