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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageRuleCallConsumer;

public final class XtextGrammarTestLanguageAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextGrammarTestLanguageKeywordConsumer keywordConsumer;
	private XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer;
	private XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextGrammarTestLanguageAbstractTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setParenthesizedElementConsumer(XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setKeywordConsumer(XtextGrammarTestLanguageKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setCrossReferenceConsumer(XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setRuleCallConsumer(XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	

}
