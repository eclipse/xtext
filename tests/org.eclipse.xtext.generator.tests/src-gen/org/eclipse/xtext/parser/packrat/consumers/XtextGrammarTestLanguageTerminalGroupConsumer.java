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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TerminalGroupElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalTokenConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTerminalGroupConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageTerminalTokenConsumer terminalTokenConsumer;

	public XtextGrammarTestLanguageTerminalGroupConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
			marker.release();
			return false;
		}
		if (!consumeGroup$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(terminalTokenConsumer, null, false, false, getRule().ele0ParserRuleCallTerminalToken());
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$4()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}
	protected boolean consumeAction$4() {
		consumeAction("Group", "abstractTokens", true);
		return true;	
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeNonTerminal(terminalTokenConsumer, "abstractTokens", true, false, getRule().ele110ParserRuleCallTerminalToken()))
			return true;
		return false;
	}

	public TerminalGroupElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTerminalGroup();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalTokenConsumer(XtextGrammarTestLanguageTerminalTokenConsumer terminalTokenConsumer) {
		this.terminalTokenConsumer = terminalTokenConsumer;
	}
	
}
