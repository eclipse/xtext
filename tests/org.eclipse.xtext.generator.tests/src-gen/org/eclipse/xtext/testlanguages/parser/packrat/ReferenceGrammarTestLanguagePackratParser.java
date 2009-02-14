/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;

public class ReferenceGrammarTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public ReferenceGrammarTestLanguagePackratParser(IParseResultFactory parseResultFactory, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ReferenceGrammarTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ReferenceGrammarTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ReferenceGrammarTestLanguageGrammarAccess getGrammarAccess() {
		return (ReferenceGrammarTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
