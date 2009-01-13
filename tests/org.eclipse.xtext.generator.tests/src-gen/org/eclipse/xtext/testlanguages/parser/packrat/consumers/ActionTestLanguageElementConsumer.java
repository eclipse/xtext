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

import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess.ElementElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ActionTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ActionTestLanguageItemConsumer;

@SuppressWarnings("unused")
public final class ActionTestLanguageElementConsumer extends NonTerminalConsumer {

	private ActionTestLanguageItemConsumer itemConsumer;

	public ActionTestLanguageElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeRuleCall$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAction$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(itemConsumer, null, false, false, getRule().ele0ParserRuleCallItem());
	}
	protected boolean consumeAction$4() {
		consumeAction("Item", "items", true);
		return true;	
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeNonTerminal(itemConsumer, "items", true, false, getRule().ele110ParserRuleCallItem()))
			return true;
		return false;
	}

	public ElementElements getRule() {
		return ActionTestLanguageGrammarAccess.INSTANCE.prElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Type";
	}
	
	public void setItemConsumer(ActionTestLanguageItemConsumer itemConsumer) {
		this.itemConsumer = itemConsumer;
	}
	
}
