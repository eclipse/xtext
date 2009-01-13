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
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.MultiplicationElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageTermConsumer;

public final class SimpleExpressionsTestLanguageMultiplicationConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageTermConsumer termConsumer;

	public SimpleExpressionsTestLanguageMultiplicationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(termConsumer, null, false, false,  getRule().ele0ParserRuleCallTerm()))
						break RULECALL$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$3SUCCESS: while(true) {
					IMarker mGROUP$3 = mark();
					GROUP$3FAILURE: {
						GROUP$4SUCCESS: {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								ACTION$5SUCCESS: {
									consumeAction("Op", "values", true);
									break GROUP$4FAILURE;
								}
							}
							GROUP$4FAILURE: {
								ASSIGNMENT$7SUCCESS: {
									ASSIGNMENT$7FAILURE: {
										if (consumeKeyword(getRule().ele10100KeywordAsterisk(), "operator", false, false))
											break ASSIGNMENT$7FAILURE;
										if (consumeKeyword(getRule().ele10101KeywordSolidus(), "operator", false, false))
											break ASSIGNMENT$7FAILURE;
										mGROUP$4.rollback();
										break ASSIGNMENT$7SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
					}
					GROUP$3FAILURE: {
						ASSIGNMENT$11SUCCESS: {
							ASSIGNMENT$11FAILURE: {
								if (consumeNonTerminal(termConsumer, "values", true, false , getRule().ele110ParserRuleCallTerm()))
									break ASSIGNMENT$11FAILURE;
								mGROUP$3.rollback();
								break ASSIGNMENT$11SUCCESS;
							}
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
					}
					continue GROUP$3SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public MultiplicationElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prMultiplication();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setTermConsumer(SimpleExpressionsTestLanguageTermConsumer termConsumer) {
		this.termConsumer = termConsumer;
	}
	

}
