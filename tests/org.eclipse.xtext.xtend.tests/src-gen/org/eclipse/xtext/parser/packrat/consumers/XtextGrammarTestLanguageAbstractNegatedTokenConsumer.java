/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractNegatedTokenElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageUpToTokenConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAbstractNegatedTokenConsumer extends NonTerminalConsumer {

	private AbstractNegatedTokenElements rule;
	
	private INonTerminalConsumer negatedTokenConsumer;
	private INonTerminalConsumer upToTokenConsumer;

	public XtextGrammarTestLanguageAbstractNegatedTokenConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(negatedTokenConsumer, null, false, false, false, getRule().ele0ParserRuleCallNegatedToken());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(upToTokenConsumer, null, false, false, false, getRule().ele1ParserRuleCallUpToToken());
	}

	public AbstractNegatedTokenElements getRule() {
	// XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken()
		return rule;
	}
	
	public void setRule(AbstractNegatedTokenElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractNegatedToken";
	}
	
	public void setNegatedTokenConsumer(INonTerminalConsumer negatedTokenConsumer) {
		this.negatedTokenConsumer = negatedTokenConsumer;
	}
	
	public void setUpToTokenConsumer(INonTerminalConsumer upToTokenConsumer) {
		this.upToTokenConsumer = upToTokenConsumer;
	}
	
}
