/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class DummyTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected DummyTestLanguageParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new DummyTestLanguageParserConfiguration(configuration);
	}
	
}
