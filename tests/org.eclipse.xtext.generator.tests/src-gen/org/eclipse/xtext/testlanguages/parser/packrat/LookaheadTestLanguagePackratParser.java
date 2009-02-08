/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class LookaheadTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected LookaheadTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new LookaheadTestLanguageParserConfiguration(configuration);
	}
	
}
