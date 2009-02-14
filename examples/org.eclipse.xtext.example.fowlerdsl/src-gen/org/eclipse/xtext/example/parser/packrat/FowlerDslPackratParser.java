/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;

public class FowlerDslPackratParser extends AbstractPackratParser {
	
	@Inject
	public FowlerDslPackratParser(IParseResultFactory parseResultFactory, FowlerDslGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected FowlerDslParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new FowlerDslParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected FowlerDslGrammarAccess getGrammarAccess() {
		return (FowlerDslGrammarAccess)super.getGrammarAccess();
	}
	
}
