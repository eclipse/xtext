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

import org.eclipse.xtext.testlanguages.parser.packrat.ContentAssistTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageSecondAbstractRuleChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageFirstAbstractRuleChildConsumer;

@SuppressWarnings("unused")
public final class ContentAssistTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private ContentAssistTestLanguageSecondAbstractRuleChildConsumer secondAbstractRuleChildConsumer;
	private ContentAssistTestLanguageFirstAbstractRuleChildConsumer firstAbstractRuleChildConsumer;

	public ContentAssistTestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(firstAbstractRuleChildConsumer, null, false, false, getRule().ele0ParserRuleCallFirstAbstractRuleChild());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(secondAbstractRuleChildConsumer, null, false, false, getRule().ele1ParserRuleCallSecondAbstractRuleChild());
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
	
	public void setSecondAbstractRuleChildConsumer(ContentAssistTestLanguageSecondAbstractRuleChildConsumer secondAbstractRuleChildConsumer) {
		this.secondAbstractRuleChildConsumer = secondAbstractRuleChildConsumer;
	}
	
	public void setFirstAbstractRuleChildConsumer(ContentAssistTestLanguageFirstAbstractRuleChildConsumer firstAbstractRuleChildConsumer) {
		this.firstAbstractRuleChildConsumer = firstAbstractRuleChildConsumer;
	}
	
}
