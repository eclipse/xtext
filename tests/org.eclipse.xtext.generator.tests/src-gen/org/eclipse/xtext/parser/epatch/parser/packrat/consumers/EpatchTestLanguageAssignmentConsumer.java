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
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$6(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(biSingleAssignmentConsumer, null, false, false, false, getRule().ele000ParserRuleCallBiSingleAssignment());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(biListAssignmentConsumer, null, false, false, false, getRule().ele001ParserRuleCallBiListAssignment());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(monoSingleAssignmentConsumer, null, false, false, false, getRule().ele01ParserRuleCallMonoSingleAssignment());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(monoListAssignmentConsumer, null, false, false, false, getRule().ele1ParserRuleCallMonoListAssignment());
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
