/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;

public class ContentAssistTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public ContentAssistTestLanguagePackratParser(IParseResultFactory parseResultFactory, ContentAssistTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ContentAssistTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ContentAssistTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ContentAssistTestLanguageGrammarAccess getGrammarAccess() {
		return (ContentAssistTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
