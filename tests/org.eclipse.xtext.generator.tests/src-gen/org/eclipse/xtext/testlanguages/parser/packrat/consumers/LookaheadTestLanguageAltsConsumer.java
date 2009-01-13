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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.AltsElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead0Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead1Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead3Consumer;

public final class LookaheadTestLanguageAltsConsumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer;
	private LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer;
	private LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer;

	public LookaheadTestLanguageAltsConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				ALTERNATIVES$2SUCCESS: {
					ALTERNATIVES$2FAILURE: {
						RULECALL$3SUCCESS: {
							if (!consumeNonTerminal(lookAhead0Consumer, null, false, false,  getRule().ele00ParserRuleCallLookAhead0()))
								break RULECALL$3SUCCESS;
							break ALTERNATIVES$2FAILURE;
						}
						RULECALL$4SUCCESS: {
							if (!consumeNonTerminal(lookAhead1Consumer, null, false, false,  getRule().ele01ParserRuleCallLookAhead1()))
								break RULECALL$4SUCCESS;
							break ALTERNATIVES$2FAILURE;
						}
						break ALTERNATIVES$2SUCCESS;
					}
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$5SUCCESS: {
					if (!consumeNonTerminal(lookAhead3Consumer, null, false, false,  getRule().ele1ParserRuleCallLookAhead3()))
						break RULECALL$5SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public AltsElements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prAlts();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Alts";
	}
	
	public void setLookAhead0Consumer(LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer) {
		this.lookAhead0Consumer = lookAhead0Consumer;
	}
	
	public void setLookAhead1Consumer(LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer) {
		this.lookAhead1Consumer = lookAhead1Consumer;
	}
	
	public void setLookAhead3Consumer(LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer) {
		this.lookAhead3Consumer = lookAhead3Consumer;
	}
	

}
