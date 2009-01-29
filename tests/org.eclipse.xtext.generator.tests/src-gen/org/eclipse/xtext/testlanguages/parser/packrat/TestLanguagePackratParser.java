/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class TestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected TestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new TestLanguageParserConfiguration(configuration);
	}

}
