/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LexerTestLanguageElementConsumer;

public final class LexerTestLanguageModelConsumer extends NonTerminalConsumer {

	private LexerTestLanguageElementConsumer elementConsumer;

	public LexerTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ASSIGNMENT$1SUCCESS: while(true) {
			ASSIGNMENT$1FAILURE: {
				if (consumeNonTerminal(elementConsumer, "children", true, false , getRule().ele0ParserRuleCallElement()))
					break ASSIGNMENT$1FAILURE;
				break ASSIGNMENT$1SUCCESS;
			}
			continue ASSIGNMENT$1SUCCESS;
		}
		return true;
	}

	public ModelElements getRule() {
		return LexerTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setElementConsumer(LexerTestLanguageElementConsumer elementConsumer) {
		this.elementConsumer = elementConsumer;
	}
	

}
