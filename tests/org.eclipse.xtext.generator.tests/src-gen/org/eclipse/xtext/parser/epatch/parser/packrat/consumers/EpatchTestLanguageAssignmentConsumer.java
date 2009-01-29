/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.AssignmentElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiSingleAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoSingleAssignmentConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageAssignmentConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageBiListAssignmentConsumer biListAssignmentConsumer;
	private EpatchTestLanguageBiSingleAssignmentConsumer biSingleAssignmentConsumer;
	private EpatchTestLanguageMonoListAssignmentConsumer monoListAssignmentConsumer;
	private EpatchTestLanguageMonoSingleAssignmentConsumer monoSingleAssignmentConsumer;

	public EpatchTestLanguageAssignmentConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
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
		tempResult = consumeRuleCall$4(); 
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
		tempResult = consumeRuleCall$5(); 
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
		tempResult = consumeRuleCall$6(); 
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
		tempResult = consumeRuleCall$7(); 
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

	protected int consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(biSingleAssignmentConsumer, null, false, false, getRule().ele000ParserRuleCallBiSingleAssignment());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(biListAssignmentConsumer, null, false, false, getRule().ele001ParserRuleCallBiListAssignment());
	}

	protected int consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(monoSingleAssignmentConsumer, null, false, false, getRule().ele01ParserRuleCallMonoSingleAssignment());
	}

	protected int consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(monoListAssignmentConsumer, null, false, false, getRule().ele1ParserRuleCallMonoListAssignment());
	}

	public AssignmentElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Assignment";
	}
	
	public void setBiListAssignmentConsumer(EpatchTestLanguageBiListAssignmentConsumer biListAssignmentConsumer) {
		this.biListAssignmentConsumer = biListAssignmentConsumer;
	}
	
	public void setBiSingleAssignmentConsumer(EpatchTestLanguageBiSingleAssignmentConsumer biSingleAssignmentConsumer) {
		this.biSingleAssignmentConsumer = biSingleAssignmentConsumer;
	}
	
	public void setMonoListAssignmentConsumer(EpatchTestLanguageMonoListAssignmentConsumer monoListAssignmentConsumer) {
		this.monoListAssignmentConsumer = monoListAssignmentConsumer;
	}
	
	public void setMonoSingleAssignmentConsumer(EpatchTestLanguageMonoSingleAssignmentConsumer monoSingleAssignmentConsumer) {
		this.monoSingleAssignmentConsumer = monoSingleAssignmentConsumer;
	}
	
}
