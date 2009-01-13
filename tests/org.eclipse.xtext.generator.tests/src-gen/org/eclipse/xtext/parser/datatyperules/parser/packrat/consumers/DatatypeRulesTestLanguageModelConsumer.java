/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;

public final class DatatypeRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;
	private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;
	private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
	private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;

	public DatatypeRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
								GROUP$4SUCCESS: {
									IMarker mGROUP$4 = mark();
									GROUP$4FAILURE: {
										ASSIGNMENT$5SUCCESS: {
											ASSIGNMENT$5FAILURE: {
												if (consumeNonTerminal(nestedModelIdConsumer, "id", false, true , getRule().ele00000ParserRuleCallNestedModelId()))
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
										GROUP$7SUCCESS: {
											IMarker mGROUP$7 = mark();
											GROUP$7FAILURE: {
												KEYWORD$8SUCCESS: {
													if (!consumeKeyword(getRule().ele00010KeywordColon(), null, false, false))
														break KEYWORD$8SUCCESS;
													break GROUP$7FAILURE;
												}
												mGROUP$7.rollback();
												break GROUP$7SUCCESS;
											}
											GROUP$7FAILURE: {
												ASSIGNMENT$9SUCCESS: {
													ASSIGNMENT$9FAILURE: {
														if (consumeNonTerminal(fractionConsumer, "value", false, true , getRule().ele000110ParserRuleCallFraction()))
															break ASSIGNMENT$9FAILURE;
														mGROUP$7.rollback();
														break ASSIGNMENT$9SUCCESS;
													}
													break GROUP$7FAILURE;
												}
												mGROUP$7.rollback();
												break GROUP$7SUCCESS;
											}
											break GROUP$4FAILURE;
										}
									}
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								GROUP$11SUCCESS: {
									IMarker mGROUP$11 = mark();
									GROUP$11FAILURE: {
										KEYWORD$12SUCCESS: {
											if (!consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false))
												break KEYWORD$12SUCCESS;
											break GROUP$11FAILURE;
										}
										mGROUP$11.rollback();
										break GROUP$11SUCCESS;
									}
									GROUP$11FAILURE: {
										ASSIGNMENT$13SUCCESS: {
											ASSIGNMENT$13FAILURE: {
												if (consumeNonTerminal(vectorConsumer, "vector", false, true , getRule().ele00110ParserRuleCallVector()))
													break ASSIGNMENT$13FAILURE;
												mGROUP$11.rollback();
												break ASSIGNMENT$13SUCCESS;
											}
											break GROUP$11FAILURE;
										}
										mGROUP$11.rollback();
										break GROUP$11SUCCESS;
									}
									break GROUP$3FAILURE;
								}
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						GROUP$15SUCCESS: {
							IMarker mGROUP$15 = mark();
							GROUP$15FAILURE: {
								KEYWORD$16SUCCESS: {
									if (!consumeKeyword(getRule().ele010KeywordPlusSign(), null, false, false))
										break KEYWORD$16SUCCESS;
									break GROUP$15FAILURE;
								}
								mGROUP$15.rollback();
								break GROUP$15SUCCESS;
							}
							GROUP$15FAILURE: {
								ASSIGNMENT$17SUCCESS: {
									ASSIGNMENT$17FAILURE: {
										if (consumeNonTerminal(dotsConsumer, "dots", false, true , getRule().ele0110ParserRuleCallDots()))
											break ASSIGNMENT$17FAILURE;
										mGROUP$15.rollback();
										break ASSIGNMENT$17SUCCESS;
									}
									break GROUP$15FAILURE;
								}
								mGROUP$15.rollback();
								break GROUP$15SUCCESS;
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
				KEYWORD$19SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false))
						break KEYWORD$19SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public ModelElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setDotsConsumer(DatatypeRulesTestLanguageDotsConsumer dotsConsumer) {
		this.dotsConsumer = dotsConsumer;
	}
	
	public void setVectorConsumer(DatatypeRulesTestLanguageVectorConsumer vectorConsumer) {
		this.vectorConsumer = vectorConsumer;
	}
	
	public void setFractionConsumer(DatatypeRulesTestLanguageFractionConsumer fractionConsumer) {
		this.fractionConsumer = fractionConsumer;
	}
	
	public void setNestedModelIdConsumer(DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer) {
		this.nestedModelIdConsumer = nestedModelIdConsumer;
	}
	

}
