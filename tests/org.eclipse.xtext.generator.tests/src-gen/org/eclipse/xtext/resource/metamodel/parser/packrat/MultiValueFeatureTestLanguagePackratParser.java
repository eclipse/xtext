/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

public class MultiValueFeatureTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected MultiValueFeatureTestLanguageParserConfiguration createParserConfiguration(ICharSequenceWithOffset input,
			IMarkerFactory markerFactory, IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil) {
		return new MultiValueFeatureTestLanguageParserConfiguration(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

}
