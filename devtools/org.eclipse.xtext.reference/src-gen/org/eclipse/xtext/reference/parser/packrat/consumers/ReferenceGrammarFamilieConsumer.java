/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.FamilieElements;

import org.eclipse.xtext.reference.parser.packrat.ReferenceGrammarDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarFamilieConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	public ReferenceGrammarFamilieConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$19()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$22()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$25()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$30()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0000000KeywordFamilie(), null, false, false, ReferenceGrammarDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele0000001KeywordLeftParenthesis(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeKeyword(getRule().ele000001000KeywordKeyword(), "name", false, false, ReferenceGrammarDelimiters.ID_DELIMITER))
			return true;
		if (consumeTerminal(stringConsumer, "name", false, false, getRule().ele000001001LexerRuleCallSTRING(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000101LexerRuleCallID(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele000010CrossReferenceEStringErwachsener(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele00010CrossReferenceEStringErwachsener(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$22() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele0010CrossReferenceEStringKind(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$25() throws Exception {
		while(doConsumeGroup$25()) {}
		return true;
	}

	protected boolean doConsumeGroup$25() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$26()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$27()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$26() throws Exception {
		return consumeKeyword(getRule().ele010KeywordComma(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$27() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele0110CrossReferenceEStringKind(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$30() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	public FamilieElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFamilie();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Familie";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
}
