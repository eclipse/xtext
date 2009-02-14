/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;

public class TreeTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public TreeTestLanguagePackratParser(IParseResultFactory parseResultFactory, TreeTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected TreeTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new TreeTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected TreeTestLanguageGrammarAccess getGrammarAccess() {
		return (TreeTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
