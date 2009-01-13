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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyDElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.ComplexReconstrTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyDConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	public ComplexReconstrTestLanguageTrickyDConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeGroup$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$18()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordTD(), null, false, false, ComplexReconstrTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeGroup$5() throws Exception {
		doConsumeGroup$5();
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
		if (consumeTerminal(stringConsumer, "foo", false, false, getRule().ele001010LexerRuleCallSTRING(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele00110LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$13() throws Exception {
		doConsumeGroup$13();
		return true;
	}

	protected boolean doConsumeGroup$13() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$14() throws Exception {
		if (consumeTerminal(intConsumer, "name", true, false, getRule().ele0100LexerRuleCallINT(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele0110LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$18() throws Exception {
		while(doConsumeAssignment$18()) {}
		return true;
	}

	protected boolean doConsumeAssignment$18() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele10LexerRuleCallID(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	public TrickyDElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyD";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
}
