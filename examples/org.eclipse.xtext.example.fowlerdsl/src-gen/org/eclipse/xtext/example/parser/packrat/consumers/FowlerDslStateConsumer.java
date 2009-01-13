/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess.StateElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslTransitionConsumer;

public final class FowlerDslStateConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private FowlerDslTransitionConsumer transitionConsumer;

	public FowlerDslStateConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
										KEYWORD$5SUCCESS: {
											if (!consumeKeyword(getRule().ele0000KeywordState(), null, false, false))
												break KEYWORD$5SUCCESS;
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									GROUP$4FAILURE: {
										ASSIGNMENT$6SUCCESS: {
											ASSIGNMENT$6FAILURE: {
												if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID()))
													break ASSIGNMENT$6FAILURE;
												mGROUP$4.rollback();
												break ASSIGNMENT$6SUCCESS;
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
								GROUP$8SUCCESS: {
									IMarker mGROUP$8 = mark();
									GROUP$8FAILURE: {
										GROUP$9SUCCESS: {
											IMarker mGROUP$9 = mark();
											GROUP$9FAILURE: {
												GROUP$10SUCCESS: {
													IMarker mGROUP$10 = mark();
													GROUP$10FAILURE: {
														KEYWORD$11SUCCESS: {
															if (!consumeKeyword(getRule().ele001000KeywordActions(), null, false, false))
																break KEYWORD$11SUCCESS;
															break GROUP$10FAILURE;
														}
														mGROUP$10.rollback();
														break GROUP$10SUCCESS;
													}
													GROUP$10FAILURE: {
														KEYWORD$12SUCCESS: {
															if (!consumeKeyword(getRule().ele001001KeywordLeftCurlyBracket(), null, false, false))
																break KEYWORD$12SUCCESS;
															break GROUP$10FAILURE;
														}
														mGROUP$10.rollback();
														break GROUP$10SUCCESS;
													}
													break GROUP$9FAILURE;
												}
												mGROUP$9.rollback();
												break GROUP$9SUCCESS;
											}
											GROUP$9FAILURE: {
												ASSIGNMENT$13SUCCESS: {
													ASSIGNMENT$13FAILURE: {
														if (!consumeTerminal(idConsumer, null, true, false, getRule().ele001010CrossReferenceEStringCommand()))
															break ASSIGNMENT$13SUCCESS;
														while(consumeTerminal(idConsumer, null, true, false, getRule().ele001010CrossReferenceEStringCommand()));
													}
													break GROUP$9FAILURE;
												}
												mGROUP$9.rollback();
												break GROUP$9SUCCESS;
											}
											break GROUP$8FAILURE;
										}
										mGROUP$8.rollback();
										break GROUP$8SUCCESS;
									}
									GROUP$8FAILURE: {
										KEYWORD$16SUCCESS: {
											if (!consumeKeyword(getRule().ele0011KeywordRightCurlyBracket(), null, false, false))
												break KEYWORD$16SUCCESS;
											break GROUP$8FAILURE;
										}
										mGROUP$8.rollback();
										break GROUP$8SUCCESS;
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
						ASSIGNMENT$17SUCCESS: while(true) {
							ASSIGNMENT$17FAILURE: {
								if (consumeNonTerminal(transitionConsumer, "transitions", true, false , getRule().ele010ParserRuleCallTransition()))
									break ASSIGNMENT$17FAILURE;
								break ASSIGNMENT$17SUCCESS;
							}
							continue ASSIGNMENT$17SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$19SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordEnd(), null, false, false))
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

	public StateElements getRule() {
		return FowlerDslGrammarAccess.INSTANCE.prState();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "State";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTransitionConsumer(FowlerDslTransitionConsumer transitionConsumer) {
		this.transitionConsumer = transitionConsumer;
	}
	

}
