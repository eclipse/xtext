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
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextRuleCallConsumer;

public final class XtextAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextKeywordConsumer keywordConsumer;
	private XtextCrossReferenceConsumer crossReferenceConsumer;
	private XtextParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextRuleCallConsumer ruleCallConsumer;

	public XtextAbstractTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				ALTERNATIVES$2SUCCESS: {
					ALTERNATIVES$2FAILURE: {
						ALTERNATIVES$3SUCCESS: {
							ALTERNATIVES$3FAILURE: {
								RULECALL$4SUCCESS: {
									if (!consumeNonTerminal(keywordConsumer, null, false, false,  getRule().ele000ParserRuleCallKeyword()))
										break RULECALL$4SUCCESS;
									break ALTERNATIVES$3FAILURE;
								}
								RULECALL$5SUCCESS: {
									if (!consumeNonTerminal(ruleCallConsumer, null, false, false,  getRule().ele001ParserRuleCallRuleCall()))
										break RULECALL$5SUCCESS;
									break ALTERNATIVES$3FAILURE;
								}
								break ALTERNATIVES$3SUCCESS;
							}
							break ALTERNATIVES$2FAILURE;
						}
						RULECALL$6SUCCESS: {
							if (!consumeNonTerminal(parenthesizedElementConsumer, null, false, false,  getRule().ele01ParserRuleCallParenthesizedElement()))
								break RULECALL$6SUCCESS;
							break ALTERNATIVES$2FAILURE;
						}
						break ALTERNATIVES$2SUCCESS;
					}
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$7SUCCESS: {
					if (!consumeNonTerminal(crossReferenceConsumer, null, false, false,  getRule().ele1ParserRuleCallCrossReference()))
						break RULECALL$7SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public AbstractTerminalElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setKeywordConsumer(XtextKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setCrossReferenceConsumer(XtextCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setParenthesizedElementConsumer(XtextParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	

}
