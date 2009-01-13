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
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.OptionalEmptyTestLanguageGreetingConsumer;

public final class OptionalEmptyTestLanguageModelConsumer extends NonTerminalConsumer {

	private OptionalEmptyTestLanguageGreetingConsumer greetingConsumer;

	public OptionalEmptyTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ASSIGNMENT$1SUCCESS: {
			ASSIGNMENT$1FAILURE: {
				if (consumeNonTerminal(greetingConsumer, "child", false, false , getRule().ele0ParserRuleCallGreeting()))
					break ASSIGNMENT$1FAILURE;
				break ASSIGNMENT$1SUCCESS;
			}
			return true;
		}
		return true;
	}

	public ModelElements getRule() {
		return OptionalEmptyTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setGreetingConsumer(OptionalEmptyTestLanguageGreetingConsumer greetingConsumer) {
		this.greetingConsumer = greetingConsumer;
	}
	

}
