/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

public class FormatterTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public FormatterTestLanguagePackratParser(IParseResultFactory parseResultFactory, FormatterTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected FormatterTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new FormatterTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected FormatterTestLanguageGrammarAccess getGrammarAccess() {
		return (FormatterTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
