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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead2Elements;


public final class LookaheadTestLanguageLookAhead2Consumer extends NonTerminalConsumer {


	public LookaheadTestLanguageLookAhead2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				ALTERNATIVES$2SUCCESS: {
					ALTERNATIVES$2FAILURE: {
						ASSIGNMENT$3SUCCESS: {
							ASSIGNMENT$3FAILURE: {
								if (consumeKeyword(getRule().ele000KeywordFoo(), "z", false, false))
									break ASSIGNMENT$3FAILURE;
								break ASSIGNMENT$3SUCCESS;
							}
							break ALTERNATIVES$2FAILURE;
						}
						ASSIGNMENT$5SUCCESS: {
							ASSIGNMENT$5FAILURE: {
								if (consumeKeyword(getRule().ele010KeywordBar(), "z", false, false))
									break ASSIGNMENT$5FAILURE;
								break ASSIGNMENT$5SUCCESS;
							}
							break ALTERNATIVES$2FAILURE;
						}
						mGROUP$1.rollback();
						break ALTERNATIVES$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$7SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordC(), null, false, false))
						break KEYWORD$7SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public LookAhead2Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead2();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead2";
	}
	

}
