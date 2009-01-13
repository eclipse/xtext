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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead1Elements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead2Consumer;

public final class LookaheadTestLanguageLookAhead1Consumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead2Consumer lookAhead2Consumer;

	public LookaheadTestLanguageLookAhead1Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				GROUP$2SUCCESS: {
					IMarker mGROUP$2 = mark();
					GROUP$2FAILURE: {
						GROUP$3SUCCESS: {
							IMarker mGROUP$3 = mark();
							GROUP$3FAILURE: {
								KEYWORD$4SUCCESS: {
									if (!consumeKeyword(getRule().ele000KeywordFoo(), null, false, false))
										break KEYWORD$4SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeNonTerminal(lookAhead2Consumer, "y", false, false , getRule().ele0010ParserRuleCallLookAhead2()))
											break ASSIGNMENT$5FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$5SUCCESS;
									}
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$7SUCCESS: {
							ASSIGNMENT$7FAILURE: {
								if (consumeKeyword(getRule().ele010KeywordB(), "x", false, false))
									break ASSIGNMENT$7FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$7SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$9SUCCESS: {
					ASSIGNMENT$9FAILURE: {
						if (consumeKeyword(getRule().ele10KeywordD(), "x", false, false))
							break ASSIGNMENT$9FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$9SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public LookAhead1Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead1();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead1";
	}
	
	public void setLookAhead2Consumer(LookaheadTestLanguageLookAhead2Consumer lookAhead2Consumer) {
		this.lookAhead2Consumer = lookAhead2Consumer;
	}
	

}
