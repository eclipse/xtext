/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.ActionElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTypeRefConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageActionConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageIDConsumer idConsumer;
	private XtextTerminalsTestLanguageTypeRefConsumer typeRefConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$21$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$16$Delimiter;
	
	public XtextTerminalsTestLanguageActionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$21$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0000000KeywordLeftCurlyBracket());
			marker.commit();
			return result;
		}
		result = consumeGroup$9(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0000001Group());
			marker.commit();
			return result;
		}
		result = consumeAssignment$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000001AssignmentTypeName());
			marker.commit();
			return result;
		}
		result = consumeKeyword$14(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00001KeywordFullStop());
			marker.commit();
			return result;
		}
		result = consumeAssignment$15(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001AssignmentFeature());
			marker.commit();
			return result;
		}
		result = consumeAssignment$17(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001AssignmentOperator());
			marker.commit();
			return result;
		}
		result = consumeKeyword$21(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01KeywordCurrent());
			marker.commit();
			return result;
		}
		result = consumeKeyword$22(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1KeywordRightCurlyBracket());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0000000KeywordLeftCurlyBracket(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeGroup$9() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$9();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$9() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$10(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00000010KeywordCurrent());
			marker.commit();
			return result;
		}
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00000011KeywordEqualsSign());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00000010KeywordCurrent(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele00000011KeywordEqualsSign(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(typeRefConsumer, "typeName", false, false, getRule().ele0000010ParserRuleCallTypeRef());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordFullStop(), null, false, false, getKeyword$14$Delimiter());
	}

	protected int consumeAssignment$15() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "feature", false, false, getRule().ele00010ParserRuleCallID(), getRuleCall$16$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$17() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele00100KeywordEqualsSign(), "operator", false, false, getKeyword$19$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		tempResult = consumeKeyword(getRule().ele00101KeywordPlusSignEqualsSign(), "operator", false, false, getKeyword$20$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$21() throws Exception {
		return consumeKeyword(getRule().ele01KeywordCurrent(), null, false, false, getKeyword$21$Delimiter());
	}

	protected int consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, getKeyword$22$Delimiter());
	}

	public ActionElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAction();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Action";
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextTerminalsTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$20$Delimiter() {
		return keyword$20$Delimiter;
	}
	
	public void setKeyword$20$Delimiter(ICharacterClass characterClass) {
		keyword$20$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$21$Delimiter() {
		return keyword$21$Delimiter;
	}
	
	public void setKeyword$21$Delimiter(ICharacterClass characterClass) {
		keyword$21$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$16$Delimiter() {
		return ruleCall$16$Delimiter;
	}
	
	public void setRuleCall$16$Delimiter(ISequenceMatcher matcher) {
		ruleCall$16$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
