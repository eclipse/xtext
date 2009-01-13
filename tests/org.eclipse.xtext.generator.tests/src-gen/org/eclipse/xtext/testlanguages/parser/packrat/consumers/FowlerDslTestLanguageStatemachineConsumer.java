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
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.StatemachineElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageCommandConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageStateConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageEventConsumer;

public final class FowlerDslTestLanguageStatemachineConsumer extends NonTerminalConsumer {

	private FowlerDslTestLanguageCommandConsumer commandConsumer;
	private FowlerDslTestLanguageStateConsumer stateConsumer;
	private FowlerDslTestLanguageEventConsumer eventConsumer;

	public FowlerDslTestLanguageStatemachineConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
										GROUP$5SUCCESS: {
											IMarker mGROUP$5 = mark();
											GROUP$5FAILURE: {
												GROUP$6SUCCESS: {
													IMarker mGROUP$6 = mark();
													GROUP$6FAILURE: {
														KEYWORD$7SUCCESS: {
															if (!consumeKeyword(getRule().ele000000KeywordEvents(), null, false, false))
																break KEYWORD$7SUCCESS;
															break GROUP$6FAILURE;
														}
														mGROUP$6.rollback();
														break GROUP$6SUCCESS;
													}
													GROUP$6FAILURE: {
														ASSIGNMENT$8SUCCESS: while(true) {
															ASSIGNMENT$8FAILURE: {
																if (consumeNonTerminal(eventConsumer, "events", true, false , getRule().ele0000010ParserRuleCallEvent()))
																	break ASSIGNMENT$8FAILURE;
																break ASSIGNMENT$8SUCCESS;
															}
															continue ASSIGNMENT$8SUCCESS;
														}
													}
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												KEYWORD$10SUCCESS: {
													if (!consumeKeyword(getRule().ele00001KeywordEnd(), null, false, false))
														break KEYWORD$10SUCCESS;
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
										KEYWORD$11SUCCESS: {
											if (!consumeKeyword(getRule().ele0001KeywordCommands(), null, false, false))
												break KEYWORD$11SUCCESS;
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
								ASSIGNMENT$12SUCCESS: while(true) {
									ASSIGNMENT$12FAILURE: {
										if (consumeNonTerminal(commandConsumer, "commands", true, false , getRule().ele0010ParserRuleCallCommand()))
											break ASSIGNMENT$12FAILURE;
										break ASSIGNMENT$12SUCCESS;
									}
									continue ASSIGNMENT$12SUCCESS;
								}
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						KEYWORD$14SUCCESS: {
							if (!consumeKeyword(getRule().ele01KeywordEnd(), null, false, false))
								break KEYWORD$14SUCCESS;
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
				ASSIGNMENT$15SUCCESS: while(true) {
					ASSIGNMENT$15FAILURE: {
						if (consumeNonTerminal(stateConsumer, "states", true, false , getRule().ele10ParserRuleCallState()))
							break ASSIGNMENT$15FAILURE;
						break ASSIGNMENT$15SUCCESS;
					}
					continue ASSIGNMENT$15SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public StatemachineElements getRule() {
		return FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Statemachine";
	}
	
	public void setCommandConsumer(FowlerDslTestLanguageCommandConsumer commandConsumer) {
		this.commandConsumer = commandConsumer;
	}
	
	public void setStateConsumer(FowlerDslTestLanguageStateConsumer stateConsumer) {
		this.stateConsumer = stateConsumer;
	}
	
	public void setEventConsumer(FowlerDslTestLanguageEventConsumer eventConsumer) {
		this.eventConsumer = eventConsumer;
	}
	

}
