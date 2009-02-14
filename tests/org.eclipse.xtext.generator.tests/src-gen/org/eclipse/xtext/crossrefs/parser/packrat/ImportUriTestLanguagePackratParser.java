/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess;

public class ImportUriTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public ImportUriTestLanguagePackratParser(IParseResultFactory parseResultFactory, ImportUriTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ImportUriTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ImportUriTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ImportUriTestLanguageGrammarAccess getGrammarAccess() {
		return (ImportUriTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
