/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

public class PartialParserTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public PartialParserTestLanguagePackratParser(IParseResultFactory parseResultFactory, PartialParserTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected PartialParserTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new PartialParserTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected PartialParserTestLanguageGrammarAccess getGrammarAccess() {
		return (PartialParserTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
