/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.OpElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.ComplexReconstrTestLanguageDelimiters;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTermConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageOpConsumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageTermConsumer termConsumer;

	public ComplexReconstrTestLanguageOpConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeAlternatives$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(termConsumer, null, false, false, getRule().ele0ParserRuleCallTerm());
	}

	protected boolean consumeAlternatives$3() throws Exception {
		while(doConsumeAlternatives$3()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$3() throws Exception {
		if (consumeGroup$4())
			return true;
		if (consumeGroup$11())
			return true;
		return false;
	}

	protected boolean consumeGroup$4() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$6() {
		consumeAction("Add", "addOperands", true);
		return true;	
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele1001KeywordPlusSign(), null, false, false, ComplexReconstrTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(termConsumer, "addOperands", true, false, getRule().ele1010ParserRuleCallTerm()))
			return true;
		return false;
	}

	protected boolean consumeGroup$11() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$13() {
		consumeAction("Minus", "minusOperands", true);
		return true;	
	}

	protected boolean consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele1101KeywordHyphenMinus(), null, false, false, ComplexReconstrTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeNonTerminal(termConsumer, "minusOperands", true, false, getRule().ele1110ParserRuleCallTerm()))
			return true;
		return false;
	}

	public OpElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prOp();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setTermConsumer(ComplexReconstrTestLanguageTermConsumer termConsumer) {
		this.termConsumer = termConsumer;
	}
	
}
