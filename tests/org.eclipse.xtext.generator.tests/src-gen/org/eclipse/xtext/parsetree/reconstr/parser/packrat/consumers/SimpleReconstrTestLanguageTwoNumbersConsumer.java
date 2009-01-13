/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess.TwoNumbersElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

public final class SimpleReconstrTestLanguageTwoNumbersConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;

	public SimpleReconstrTestLanguageTwoNumbersConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
						ASSIGNMENT$3SUCCESS: {
							ASSIGNMENT$3FAILURE: {
								if (consumeTerminal(intConsumer, "num1", false, false, getRule().ele000LexerRuleCallINT()))
									break ASSIGNMENT$3FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$3SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$5SUCCESS: {
							ASSIGNMENT$5FAILURE: {
								if (consumeTerminal(intConsumer, "num2", false, false, getRule().ele010LexerRuleCallINT()))
									break ASSIGNMENT$5FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$5SUCCESS;
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
				GROUP$7SUCCESS: while(true) {
					IMarker mGROUP$7 = mark();
					GROUP$7FAILURE: {
						KEYWORD$8SUCCESS: {
							if (!consumeKeyword(getRule().ele10KeywordNumberSign(), null, false, false))
								break KEYWORD$8SUCCESS;
							break GROUP$7FAILURE;
						}
						mGROUP$7.rollback();
						break GROUP$7SUCCESS;
					}
					GROUP$7FAILURE: {
						ASSIGNMENT$9SUCCESS: {
							ASSIGNMENT$9FAILURE: {
								if (consumeTerminal(intConsumer, "num3", true, false, getRule().ele110LexerRuleCallINT()))
									break ASSIGNMENT$9FAILURE;
								mGROUP$7.rollback();
								break ASSIGNMENT$9SUCCESS;
							}
							break GROUP$7FAILURE;
						}
						mGROUP$7.rollback();
						break GROUP$7SUCCESS;
					}
					continue GROUP$7SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public TwoNumbersElements getRule() {
		return SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prTwoNumbers();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TwoNumbers";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	

}
