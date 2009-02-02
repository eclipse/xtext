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

import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageInheritingHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageOverridingHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWithHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWithoutHiddensConsumer;

@SuppressWarnings("unused")
public final class HiddenTerminalsTestLanguageModelConsumer extends NonTerminalConsumer {

	private HiddenTerminalsTestLanguageInheritingHiddensConsumer inheritingHiddensConsumer;
	private HiddenTerminalsTestLanguageOverridingHiddensConsumer overridingHiddensConsumer;
	private HiddenTerminalsTestLanguageWithHiddensConsumer withHiddensConsumer;
	private HiddenTerminalsTestLanguageWithoutHiddensConsumer withoutHiddensConsumer;

	public HiddenTerminalsTestLanguageModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
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
		return consumeNonTerminal(withoutHiddensConsumer, null, false, false, getRule().ele000ParserRuleCallWithoutHiddens());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(withHiddensConsumer, null, false, false, getRule().ele001ParserRuleCallWithHiddens());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(overridingHiddensConsumer, null, false, false, getRule().ele01ParserRuleCallOverridingHiddens());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(inheritingHiddensConsumer, null, false, false, getRule().ele1ParserRuleCallInheritingHiddens());
	}

	public ModelElements getRule() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setInheritingHiddensConsumer(HiddenTerminalsTestLanguageInheritingHiddensConsumer inheritingHiddensConsumer) {
		this.inheritingHiddensConsumer = inheritingHiddensConsumer;
	}
	
	public void setOverridingHiddensConsumer(HiddenTerminalsTestLanguageOverridingHiddensConsumer overridingHiddensConsumer) {
		this.overridingHiddensConsumer = overridingHiddensConsumer;
	}
	
	public void setWithHiddensConsumer(HiddenTerminalsTestLanguageWithHiddensConsumer withHiddensConsumer) {
		this.withHiddensConsumer = withHiddensConsumer;
	}
	
	public void setWithoutHiddensConsumer(HiddenTerminalsTestLanguageWithoutHiddensConsumer withoutHiddensConsumer) {
		this.withoutHiddensConsumer = withoutHiddensConsumer;
	}
	
}
