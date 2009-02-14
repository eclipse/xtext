/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

public class ActionTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public ActionTestLanguagePackratParser(IParseResultFactory parseResultFactory, ActionTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ActionTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ActionTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ActionTestLanguageGrammarAccess getGrammarAccess() {
		return (ActionTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
