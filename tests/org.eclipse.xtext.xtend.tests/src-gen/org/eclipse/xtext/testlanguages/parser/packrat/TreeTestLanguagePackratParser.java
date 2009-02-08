/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class TreeTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected TreeTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new TreeTestLanguageParserConfiguration(configuration);
	}
	
}
