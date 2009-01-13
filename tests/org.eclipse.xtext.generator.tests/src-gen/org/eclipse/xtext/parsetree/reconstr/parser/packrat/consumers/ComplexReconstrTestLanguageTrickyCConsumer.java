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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyCElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.ComplexReconstrTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyCConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyCConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeGroup$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTC(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$8() throws Exception {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$9() {
		consumeAction("C1", "x", false);
		return true;	
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0011KeywordX(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeGroup$12() throws Exception {
		doConsumeGroup$12();
		return true;
	}

	protected boolean doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$15()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$13() {
		consumeAction("C2", "y", false);
		return true;	
	}

	protected boolean consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele011KeywordY(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeGroup$16() throws Exception {
		doConsumeGroup$16();
		return true;
	}

	protected boolean doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$17()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$17() {
		consumeAction("C3", "z", false);
		return true;	
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele11KeywordZ(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	public TrickyCElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyC";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
