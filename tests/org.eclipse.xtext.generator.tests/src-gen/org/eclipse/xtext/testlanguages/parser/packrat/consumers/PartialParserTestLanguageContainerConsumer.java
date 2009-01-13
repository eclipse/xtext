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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ContainerElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContentConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNestedConsumer;

public final class PartialParserTestLanguageContainerConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageContentConsumer contentConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private PartialParserTestLanguageNestedConsumer nestedConsumer;

	public PartialParserTestLanguageContainerConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
											if (!consumeKeyword(getRule().ele0000KeywordContainer(), null, false, false))
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
								KEYWORD$8SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false))
										break KEYWORD$8SUCCESS;
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
						ALTERNATIVES$9SUCCESS: while(true) {
							ALTERNATIVES$9FAILURE: {
								ASSIGNMENT$10SUCCESS: {
									ASSIGNMENT$10FAILURE: {
										if (consumeNonTerminal(nestedConsumer, "nested", true, false , getRule().ele0100ParserRuleCallNested()))
											break ASSIGNMENT$10FAILURE;
										break ASSIGNMENT$10SUCCESS;
									}
									break ALTERNATIVES$9FAILURE;
								}
								ASSIGNMENT$12SUCCESS: {
									ASSIGNMENT$12FAILURE: {
										if (consumeNonTerminal(contentConsumer, "content", true, false , getRule().ele0110ParserRuleCallContent()))
											break ASSIGNMENT$12FAILURE;
										break ASSIGNMENT$12SUCCESS;
									}
									break ALTERNATIVES$9FAILURE;
								}
								break ALTERNATIVES$9SUCCESS;
							}
							continue ALTERNATIVES$9SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$14SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
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

	public ContainerElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Container";
	}
	
	public void setContentConsumer(PartialParserTestLanguageContentConsumer contentConsumer) {
		this.contentConsumer = contentConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNestedConsumer(PartialParserTestLanguageNestedConsumer nestedConsumer) {
		this.nestedConsumer = nestedConsumer;
	}
	

}
