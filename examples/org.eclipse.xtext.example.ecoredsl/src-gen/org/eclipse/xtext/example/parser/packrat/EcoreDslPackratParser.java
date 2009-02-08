/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class EcoreDslPackratParser extends AbstractPackratParser {

	@Override
	protected EcoreDslParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new EcoreDslParserConfiguration(configuration);
	}
	
}
