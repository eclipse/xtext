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

	public HiddenTerminalsTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		return consumeNonTerminal(withoutHiddensConsumer, null, false, false, getRule().ele000ParserRuleCallWithoutHiddens());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(withHiddensConsumer, null, false, false, getRule().ele001ParserRuleCallWithHiddens());
	}

	protected int consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(overridingHiddensConsumer, null, false, false, getRule().ele01ParserRuleCallOverridingHiddens());
	}

	protected int consumeRuleCall$7() throws Exception {
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
