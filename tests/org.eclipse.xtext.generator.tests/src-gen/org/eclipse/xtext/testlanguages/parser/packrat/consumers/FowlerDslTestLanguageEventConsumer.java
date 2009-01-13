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
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.EventElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class FowlerDslTestLanguageEventConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public FowlerDslTestLanguageEventConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
								if (consumeKeyword(getRule().ele000KeywordResetting(), "resetting", false, true))
									break ASSIGNMENT$3FAILURE;
								break ASSIGNMENT$3SUCCESS;
							}
							break GROUP$2FAILURE;
						}
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$5SUCCESS: {
							ASSIGNMENT$5FAILURE: {
								if (consumeTerminal(idConsumer, "name", false, false, getRule().ele010LexerRuleCallID()))
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
				ASSIGNMENT$7SUCCESS: {
					ASSIGNMENT$7FAILURE: {
						if (consumeTerminal(idConsumer, "code", false, false, getRule().ele10LexerRuleCallID()))
							break ASSIGNMENT$7FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$7SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public EventElements getRule() {
		return FowlerDslTestLanguageGrammarAccess.INSTANCE.prEvent();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Event";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
