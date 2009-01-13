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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.NestedElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContainerConsumer;

public final class PartialParserTestLanguageNestedConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageContainerConsumer containerConsumer;

	public PartialParserTestLanguageNestedConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
								KEYWORD$4SUCCESS: {
									if (!consumeKeyword(getRule().ele000KeywordNested(), null, false, false))
										break KEYWORD$4SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								KEYWORD$5SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false))
										break KEYWORD$5SUCCESS;
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
						ASSIGNMENT$6SUCCESS: {
							ASSIGNMENT$6FAILURE: {
								if (!consumeNonTerminal(containerConsumer, "nested", true, false , getRule().ele010ParserRuleCallContainer()))
									break ASSIGNMENT$6SUCCESS;
								while(consumeNonTerminal(containerConsumer, "nested", true, false , getRule().ele010ParserRuleCallContainer()));
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
				KEYWORD$8SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$8SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public NestedElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Nested";
	}
	
	public void setContainerConsumer(PartialParserTestLanguageContainerConsumer containerConsumer) {
		this.containerConsumer = containerConsumer;
	}
	

}
