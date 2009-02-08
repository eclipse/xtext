/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class PartialParserTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected PartialParserTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new PartialParserTestLanguageParserConfiguration(configuration);
	}
	
}
