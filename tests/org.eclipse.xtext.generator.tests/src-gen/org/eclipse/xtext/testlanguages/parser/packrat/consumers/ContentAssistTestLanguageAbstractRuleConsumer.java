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
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageFirstAbstractRuleChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageSecondAbstractRuleChildConsumer;

public final class ContentAssistTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private ContentAssistTestLanguageFirstAbstractRuleChildConsumer firstAbstractRuleChildConsumer;
	private ContentAssistTestLanguageSecondAbstractRuleChildConsumer secondAbstractRuleChildConsumer;

	public ContentAssistTestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(firstAbstractRuleChildConsumer, null, false, false,  getRule().ele0ParserRuleCallFirstAbstractRuleChild()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(secondAbstractRuleChildConsumer, null, false, false,  getRule().ele1ParserRuleCallSecondAbstractRuleChild()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public AbstractRuleElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setFirstAbstractRuleChildConsumer(ContentAssistTestLanguageFirstAbstractRuleChildConsumer firstAbstractRuleChildConsumer) {
		this.firstAbstractRuleChildConsumer = firstAbstractRuleChildConsumer;
	}
	
	public void setSecondAbstractRuleChildConsumer(ContentAssistTestLanguageSecondAbstractRuleChildConsumer secondAbstractRuleChildConsumer) {
		this.secondAbstractRuleChildConsumer = secondAbstractRuleChildConsumer;
	}
	

}
