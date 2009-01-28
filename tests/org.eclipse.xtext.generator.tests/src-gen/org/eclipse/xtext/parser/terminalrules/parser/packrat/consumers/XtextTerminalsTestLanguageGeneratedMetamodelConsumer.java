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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.GeneratedMetamodelElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageSTRINGConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageGeneratedMetamodelConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageIDConsumer idConsumer;
	private XtextTerminalsTestLanguageSTRINGConsumer stringConsumer;

	private ISequenceMatcher crossReference$8$Delimiter;
	
	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	private ISequenceMatcher ruleCall$13$Delimiter;
	
	public XtextTerminalsTestLanguageGeneratedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$13$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000KeywordGenerate());
			marker.commit();
			return result;
		}
		result = consumeAssignment$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001AssignmentName());
			marker.commit();
			return result;
		}
		result = consumeAssignment$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01AssignmentEPackage());
			marker.commit();
			return result;
		}
		result = consumeGroup$10(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordGenerate(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeAssignment$5() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele0010ParserRuleCallID(), getRuleCall$6$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$7() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(stringConsumer, "ePackage", false, false, getRule().ele010CrossReferenceEStringEPackage(), getCrossReference$8$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$10() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$10();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$10() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10KeywordAs());
			marker.commit();
			return result;
		}
		result = consumeAssignment$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11AssignmentAlias());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele10KeywordAs(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "alias", false, false, getRule().ele110ParserRuleCallID(), getRuleCall$13$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public GeneratedMetamodelElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "GeneratedMetamodel";
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextTerminalsTestLanguageSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getCrossReference$8$Delimiter() {
		return crossReference$8$Delimiter;
	}
	
	public void setCrossReference$8$Delimiter(ISequenceMatcher matcher) {
		crossReference$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$13$Delimiter() {
		return ruleCall$13$Delimiter;
	}
	
	public void setRuleCall$13$Delimiter(ISequenceMatcher matcher) {
		ruleCall$13$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
