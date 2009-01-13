/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.OpElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTermConsumer;

public final class ComplexReconstrTestLanguageOpConsumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageTermConsumer termConsumer;

	public ComplexReconstrTestLanguageOpConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
				ALTERNATIVES$3SUCCESS: while(true) {
					ALTERNATIVES$3FAILURE: {
						GROUP$4SUCCESS: {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								GROUP$5SUCCESS: {
									IMarker mGROUP$5 = mark();
									GROUP$5FAILURE: {
										ACTION$6SUCCESS: {
											consumeAction("Add", "addOperands", true);
											break GROUP$5FAILURE;
										}
									}
									GROUP$5FAILURE: {
										KEYWORD$8SUCCESS: {
											if (!consumeKeyword(getRule().ele1001KeywordPlusSign(), null, false, false))
												break KEYWORD$8SUCCESS;
											break GROUP$5FAILURE;
										}
										mGROUP$5.rollback();
										break GROUP$5SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							GROUP$4FAILURE: {
								ASSIGNMENT$9SUCCESS: {
									ASSIGNMENT$9FAILURE: {
										if (consumeNonTerminal(termConsumer, "addOperands", true, false , getRule().ele1010ParserRuleCallTerm()))
											break ASSIGNMENT$9FAILURE;
										mGROUP$4.rollback();
										break ASSIGNMENT$9SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							break ALTERNATIVES$3FAILURE;
						}
						GROUP$11SUCCESS: {
							IMarker mGROUP$11 = mark();
							GROUP$11FAILURE: {
								GROUP$12SUCCESS: {
									IMarker mGROUP$12 = mark();
									GROUP$12FAILURE: {
										ACTION$13SUCCESS: {
											consumeAction("Minus", "minusOperands", true);
											break GROUP$12FAILURE;
										}
									}
									GROUP$12FAILURE: {
										KEYWORD$15SUCCESS: {
											if (!consumeKeyword(getRule().ele1101KeywordHyphenMinus(), null, false, false))
												break KEYWORD$15SUCCESS;
											break GROUP$12FAILURE;
										}
										mGROUP$12.rollback();
										break GROUP$12SUCCESS;
									}
									break GROUP$11FAILURE;
								}
								mGROUP$11.rollback();
								break GROUP$11SUCCESS;
							}
							GROUP$11FAILURE: {
								ASSIGNMENT$16SUCCESS: {
									ASSIGNMENT$16FAILURE: {
										if (consumeNonTerminal(termConsumer, "minusOperands", true, false , getRule().ele1110ParserRuleCallTerm()))
											break ASSIGNMENT$16FAILURE;
										mGROUP$11.rollback();
										break ASSIGNMENT$16SUCCESS;
									}
									break GROUP$11FAILURE;
								}
								mGROUP$11.rollback();
								break GROUP$11SUCCESS;
							}
							break ALTERNATIVES$3FAILURE;
						}
						break ALTERNATIVES$3SUCCESS;
					}
					continue ALTERNATIVES$3SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public OpElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setTermConsumer(ComplexReconstrTestLanguageTermConsumer termConsumer) {
		this.termConsumer = termConsumer;
	}
	

}
