/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

public class TerminalRulesTestLanguagePackratParser extends AbstractPackratParser {

	@Override
	protected TerminalRulesTestLanguageParserConfiguration createParserConfiguration(ICharSequenceWithOffset input,
			IMarkerFactory markerFactory, IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil) {
		return new TerminalRulesTestLanguageParserConfiguration(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

}
