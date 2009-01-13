/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AlternativesElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGroupConsumer;

public final class XtextAlternativesConsumer extends NonTerminalConsumer {

	private XtextGroupConsumer groupConsumer;

	public XtextAlternativesConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
					if (!consumeNonTerminal(groupConsumer, null, false, false,  getRule().ele0ParserRuleCallGroup()))
						break RULECALL$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$3SUCCESS: while(true) {
					IMarker mGROUP$3 = mark();
					GROUP$3FAILURE: {
						GROUP$4SUCCESS: {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								ACTION$5SUCCESS: {
									consumeAction("Alternatives", "groups", true);
									break GROUP$4FAILURE;
								}
							}
							GROUP$4FAILURE: {
								KEYWORD$7SUCCESS: {
									if (!consumeKeyword(getRule().ele101KeywordVerticalLine(), null, false, false))
										break KEYWORD$7SUCCESS;
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
						ASSIGNMENT$8SUCCESS: {
							ASSIGNMENT$8FAILURE: {
								if (consumeNonTerminal(groupConsumer, "groups", true, false , getRule().ele110ParserRuleCallGroup()))
									break ASSIGNMENT$8FAILURE;
								mGROUP$3.rollback();
								break ASSIGNMENT$8SUCCESS;
							}
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
					}
					continue GROUP$3SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public AlternativesElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAlternatives();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setGroupConsumer(XtextGroupConsumer groupConsumer) {
		this.groupConsumer = groupConsumer;
	}
	

}
