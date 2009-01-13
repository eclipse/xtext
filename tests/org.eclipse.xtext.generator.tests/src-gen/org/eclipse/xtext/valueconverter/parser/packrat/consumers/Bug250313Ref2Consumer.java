/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.Ref2Elements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

public final class Bug250313Ref2Consumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	public Bug250313Ref2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
					if (!consumeKeyword(getRule().ele0KeywordNumberSignDigitTwo(), null, false, false))
						break KEYWORD$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$3SUCCESS: {
					ASSIGNMENT$3FAILURE: {
						if (consumeKeyword(getRule().ele1000KeywordMykeyword1(), "ref2", false, false))
							break ASSIGNMENT$3FAILURE;
						if (consumeTerminal(stringConsumer, "ref2", false, false, getRule().ele1001LexerRuleCallSTRING()))
							break ASSIGNMENT$3FAILURE;
						if (consumeTerminal(idConsumer, "ref2", false, false, getRule().ele101LexerRuleCallID()))
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

	public Ref2Elements getRule() {
		return Bug250313GrammarAccess.INSTANCE.prRef2();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Ref2";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	

}
