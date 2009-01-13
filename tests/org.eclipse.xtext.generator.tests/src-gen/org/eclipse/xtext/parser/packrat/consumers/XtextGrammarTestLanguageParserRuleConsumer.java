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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.ParserRuleElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class XtextGrammarTestLanguageParserRuleConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000LexerRuleCallID()))
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
													if (!consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false))
														break KEYWORD$8SUCCESS;
													break GROUP$7FAILURE;
												}
												mGROUP$7.rollback();
												break GROUP$7SUCCESS;
											}
											GROUP$7FAILURE: {
												ASSIGNMENT$9SUCCESS: {
													ASSIGNMENT$9FAILURE: {
														if (consumeNonTerminal(typeRefConsumer, "type", false, false , getRule().ele000110ParserRuleCallTypeRef()))
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
								KEYWORD$11SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordColon(), null, false, false))
										break KEYWORD$11SUCCESS;
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
						ASSIGNMENT$12SUCCESS: {
							ASSIGNMENT$12FAILURE: {
								if (consumeNonTerminal(alternativesConsumer, "alternatives", false, false , getRule().ele010ParserRuleCallAlternatives()))
									break ASSIGNMENT$12FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$12SUCCESS;
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
				KEYWORD$14SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false))
						break KEYWORD$14SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public ParserRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prParserRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ParserRule";
	}
	
	public void setAlternativesConsumer(XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer) {
		this.alternativesConsumer = alternativesConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
