/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.FractionElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

public final class DatatypeRulesTestLanguageFractionConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;

	public DatatypeRulesTestLanguageFractionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeTerminal(intConsumer, null, false, false,  getRule().ele0LexerRuleCallINT()))
						break RULECALL$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$3SUCCESS: {
					IMarker mGROUP$3 = mark();
					GROUP$3FAILURE: {
						KEYWORD$4SUCCESS: {
							if (!consumeKeyword(getRule().ele10KeywordSolidus(), null, false, false))
								break KEYWORD$4SUCCESS;
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
					}
					GROUP$3FAILURE: {
						RULECALL$5SUCCESS: {
							if (!consumeTerminal(intConsumer, null, false, false,  getRule().ele11LexerRuleCallINT()))
								break RULECALL$5SUCCESS;
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public FractionElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prFraction();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EBigDecimal";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	

}
