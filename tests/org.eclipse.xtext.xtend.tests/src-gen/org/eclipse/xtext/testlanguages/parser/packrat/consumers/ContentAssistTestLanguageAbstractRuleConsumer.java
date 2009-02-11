/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageFirstAbstractRuleChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageSecondAbstractRuleChildConsumer;

@SuppressWarnings("unused")
public final class ContentAssistTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer firstAbstractRuleChildConsumer;
	private INonTerminalConsumer secondAbstractRuleChildConsumer;

	public ContentAssistTestLanguageAbstractRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				if (result.isAlternativeDone(consumeRuleCall$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(firstAbstractRuleChildConsumer, null, false, false, false, getRule().ele0ParserRuleCallFirstAbstractRuleChild());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(secondAbstractRuleChildConsumer, null, false, false, false, getRule().ele1ParserRuleCallSecondAbstractRuleChild());
	}

	public AbstractRuleElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setFirstAbstractRuleChildConsumer(INonTerminalConsumer firstAbstractRuleChildConsumer) {
		this.firstAbstractRuleChildConsumer = firstAbstractRuleChildConsumer;
	}
	
	public void setSecondAbstractRuleChildConsumer(INonTerminalConsumer secondAbstractRuleChildConsumer) {
		this.secondAbstractRuleChildConsumer = secondAbstractRuleChildConsumer;
	}
	
}
