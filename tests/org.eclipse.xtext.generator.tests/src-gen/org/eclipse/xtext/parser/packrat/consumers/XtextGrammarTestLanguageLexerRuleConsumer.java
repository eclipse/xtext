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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.LexerRuleElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class XtextGrammarTestLanguageLexerRuleConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageLexerRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												ALTERNATIVES$6SUCCESS: {
													ALTERNATIVES$6FAILURE: {
														KEYWORD$7SUCCESS: {
															if (!consumeKeyword(getRule().ele000000KeywordNative(), null, false, false))
																break KEYWORD$7SUCCESS;
															break ALTERNATIVES$6FAILURE;
														}
														KEYWORD$8SUCCESS: {
															if (!consumeKeyword(getRule().ele000001KeywordLexer(), null, false, false))
																break KEYWORD$8SUCCESS;
															break ALTERNATIVES$6FAILURE;
														}
														mGROUP$5.rollback();
														break ALTERNATIVES$6SUCCESS;
													}
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												ASSIGNMENT$9SUCCESS: {
													ASSIGNMENT$9FAILURE: {
														if (consumeTerminal(idConsumer, "name", false, false, getRule().ele000010LexerRuleCallID()))
															break ASSIGNMENT$9FAILURE;
														mGROUP$5.rollback();
														break ASSIGNMENT$9SUCCESS;
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
										GROUP$11SUCCESS: {
											IMarker mGROUP$11 = mark();
											GROUP$11FAILURE: {
												KEYWORD$12SUCCESS: {
													if (!consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false))
														break KEYWORD$12SUCCESS;
													break GROUP$11FAILURE;
												}
												mGROUP$11.rollback();
												break GROUP$11SUCCESS;
											}
											GROUP$11FAILURE: {
												ASSIGNMENT$13SUCCESS: {
													ASSIGNMENT$13FAILURE: {
														if (consumeNonTerminal(typeRefConsumer, "type", false, false , getRule().ele000110ParserRuleCallTypeRef()))
															break ASSIGNMENT$13FAILURE;
														mGROUP$11.rollback();
														break ASSIGNMENT$13SUCCESS;
													}
													break GROUP$11FAILURE;
												}
												mGROUP$11.rollback();
												break GROUP$11SUCCESS;
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
								KEYWORD$15SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordColon(), null, false, false))
										break KEYWORD$15SUCCESS;
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
						ASSIGNMENT$16SUCCESS: {
							ASSIGNMENT$16FAILURE: {
								if (consumeTerminal(stringConsumer, "body", false, false, getRule().ele010LexerRuleCallSTRING()))
									break ASSIGNMENT$16FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$16SUCCESS;
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
				KEYWORD$18SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false))
						break KEYWORD$18SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public LexerRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prLexerRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LexerRule";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
