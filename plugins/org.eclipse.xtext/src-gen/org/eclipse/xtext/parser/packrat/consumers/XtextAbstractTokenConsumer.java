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
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTokenElements;

import org.eclipse.xtext.parser.packrat.XtextDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextActionConsumer;

@SuppressWarnings("unused")
public final class XtextAbstractTokenConsumer extends NonTerminalConsumer {

	private XtextAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextAssignmentConsumer assignmentConsumer;
	private XtextActionConsumer actionConsumer;

	public XtextAbstractTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$2() throws Exception {
		if (consumeRuleCall$4())
			return true;
		if (consumeRuleCall$5())
			return true;
		if (consumeRuleCall$6())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(assignmentConsumer, null, false, false, getRule().ele000ParserRuleCallAssignment());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(actionConsumer, null, false, false, getRule().ele001ParserRuleCallAction());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(abstractTerminalConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractTerminal());
	}

	protected boolean consumeAssignment$7() throws Exception {
		doConsumeAssignment$7();
		return true;
	}

	protected boolean doConsumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false, XtextDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false, XtextDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false, XtextDelimiters.ANY_OTHER_DELIMITER))
			return true;
		return false;
	}

	public AbstractTokenElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAbstractToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTerminalConsumer(XtextAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setAssignmentConsumer(XtextAssignmentConsumer assignmentConsumer) {
		this.assignmentConsumer = assignmentConsumer;
	}
	
	public void setActionConsumer(XtextActionConsumer actionConsumer) {
		this.actionConsumer = actionConsumer;
	}
	
}
