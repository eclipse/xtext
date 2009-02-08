/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class FowlerDslTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected FowlerDslTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new FowlerDslTestLanguageParserConfiguration(configuration);
	}
	
}
