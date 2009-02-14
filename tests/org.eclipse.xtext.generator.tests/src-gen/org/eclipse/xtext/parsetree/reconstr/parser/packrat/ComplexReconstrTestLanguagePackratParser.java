/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;

public class ComplexReconstrTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public ComplexReconstrTestLanguagePackratParser(IParseResultFactory parseResultFactory, ComplexReconstrTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ComplexReconstrTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ComplexReconstrTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ComplexReconstrTestLanguageGrammarAccess getGrammarAccess() {
		return (ComplexReconstrTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
