/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess.TermElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageBooleanConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageManyStringsConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageParensConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageRef2Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageSpareConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTwoNumbersConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTypeConsumer;

@SuppressWarnings("unused")
public final class SimpleReconstrTestLanguageTermConsumer extends NonTerminalConsumer {

	private TermElements rule;
	
	private INonTerminalConsumer atomConsumer;
	private INonTerminalConsumer booleanConsumer;
	private INonTerminalConsumer manyStringsConsumer;
	private INonTerminalConsumer parensConsumer;
	private INonTerminalConsumer ref2Consumer;
	private INonTerminalConsumer spareConsumer;
	private INonTerminalConsumer twoNumbersConsumer;
	private INonTerminalConsumer typeConsumer;

	public SimpleReconstrTestLanguageTermConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				if (result.isAlternativeDone(consumeRuleCall$8(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$10(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$11(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$12(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 5:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$13(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 6:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$14(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 7:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$15(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, false, getRule().ele0000000ParserRuleCallAtom());
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(twoNumbersConsumer, null, false, false, false, getRule().ele0000001ParserRuleCallTwoNumbers());
	}

	protected int consumeRuleCall$10(int entryPoint) throws Exception {
		return consumeNonTerminal(manyStringsConsumer, null, false, false, false, getRule().ele000001ParserRuleCallManyStrings());
	}

	protected int consumeRuleCall$11(int entryPoint) throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, false, getRule().ele00001ParserRuleCallParens());
	}

	protected int consumeRuleCall$12(int entryPoint) throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, false, getRule().ele0001ParserRuleCallType());
	}

	protected int consumeRuleCall$13(int entryPoint) throws Exception {
		return consumeNonTerminal(ref2Consumer, null, false, false, false, getRule().ele001ParserRuleCallRef2());
	}

	protected int consumeRuleCall$14(int entryPoint) throws Exception {
		return consumeNonTerminal(spareConsumer, null, false, false, false, getRule().ele01ParserRuleCallSpare());
	}

	protected int consumeRuleCall$15(int entryPoint) throws Exception {
		return consumeNonTerminal(booleanConsumer, null, false, false, false, getRule().ele1ParserRuleCallBoolean());
	}

	public TermElements getRule() {
	// SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prTerm()
		return rule;
	}
	
	public void setRule(TermElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAtomConsumer(INonTerminalConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setBooleanConsumer(INonTerminalConsumer booleanConsumer) {
		this.booleanConsumer = booleanConsumer;
	}
	
	public void setManyStringsConsumer(INonTerminalConsumer manyStringsConsumer) {
		this.manyStringsConsumer = manyStringsConsumer;
	}
	
	public void setParensConsumer(INonTerminalConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	
	public void setRef2Consumer(INonTerminalConsumer ref2Consumer) {
		this.ref2Consumer = ref2Consumer;
	}
	
	public void setSpareConsumer(INonTerminalConsumer spareConsumer) {
		this.spareConsumer = spareConsumer;
	}
	
	public void setTwoNumbersConsumer(INonTerminalConsumer twoNumbersConsumer) {
		this.twoNumbersConsumer = twoNumbersConsumer;
	}
	
	public void setTypeConsumer(INonTerminalConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
}
