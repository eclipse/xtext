/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser.packrat;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;

public class MetamodelRefTestLanguagePackratParser extends AbstractPackratParser {
	
	@Inject
	public MetamodelRefTestLanguagePackratParser(IParseResultFactory parseResultFactory, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
		super(parseResultFactory, grammarAccess);
	}
	
	@Override
	protected MetamodelRefTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new MetamodelRefTestLanguageParserConfiguration(configuration, getGrammarAccess());
	}
	
	@Override
	protected MetamodelRefTestLanguageGrammarAccess getGrammarAccess() {
		return (MetamodelRefTestLanguageGrammarAccess)super.getGrammarAccess();
	}
	
}
