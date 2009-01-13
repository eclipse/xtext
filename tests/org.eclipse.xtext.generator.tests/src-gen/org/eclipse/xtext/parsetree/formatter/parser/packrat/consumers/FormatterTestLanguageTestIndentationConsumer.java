/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.TestIndentationElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageLineConsumer;
import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestIndentationConsumer;

public final class FormatterTestLanguageTestIndentationConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageLineConsumer lineConsumer;
	private FormatterTestLanguageTestIndentationConsumer testIndentationConsumer;

	public FormatterTestLanguageTestIndentationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
									if (!consumeKeyword(getRule().ele000KeywordIndentation(), null, false, false))
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
						ALTERNATIVES$6SUCCESS: while(true) {
							ALTERNATIVES$6FAILURE: {
								ASSIGNMENT$7SUCCESS: {
									ASSIGNMENT$7FAILURE: {
										if (consumeNonTerminal(testIndentationConsumer, "sub", true, false , getRule().ele0100ParserRuleCallTestIndentation()))
											break ASSIGNMENT$7FAILURE;
										break ASSIGNMENT$7SUCCESS;
									}
									break ALTERNATIVES$6FAILURE;
								}
								ASSIGNMENT$9SUCCESS: {
									ASSIGNMENT$9FAILURE: {
										if (consumeNonTerminal(lineConsumer, "items", true, false , getRule().ele0110ParserRuleCallLine()))
											break ASSIGNMENT$9FAILURE;
										break ASSIGNMENT$9SUCCESS;
									}
									break ALTERNATIVES$6FAILURE;
								}
								break ALTERNATIVES$6SUCCESS;
							}
							continue ALTERNATIVES$6SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$11SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$11SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public TestIndentationElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestIndentation";
	}
	
	public void setLineConsumer(FormatterTestLanguageLineConsumer lineConsumer) {
		this.lineConsumer = lineConsumer;
	}
	
	public void setTestIndentationConsumer(FormatterTestLanguageTestIndentationConsumer testIndentationConsumer) {
		this.testIndentationConsumer = testIndentationConsumer;
	}
	

}
