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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyEElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.ComplexReconstrTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyEConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinINTConsumer intConsumer;

	public ComplexReconstrTestLanguageTrickyEConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$14()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordTE(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeGroup$5() throws Exception {
		while(doConsumeGroup$5()) {}
		return true;
	}

	protected boolean doConsumeGroup$5() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(intConsumer, "name", true, false, getRule().ele001000LexerRuleCallINT(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(stringConsumer, "foo", true, false, getRule().ele001010LexerRuleCallSTRING(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele00110LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele01KeywordX(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeGroup$14() throws Exception {
		while(doConsumeGroup$14()) {}
		return true;
	}

	protected boolean doConsumeGroup$14() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$15() throws Exception {
		if (consumeTerminal(intConsumer, "name", true, false, getRule().ele100LexerRuleCallINT(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele110LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	public TrickyEElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyE();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyE";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
}
