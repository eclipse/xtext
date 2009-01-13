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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.GroupElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTokenConsumer;

public final class XtextGrammarTestLanguageGroupConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAbstractTokenConsumer abstractTokenConsumer;

	public XtextGrammarTestLanguageGroupConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
					if (!consumeNonTerminal(abstractTokenConsumer, null, false, false,  getRule().ele0ParserRuleCallAbstractToken()))
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
						ACTION$4SUCCESS: {
							consumeAction("Group", "abstractTokens", true);
							break GROUP$3FAILURE;
						}
					}
					GROUP$3FAILURE: {
						ASSIGNMENT$6SUCCESS: {
							ASSIGNMENT$6FAILURE: {
								if (consumeNonTerminal(abstractTokenConsumer, "abstractTokens", true, false , getRule().ele110ParserRuleCallAbstractToken()))
									break ASSIGNMENT$6FAILURE;
								mGROUP$3.rollback();
								break ASSIGNMENT$6SUCCESS;
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

	public GroupElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prGroup();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTokenConsumer(XtextGrammarTestLanguageAbstractTokenConsumer abstractTokenConsumer) {
		this.abstractTokenConsumer = abstractTokenConsumer;
	}
	

}
