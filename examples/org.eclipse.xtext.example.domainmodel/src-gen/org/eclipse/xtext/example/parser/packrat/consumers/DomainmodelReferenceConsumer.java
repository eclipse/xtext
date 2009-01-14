/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.ReferenceElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeRefConsumer;

@SuppressWarnings("unused")
public final class DomainmodelReferenceConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private DomainmodelTypeRefConsumer typeRefConsumer;

	public DomainmodelReferenceConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordRef(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), DomainmodelDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele010ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeGroup$11() throws Exception {
		doConsumeGroup$11();
		return true;
	}

	protected boolean doConsumeGroup$11() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele10KeywordOpposite(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele110CrossReferenceEStringReference(), DomainmodelDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	public ReferenceElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prReference();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Reference";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(DomainmodelTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
}
