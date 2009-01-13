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
import org.eclipse.xtext.services.XtextGrammarAccess.GroupElements;

import org.eclipse.xtext.parser.packrat.XtextDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTokenConsumer;

@SuppressWarnings("unused")
public final class XtextGroupConsumer extends NonTerminalConsumer {

	private XtextAbstractTokenConsumer abstractTokenConsumer;

	public XtextGroupConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeGroup$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(abstractTokenConsumer, null, false, false, getRule().ele0ParserRuleCallAbstractToken());
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
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
	protected boolean consumeAction$4() {
		consumeAction("Group", "abstractTokens", true);
		return true;	
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeNonTerminal(abstractTokenConsumer, "abstractTokens", true, false, getRule().ele110ParserRuleCallAbstractToken()))
			return true;
		return false;
	}

	public GroupElements getRule() {
		return XtextGrammarAccess.INSTANCE.prGroup();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTokenConsumer(XtextAbstractTokenConsumer abstractTokenConsumer) {
		this.abstractTokenConsumer = abstractTokenConsumer;
	}
	
}
