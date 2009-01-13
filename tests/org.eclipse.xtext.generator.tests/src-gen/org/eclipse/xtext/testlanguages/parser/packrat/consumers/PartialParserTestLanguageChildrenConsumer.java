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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ChildrenElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildConsumer;

public final class PartialParserTestLanguageChildrenConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageChildConsumer childConsumer;

	public PartialParserTestLanguageChildrenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
											if (!consumeKeyword(getRule().ele0000KeywordChildren(), null, false, false))
												break KEYWORD$5SUCCESS;
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									GROUP$4FAILURE: {
										KEYWORD$6SUCCESS: {
											if (!consumeKeyword(getRule().ele0001KeywordLeftCurlyBracket(), null, false, false))
												break KEYWORD$6SUCCESS;
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
								ASSIGNMENT$7SUCCESS: {
									ASSIGNMENT$7FAILURE: {
										if (consumeNonTerminal(childConsumer, "children", true, false , getRule().ele0010ParserRuleCallChild()))
											break ASSIGNMENT$7FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$7SUCCESS;
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
						GROUP$9SUCCESS: while(true) {
							IMarker mGROUP$9 = mark();
							GROUP$9FAILURE: {
								KEYWORD$10SUCCESS: {
									if (!consumeKeyword(getRule().ele010KeywordComma(), null, false, false))
										break KEYWORD$10SUCCESS;
									break GROUP$9FAILURE;
								}
								mGROUP$9.rollback();
								break GROUP$9SUCCESS;
							}
							GROUP$9FAILURE: {
								ASSIGNMENT$11SUCCESS: {
									ASSIGNMENT$11FAILURE: {
										if (consumeNonTerminal(childConsumer, "children", true, false , getRule().ele0110ParserRuleCallChild()))
											break ASSIGNMENT$11FAILURE;
										mGROUP$9.rollback();
										break ASSIGNMENT$11SUCCESS;
									}
									break GROUP$9FAILURE;
								}
								mGROUP$9.rollback();
								break GROUP$9SUCCESS;
							}
							continue GROUP$9SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$13SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$13SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public ChildrenElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Children";
	}
	
	public void setChildConsumer(PartialParserTestLanguageChildConsumer childConsumer) {
		this.childConsumer = childConsumer;
	}
	

}
