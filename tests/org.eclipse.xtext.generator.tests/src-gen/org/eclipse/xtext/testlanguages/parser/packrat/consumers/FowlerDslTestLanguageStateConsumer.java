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

import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.StateElements;

import org.eclipse.xtext.testlanguages.parser.packrat.FowlerDslTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageTransitionConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTestLanguageStateConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private FowlerDslTestLanguageTransitionConsumer transitionConsumer;

	public FowlerDslTestLanguageStateConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordState(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), FowlerDslTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$8() throws Exception {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele001000KeywordActions(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele001001KeywordLeftCurlyBracket(), null, false, false, FowlerDslTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (doConsumeAssignment$13()) {
			while(doConsumeAssignment$13()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$13() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele001010CrossReferenceEStringCommand(), FowlerDslTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele0011KeywordRightCurlyBracket(), null, false, false, FowlerDslTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$17() throws Exception {
		while(doConsumeAssignment$17()) {}
		return true;
	}

	protected boolean doConsumeAssignment$17() throws Exception {
		if (consumeNonTerminal(transitionConsumer, "transitions", true, false, getRule().ele010ParserRuleCallTransition()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele1KeywordEnd(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	public StateElements getRule() {
		return FowlerDslTestLanguageGrammarAccess.INSTANCE.prState();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "State";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTransitionConsumer(FowlerDslTestLanguageTransitionConsumer transitionConsumer) {
		this.transitionConsumer = transitionConsumer;
	}
	
}
