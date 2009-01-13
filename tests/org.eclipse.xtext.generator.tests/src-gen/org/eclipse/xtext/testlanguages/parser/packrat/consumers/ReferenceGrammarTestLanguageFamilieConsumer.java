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
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.FamilieElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ReferenceGrammarTestLanguageFamilieConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ReferenceGrammarTestLanguageFamilieConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
														GROUP$7SUCCESS: {
															IMarker mGROUP$7 = mark();
															GROUP$7FAILURE: {
																KEYWORD$8SUCCESS: {
																	if (!consumeKeyword(getRule().ele0000000KeywordFamilie(), null, false, false))
																		break KEYWORD$8SUCCESS;
																	break GROUP$7FAILURE;
																}
																mGROUP$7.rollback();
																break GROUP$7SUCCESS;
															}
															GROUP$7FAILURE: {
																KEYWORD$9SUCCESS: {
																	if (!consumeKeyword(getRule().ele0000001KeywordLeftParenthesis(), null, false, false))
																		break KEYWORD$9SUCCESS;
																	break GROUP$7FAILURE;
																}
																mGROUP$7.rollback();
																break GROUP$7SUCCESS;
															}
															break GROUP$6FAILURE;
														}
														mGROUP$6.rollback();
														break GROUP$6SUCCESS;
													}
													GROUP$6FAILURE: {
														ASSIGNMENT$10SUCCESS: {
															ASSIGNMENT$10FAILURE: {
																if (consumeKeyword(getRule().ele000001000KeywordKeyword(), "name", false, false))
																	break ASSIGNMENT$10FAILURE;
																if (consumeTerminal(stringConsumer, "name", false, false, getRule().ele000001001LexerRuleCallSTRING()))
																	break ASSIGNMENT$10FAILURE;
																if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000101LexerRuleCallID()))
																	break ASSIGNMENT$10FAILURE;
																mGROUP$6.rollback();
																break ASSIGNMENT$10SUCCESS;
															}
															break GROUP$6FAILURE;
														}
														mGROUP$6.rollback();
														break GROUP$6SUCCESS;
													}
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												ASSIGNMENT$16SUCCESS: {
													ASSIGNMENT$16FAILURE: {
														if (consumeTerminal(idConsumer, null, false, false, getRule().ele000010CrossReferenceEStringErwachsener()))
															break ASSIGNMENT$16FAILURE;
														mGROUP$5.rollback();
														break ASSIGNMENT$16SUCCESS;
													}
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
										ASSIGNMENT$19SUCCESS: {
											ASSIGNMENT$19FAILURE: {
												if (consumeTerminal(idConsumer, null, false, false, getRule().ele00010CrossReferenceEStringErwachsener()))
													break ASSIGNMENT$19FAILURE;
												mGROUP$4.rollback();
												break ASSIGNMENT$19SUCCESS;
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
								ASSIGNMENT$22SUCCESS: {
									ASSIGNMENT$22FAILURE: {
										if (consumeTerminal(idConsumer, null, true, false, getRule().ele0010CrossReferenceEStringKind()))
											break ASSIGNMENT$22FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$22SUCCESS;
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
						GROUP$25SUCCESS: while(true) {
							IMarker mGROUP$25 = mark();
							GROUP$25FAILURE: {
								KEYWORD$26SUCCESS: {
									if (!consumeKeyword(getRule().ele010KeywordComma(), null, false, false))
										break KEYWORD$26SUCCESS;
									break GROUP$25FAILURE;
								}
								mGROUP$25.rollback();
								break GROUP$25SUCCESS;
							}
							GROUP$25FAILURE: {
								ASSIGNMENT$27SUCCESS: {
									ASSIGNMENT$27FAILURE: {
										if (consumeTerminal(idConsumer, null, true, false, getRule().ele0110CrossReferenceEStringKind()))
											break ASSIGNMENT$27FAILURE;
										mGROUP$25.rollback();
										break ASSIGNMENT$27SUCCESS;
									}
									break GROUP$25FAILURE;
								}
								mGROUP$25.rollback();
								break GROUP$25SUCCESS;
							}
							continue GROUP$25SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$30SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false))
						break KEYWORD$30SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public FamilieElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prFamilie();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Familie";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
