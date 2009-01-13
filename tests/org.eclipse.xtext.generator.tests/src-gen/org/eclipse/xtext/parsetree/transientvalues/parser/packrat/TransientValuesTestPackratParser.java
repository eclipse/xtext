/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

public class TransientValuesTestPackratParser extends AbstractPackratParser {

	@Override
	protected TransientValuesTestParserConfiguration createParserConfiguration(ICharSequenceWithOffset input,
			IMarkerFactory markerFactory, IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil) {
		return new TransientValuesTestParserConfiguration(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

}
