/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration.IInternalParserConfiguration;

public class DomainmodelPackratParser extends AbstractPackratParser {

	@Override
	protected DomainmodelParserConfiguration createParserConfiguration(IInternalParserConfiguration configuration) {
		return new DomainmodelParserConfiguration(configuration);
	}
	
}
