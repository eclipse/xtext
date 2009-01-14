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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AssignmentElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAssignmentConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageAssignmentConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele000LexerRuleCallID(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeKeyword(getRule().ele01000KeywordPlusSignEqualsSign(), "operator", false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele01001KeywordEqualsSign(), "operator", false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele0101KeywordQuestionMarkEqualsSign(), "operator", false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeNonTerminal(abstractTerminalConsumer, "terminal", false, false, getRule().ele10ParserRuleCallAbstractTerminal()))
			return true;
		return false;
	}

	public AssignmentElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAssignment();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Assignment";
	}
	
	public void setAbstractTerminalConsumer(XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
