/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageANY_OTHERConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageINTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSTRINGConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageWSConsumer;

@SuppressWarnings("unused")
public final class TerminalRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer;
	private TerminalRulesTestLanguageIDConsumer idConsumer;
	private TerminalRulesTestLanguageINTConsumer intConsumer;
	private TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer;
	private TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer;
	private TerminalRulesTestLanguageSTRINGConsumer stringConsumer;
	private TerminalRulesTestLanguageWSConsumer wsConsumer;

	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	private ISequenceMatcher ruleCall$12$Delimiter;
	
	private ISequenceMatcher ruleCall$14$Delimiter;
	
	private ISequenceMatcher ruleCall$16$Delimiter;
	
	private ISequenceMatcher ruleCall$18$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	public TerminalRulesTestLanguageModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$12$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$18$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		announceNextLevel();
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$7(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 1:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$9(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 2:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$11(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 3:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$13(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 4:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$15(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 5:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$17(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 6:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$19(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
		}
		bestMarker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "idValue", false, false, getRule().ele0000000ParserRuleCallID(), getRuleCall$8$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$9(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "intValue", false, false, getRule().ele0000010ParserRuleCallINT(), getRuleCall$10$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$11(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(stringConsumer, "stringValue", false, false, getRule().ele000010ParserRuleCallSTRING(), getRuleCall$12$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(mlCommentConsumer, "mlCommentValue", false, false, getRule().ele00010ParserRuleCallML_COMMENT(), getRuleCall$14$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$15(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(slCommentConsumer, "slCommentValue", false, false, getRule().ele0010ParserRuleCallSL_COMMENT(), getRuleCall$16$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(wsConsumer, "wsValue", false, false, getRule().ele010ParserRuleCallWS(), getRuleCall$18$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$19(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(anyOtherConsumer, "anyValue", false, false, getRule().ele10ParserRuleCallANY_OTHER(), getRuleCall$20$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public ModelElements getRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setAnyOtherConsumer(TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer) {
		this.anyOtherConsumer = anyOtherConsumer;
	}
	
	public void setIdConsumer(TerminalRulesTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(TerminalRulesTestLanguageINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setMlCommentConsumer(TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer) {
		this.mlCommentConsumer = mlCommentConsumer;
	}
	
	public void setSlCommentConsumer(TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer) {
		this.slCommentConsumer = slCommentConsumer;
	}
	
	public void setStringConsumer(TerminalRulesTestLanguageSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setWsConsumer(TerminalRulesTestLanguageWSConsumer wsConsumer) {
		this.wsConsumer = wsConsumer;
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$12$Delimiter() {
		return ruleCall$12$Delimiter;
	}
	
	public void setRuleCall$12$Delimiter(ISequenceMatcher matcher) {
		ruleCall$12$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$14$Delimiter() {
		return ruleCall$14$Delimiter;
	}
	
	public void setRuleCall$14$Delimiter(ISequenceMatcher matcher) {
		ruleCall$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$16$Delimiter() {
		return ruleCall$16$Delimiter;
	}
	
	public void setRuleCall$16$Delimiter(ISequenceMatcher matcher) {
		ruleCall$16$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$18$Delimiter() {
		return ruleCall$18$Delimiter;
	}
	
	public void setRuleCall$18$Delimiter(ISequenceMatcher matcher) {
		ruleCall$18$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
