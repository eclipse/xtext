/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageGrammarAccess;

public class MultiValueFeatureTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public MultiValueFeatureTestLanguagePackratParser(IParseResultFactory parseResultFactory, MultiValueFeatureTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected MultiValueFeatureTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new MultiValueFeatureTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected MultiValueFeatureTestLanguageGrammarAccess getGrammarAccess() {
		return (MultiValueFeatureTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
