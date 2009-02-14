/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;

public class TerminalRulesTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public TerminalRulesTestLanguagePackratParser(IParseResultFactory parseResultFactory, TerminalRulesTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected TerminalRulesTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new TerminalRulesTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected TerminalRulesTestLanguageGrammarAccess getGrammarAccess() {
		return (TerminalRulesTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
