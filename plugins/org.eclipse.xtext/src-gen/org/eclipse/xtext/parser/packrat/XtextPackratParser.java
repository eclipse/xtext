/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class XtextPackratParser extends AbstractPackratParser {

	@Override
	protected XtextParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new XtextParserConfiguration(configuration);
	}
	
}
