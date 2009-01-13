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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.FirstConcreteElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNamedConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class PartialParserTestLanguageFirstConcreteConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageNamedConsumer namedConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public PartialParserTestLanguageFirstConcreteConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												KEYWORD$6SUCCESS: {
													if (!consumeKeyword(getRule().ele00000KeywordHyphenMinusGreaterThanSign(), null, false, false))
														break KEYWORD$6SUCCESS;
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												KEYWORD$7SUCCESS: {
													if (!consumeKeyword(getRule().ele00001KeywordF(), null, false, false))
														break KEYWORD$7SUCCESS;
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
										KEYWORD$8SUCCESS: {
											if (!consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false))
												break KEYWORD$8SUCCESS;
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
								ASSIGNMENT$9SUCCESS: {
									ASSIGNMENT$9FAILURE: {
										if (consumeNonTerminal(namedConsumer, "value", false, false , getRule().ele0010ParserRuleCallNamed()))
											break ASSIGNMENT$9FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$9SUCCESS;
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
						ASSIGNMENT$11SUCCESS: {
							ASSIGNMENT$11FAILURE: {
								if (consumeTerminal(idConsumer, null, false, false, getRule().ele010CrossReferenceEStringContainer()))
									break ASSIGNMENT$11FAILURE;
								break ASSIGNMENT$11SUCCESS;
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
				KEYWORD$14SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false))
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

	public FirstConcreteElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "FirstConcrete";
	}
	
	public void setNamedConsumer(PartialParserTestLanguageNamedConsumer namedConsumer) {
		this.namedConsumer = namedConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
