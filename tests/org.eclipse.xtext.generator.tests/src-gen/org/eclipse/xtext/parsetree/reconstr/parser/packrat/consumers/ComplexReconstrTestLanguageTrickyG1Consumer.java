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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyG1Elements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG2Consumer;

public final class ComplexReconstrTestLanguageTrickyG1Consumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer;

	public ComplexReconstrTestLanguageTrickyG1Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
						KEYWORD$3SUCCESS: {
							if (!consumeKeyword(getRule().ele00KeywordLeftSquareBracket(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						GROUP$4SUCCESS: {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeNonTerminal(trickyG2Consumer, "vals", true, false , getRule().ele0100ParserRuleCallTrickyG2()))
											break ASSIGNMENT$5FAILURE;
										mGROUP$4.rollback();
										break ASSIGNMENT$5SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							GROUP$4FAILURE: {
								GROUP$7SUCCESS: while(true) {
									IMarker mGROUP$7 = mark();
									GROUP$7FAILURE: {
										KEYWORD$8SUCCESS: {
											if (!consumeKeyword(getRule().ele0110KeywordComma(), null, false, false))
												break KEYWORD$8SUCCESS;
											break GROUP$7FAILURE;
										}
										mGROUP$7.rollback();
										break GROUP$7SUCCESS;
									}
									GROUP$7FAILURE: {
										ASSIGNMENT$9SUCCESS: {
											ASSIGNMENT$9FAILURE: {
												if (consumeNonTerminal(trickyG2Consumer, "vals", true, false , getRule().ele01110ParserRuleCallTrickyG2()))
													break ASSIGNMENT$9FAILURE;
												mGROUP$7.rollback();
												break ASSIGNMENT$9SUCCESS;
											}
											break GROUP$7FAILURE;
										}
										mGROUP$7.rollback();
										break GROUP$7SUCCESS;
									}
									continue GROUP$7SUCCESS;
								}
							}
							break GROUP$2FAILURE;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$11SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightSquareBracket(), null, false, false))
						break KEYWORD$11SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public TrickyG1Elements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyG1";
	}
	
	public void setTrickyG2Consumer(ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer) {
		this.trickyG2Consumer = trickyG2Consumer;
	}
	

}
