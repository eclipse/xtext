/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class LexerTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected LexerTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new LexerTestLanguageParserConfiguration(configuration);
	}

}
