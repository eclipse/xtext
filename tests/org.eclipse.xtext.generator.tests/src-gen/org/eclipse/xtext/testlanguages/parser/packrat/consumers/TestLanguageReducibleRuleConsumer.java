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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.ReducibleRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageTerminalRuleConsumer;

public final class TestLanguageReducibleRuleConsumer extends NonTerminalConsumer {

	private TestLanguageTerminalRuleConsumer terminalRuleConsumer;

	public TestLanguageReducibleRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
						KEYWORD$3SUCCESS: {
							if (!consumeKeyword(getRule().ele00KeywordReducible(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						RULECALL$4SUCCESS: {
							if (!consumeNonTerminal(terminalRuleConsumer, null, false, false,  getRule().ele01ParserRuleCallTerminalRule()))
								break RULECALL$4SUCCESS;
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
				GROUP$5SUCCESS: {
					IMarker mGROUP$5 = mark();
					GROUP$5FAILURE: {
						ACTION$6SUCCESS: {
							consumeAction("ReducibleComposite", "actionFeature", true);
							break GROUP$5FAILURE;
						}
					}
					GROUP$5FAILURE: {
						ASSIGNMENT$8SUCCESS: {
							ASSIGNMENT$8FAILURE: {
								if (consumeNonTerminal(terminalRuleConsumer, "actionFeature", true, false , getRule().ele110ParserRuleCallTerminalRule()))
									break ASSIGNMENT$8FAILURE;
								mGROUP$5.rollback();
								break ASSIGNMENT$8SUCCESS;
							}
							break GROUP$5FAILURE;
						}
						mGROUP$5.rollback();
						break GROUP$5SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public ReducibleRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prReducibleRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ReducibleElement";
	}
	
	public void setTerminalRuleConsumer(TestLanguageTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	

}
