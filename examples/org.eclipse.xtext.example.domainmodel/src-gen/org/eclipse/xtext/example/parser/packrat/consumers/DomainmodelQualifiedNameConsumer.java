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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.QualifiedNameElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class DomainmodelQualifiedNameConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public DomainmodelQualifiedNameConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeGroup$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeTerminal(idConsumer, null, false, false, getRule().ele0LexerRuleCallID(), DomainmodelDelimiters.ALL_KEYWORDS);
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeRuleCall$5()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele10KeywordFullStop(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeTerminal(idConsumer, null, false, false, getRule().ele11LexerRuleCallID(), DomainmodelDelimiters.ALL_KEYWORDS);
	}

	public QualifiedNameElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prQualifiedName();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EString";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
