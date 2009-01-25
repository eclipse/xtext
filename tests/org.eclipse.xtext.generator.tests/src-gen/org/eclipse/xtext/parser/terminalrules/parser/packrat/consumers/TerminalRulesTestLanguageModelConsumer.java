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
	
	public TerminalRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$12$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$18$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected int consumeAlternatives$1() throws Exception {
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
		tempResult = consumeAssignment$9(); 
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
		tempResult = consumeAssignment$11(); 
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
		tempResult = consumeAssignment$13(); 
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
		tempResult = consumeAssignment$15(); 
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
		tempResult = consumeAssignment$17(); 
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
		tempResult = consumeAssignment$19(); 
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
		tempResult = consumeTerminal(idConsumer, "idValue", false, false, getRule().ele0000000ParserRuleCallID(), getRuleCall$8$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$9() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(intConsumer, "intValue", false, false, getRule().ele0000010ParserRuleCallINT(), getRuleCall$10$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$11() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(stringConsumer, "stringValue", false, false, getRule().ele000010ParserRuleCallSTRING(), getRuleCall$12$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$13() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(mlCommentConsumer, "mlCommentValue", false, false, getRule().ele00010ParserRuleCallML_COMMENT(), getRuleCall$14$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$15() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(slCommentConsumer, "slCommentValue", false, false, getRule().ele0010ParserRuleCallSL_COMMENT(), getRuleCall$16$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$17() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(wsConsumer, "wsValue", false, false, getRule().ele010ParserRuleCallWS(), getRuleCall$18$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$19() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(anyOtherConsumer, "anyValue", false, false, getRule().ele10ParserRuleCallANY_OTHER(), getRuleCall$20$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
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
