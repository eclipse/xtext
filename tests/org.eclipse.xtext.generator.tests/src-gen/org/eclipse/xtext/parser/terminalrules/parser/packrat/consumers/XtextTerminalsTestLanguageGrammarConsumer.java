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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.GrammarElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageGrammarConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
	private XtextTerminalsTestLanguageAbstractRuleConsumer abstractRuleConsumer;
	private XtextTerminalsTestLanguageIDConsumer idConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$11$Delimiter;
	
	private ISequenceMatcher ruleCall$15$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	private ISequenceMatcher ruleCall$24$Delimiter;
	
	public XtextTerminalsTestLanguageGrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$15$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$24$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAlternatives$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00000Alternatives());
			marker.commit();
			return result;
		}
		result = consumeAssignment$10(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00001AssignmentIdElements());
			marker.commit();
			return result;
		}
		result = consumeGroup$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001Group());
			marker.commit();
			return result;
		}
		result = consumeGroup$16(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001Group());
			marker.commit();
			return result;
		}
		result = consumeAssignment$25(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01AssignmentMetamodelDeclarations());
			marker.commit();
			return result;
		}
		result = consumeAssignment$27(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentRules());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAlternatives$6() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeAssignment$7(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeKeyword$9(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
		return result;
	}

	protected int consumeAssignment$7() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true, getKeyword$8$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false, getKeyword$9$Delimiter());
	}

	protected int consumeAssignment$10() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010ParserRuleCallID(), getRuleCall$11$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$12() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$12() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$13(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00010KeywordFullStop());
			marker.commit();
			return result;
		}
		result = consumeAssignment$14(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00011AssignmentIdElements());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, getKeyword$13$Delimiter());
	}

	protected int consumeAssignment$14() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110ParserRuleCallID(), getRuleCall$15$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$16() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$16();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$18(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00100KeywordExtends());
			marker.commit();
			return result;
		}
		result = consumeAssignment$19(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00101AssignmentSuperGrammarIdElements());
			marker.commit();
			return result;
		}
		result = consumeGroup$21(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0011Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false, getKeyword$18$Delimiter());
	}

	protected int consumeAssignment$19() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010ParserRuleCallID(), getRuleCall$20$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$21() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$21() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$21() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$22(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00110KeywordFullStop());
			marker.commit();
			return result;
		}
		result = consumeAssignment$23(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00111AssignmentSuperGrammarIdElements());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele00110KeywordFullStop(), null, false, false, getKeyword$22$Delimiter());
	}

	protected int consumeAssignment$23() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001110ParserRuleCallID(), getRuleCall$24$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$25() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$25() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$25() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, getRule().ele010ParserRuleCallAbstractMetamodelDeclaration());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$27() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$27();
		if (result == ConsumeResult.SUCCESS) {
			marker.flush();
			while(doConsumeAssignment$27()==ConsumeResult.SUCCESS) {
				marker.flush();
			}
			marker.rollback();
			return ConsumeResult.SUCCESS;
		} else {
			error("Could not find token.", getRule().ele1AssignmentRules());
		}
		marker.commit();
		return result;
	}

	protected int doConsumeAssignment$27() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule().ele10ParserRuleCallAbstractRule());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public GrammarElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Grammar";
	}
	
	public void setAbstractMetamodelDeclarationConsumer(XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}
	
	public void setAbstractRuleConsumer(XtextTerminalsTestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$11$Delimiter() {
		return ruleCall$11$Delimiter;
	}
	
	public void setRuleCall$11$Delimiter(ISequenceMatcher matcher) {
		ruleCall$11$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$15$Delimiter() {
		return ruleCall$15$Delimiter;
	}
	
	public void setRuleCall$15$Delimiter(ISequenceMatcher matcher) {
		ruleCall$15$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$24$Delimiter() {
		return ruleCall$24$Delimiter;
	}
	
	public void setRuleCall$24$Delimiter(ISequenceMatcher matcher) {
		ruleCall$24$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
