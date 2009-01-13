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
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess.GreetingElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class OptionalEmptyTestLanguageGreetingConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public OptionalEmptyTestLanguageGreetingConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				KEYWORD$2SUCCESS: {
					if (!consumeKeyword(getRule().ele0KeywordHallo(), null, false, false))
						break KEYWORD$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$3SUCCESS: {
					ASSIGNMENT$3FAILURE: {
						if (consumeTerminal(idConsumer, "name", false, false, getRule().ele10LexerRuleCallID()))
							break ASSIGNMENT$3FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$3SUCCESS;
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

	public GreetingElements getRule() {
		return OptionalEmptyTestLanguageGrammarAccess.INSTANCE.prGreeting();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Greeting";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
