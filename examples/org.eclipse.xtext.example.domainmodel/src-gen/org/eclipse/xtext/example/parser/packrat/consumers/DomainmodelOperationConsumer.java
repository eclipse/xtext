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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.OperationElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeRefConsumer;

@SuppressWarnings("unused")
public final class DomainmodelOperationConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private DomainmodelParameterConsumer parameterConsumer;
	private DomainmodelTypeRefConsumer typeRefConsumer;

	private ISequenceMatcher ruleCall$9$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	public DomainmodelOperationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
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
		return consumeKeyword(getRule().ele000000KeywordOp(), null, false, false, getKeyword$7$Delimiter());
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0000010LexerRuleCallID(), getRuleCall$9$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordLeftParenthesis(), null, false, false, getKeyword$10$Delimiter());
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
		return consumeKeyword(getRule().ele000110KeywordComma(), null, false, false, getKeyword$15$Delimiter());
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeNonTerminal(parameterConsumer, "params", true, false, getRule().ele0001110ParserRuleCallParameter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele001KeywordRightParenthesis(), null, false, false, getKeyword$18$Delimiter());
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele01KeywordColon(), null, false, false, getKeyword$19$Delimiter());
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
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setParameterConsumer(DomainmodelParameterConsumer parameterConsumer) {
		this.parameterConsumer = parameterConsumer;
	}
	
	public void setTypeRefConsumer(DomainmodelTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ISequenceMatcher getRuleCall$9$Delimiter() {
		return ruleCall$9$Delimiter;
	}
	
	public void setRuleCall$9$Delimiter(ISequenceMatcher matcher) {
		ruleCall$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
