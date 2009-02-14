/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

public class HiddenTerminalsTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public HiddenTerminalsTestLanguagePackratParser(IParseResultFactory parseResultFactory, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected HiddenTerminalsTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new HiddenTerminalsTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected HiddenTerminalsTestLanguageGrammarAccess getGrammarAccess() {
		return (HiddenTerminalsTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
