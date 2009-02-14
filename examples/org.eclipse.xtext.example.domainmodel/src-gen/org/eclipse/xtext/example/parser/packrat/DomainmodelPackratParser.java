/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;

public class DomainmodelPackratParser extends AbstractPackratParser {
	
	@Inject
	public DomainmodelPackratParser(IParseResultFactory parseResultFactory, DomainmodelGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected DomainmodelParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new DomainmodelParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected DomainmodelGrammarAccess getGrammarAccess() {
		return (DomainmodelGrammarAccess)super.getGrammarAccess();
	}
	
}
