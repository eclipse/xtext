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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead4Elements;


public final class LookaheadTestLanguageLookAhead4Consumer extends NonTerminalConsumer {


	public LookaheadTestLanguageLookAhead4Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				ASSIGNMENT$2SUCCESS: {
					ASSIGNMENT$2FAILURE: {
						if (consumeKeyword(getRule().ele00KeywordC(), "x", false, false))
							break ASSIGNMENT$2FAILURE;
						break ASSIGNMENT$2SUCCESS;
					}
					break ALTERNATIVES$1FAILURE;
				}
				ASSIGNMENT$4SUCCESS: {
					ASSIGNMENT$4FAILURE: {
						if (consumeKeyword(getRule().ele10KeywordD(), "x", false, false))
							break ASSIGNMENT$4FAILURE;
						break ASSIGNMENT$4SUCCESS;
					}
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public LookAhead4Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead4();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead4";
	}
	

}
