/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.ActionElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTypeRefConsumer;

public final class XtextActionConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextTypeRefConsumer typeRefConsumer;

	public XtextActionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
																	if (!consumeKeyword(getRule().ele0000000KeywordLeftCurlyBracket(), null, false, false))
																		break KEYWORD$8SUCCESS;
																	break GROUP$7FAILURE;
																}
																mGROUP$7.rollback();
																break GROUP$7SUCCESS;
															}
															GROUP$7FAILURE: {
																GROUP$9SUCCESS: {
																	IMarker mGROUP$9 = mark();
																	GROUP$9FAILURE: {
																		KEYWORD$10SUCCESS: {
																			if (!consumeKeyword(getRule().ele00000010KeywordCurrent(), null, false, false))
																				break KEYWORD$10SUCCESS;
																			break GROUP$9FAILURE;
																		}
																		mGROUP$9.rollback();
																		break GROUP$9SUCCESS;
																	}
																	GROUP$9FAILURE: {
																		KEYWORD$11SUCCESS: {
																			if (!consumeKeyword(getRule().ele00000011KeywordEqualsSign(), null, false, false))
																				break KEYWORD$11SUCCESS;
																			break GROUP$9FAILURE;
																		}
																		mGROUP$9.rollback();
																		break GROUP$9SUCCESS;
																	}
																	break GROUP$7FAILURE;
																}
															}
															break GROUP$6FAILURE;
														}
														mGROUP$6.rollback();
														break GROUP$6SUCCESS;
													}
													GROUP$6FAILURE: {
														ASSIGNMENT$12SUCCESS: {
															ASSIGNMENT$12FAILURE: {
																if (consumeNonTerminal(typeRefConsumer, "typeName", false, false , getRule().ele0000010ParserRuleCallTypeRef()))
																	break ASSIGNMENT$12FAILURE;
																mGROUP$6.rollback();
																break ASSIGNMENT$12SUCCESS;
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
												KEYWORD$14SUCCESS: {
													if (!consumeKeyword(getRule().ele00001KeywordFullStop(), null, false, false))
														break KEYWORD$14SUCCESS;
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
										ASSIGNMENT$15SUCCESS: {
											ASSIGNMENT$15FAILURE: {
												if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele00010LexerRuleCallID()))
													break ASSIGNMENT$15FAILURE;
												mGROUP$4.rollback();
												break ASSIGNMENT$15SUCCESS;
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
								ASSIGNMENT$17SUCCESS: {
									ASSIGNMENT$17FAILURE: {
										if (consumeKeyword(getRule().ele00100KeywordEqualsSign(), "operator", false, false))
											break ASSIGNMENT$17FAILURE;
										if (consumeKeyword(getRule().ele00101KeywordPlusSignEqualsSign(), "operator", false, false))
											break ASSIGNMENT$17FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$17SUCCESS;
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
						KEYWORD$21SUCCESS: {
							if (!consumeKeyword(getRule().ele01KeywordCurrent(), null, false, false))
								break KEYWORD$21SUCCESS;
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
				KEYWORD$22SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$22SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public ActionElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAction();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Action";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	

}
