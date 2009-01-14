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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.OperationElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeRefConsumer;

@SuppressWarnings("unused")
public final class DomainmodelOperationConsumer extends NonTerminalConsumer {

	private DomainmodelParameterConsumer parameterConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private DomainmodelTypeRefConsumer typeRefConsumer;

	public DomainmodelOperationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$18()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$20()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordOp(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0000010LexerRuleCallID(), DomainmodelDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordLeftParenthesis(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeGroup$11() throws Exception {
		doConsumeGroup$11();
		return true;
	}

	protected boolean doConsumeGroup$11() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$14()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeNonTerminal(parameterConsumer, "params", true, false, getRule().ele000100ParserRuleCallParameter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$14() throws Exception {
		while(doConsumeGroup$14()) {}
		return true;
	}

	protected boolean doConsumeGroup$14() throws Exception {
		final IMarker marker = mark();
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

	protected boolean consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele000110KeywordComma(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeNonTerminal(parameterConsumer, "params", true, false, getRule().ele0001110ParserRuleCallParameter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele001KeywordRightParenthesis(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele01KeywordColon(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$20() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele10ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	public OperationElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Operation";
	}
	
	public void setParameterConsumer(DomainmodelParameterConsumer parameterConsumer) {
		this.parameterConsumer = parameterConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(DomainmodelTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
}
