/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class FowlerDslPackratParser extends AbstractPackratParser {

	@Override
	protected FowlerDslParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new FowlerDslParserConfiguration(configuration);
	}

}
