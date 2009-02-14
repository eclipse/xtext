/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;

public class ReferenceGrammarPackratParser extends AbstractPackratParser {
	
	@Inject
	public ReferenceGrammarPackratParser(IParseResultFactory parseResultFactory, ReferenceGrammarGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected ReferenceGrammarParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new ReferenceGrammarParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected ReferenceGrammarGrammarAccess getGrammarAccess() {
		return (ReferenceGrammarGrammarAccess)super.getGrammarAccess();
	}
	
}
