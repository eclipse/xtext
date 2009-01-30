/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
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

	private SimpleReconstrTestLanguageAtomConsumer atomConsumer;
	private SimpleReconstrTestLanguageBooleanConsumer booleanConsumer;
	private SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer;
	private SimpleReconstrTestLanguageParensConsumer parensConsumer;
	private SimpleReconstrTestLanguageRef2Consumer ref2Consumer;
	private SimpleReconstrTestLanguageSpareConsumer spareConsumer;
	private SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer;
	private SimpleReconstrTestLanguageTypeConsumer typeConsumer;

	public SimpleReconstrTestLanguageTermConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
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
				tempResult = consumeRuleCall$8(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$9(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$10(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$11(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$12(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$13(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$14(nextEntryPoint()); 
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
			case 7:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$15(nextEntryPoint()); 
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

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, getRule().ele0000000ParserRuleCallAtom());
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(twoNumbersConsumer, null, false, false, getRule().ele0000001ParserRuleCallTwoNumbers());
	}

	protected int consumeRuleCall$10(int entryPoint) throws Exception {
		return consumeNonTerminal(manyStringsConsumer, null, false, false, getRule().ele000001ParserRuleCallManyStrings());
	}

	protected int consumeRuleCall$11(int entryPoint) throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, getRule().ele00001ParserRuleCallParens());
	}

	protected int consumeRuleCall$12(int entryPoint) throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, getRule().ele0001ParserRuleCallType());
	}

	protected int consumeRuleCall$13(int entryPoint) throws Exception {
		return consumeNonTerminal(ref2Consumer, null, false, false, getRule().ele001ParserRuleCallRef2());
	}

	protected int consumeRuleCall$14(int entryPoint) throws Exception {
		return consumeNonTerminal(spareConsumer, null, false, false, getRule().ele01ParserRuleCallSpare());
	}

	protected int consumeRuleCall$15(int entryPoint) throws Exception {
		return consumeNonTerminal(booleanConsumer, null, false, false, getRule().ele1ParserRuleCallBoolean());
	}

	public TermElements getRule() {
		return SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prTerm();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAtomConsumer(SimpleReconstrTestLanguageAtomConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setBooleanConsumer(SimpleReconstrTestLanguageBooleanConsumer booleanConsumer) {
		this.booleanConsumer = booleanConsumer;
	}
	
	public void setManyStringsConsumer(SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer) {
		this.manyStringsConsumer = manyStringsConsumer;
	}
	
	public void setParensConsumer(SimpleReconstrTestLanguageParensConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	
	public void setRef2Consumer(SimpleReconstrTestLanguageRef2Consumer ref2Consumer) {
		this.ref2Consumer = ref2Consumer;
	}
	
	public void setSpareConsumer(SimpleReconstrTestLanguageSpareConsumer spareConsumer) {
		this.spareConsumer = spareConsumer;
	}
	
	public void setTwoNumbersConsumer(SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer) {
		this.twoNumbersConsumer = twoNumbersConsumer;
	}
	
	public void setTypeConsumer(SimpleReconstrTestLanguageTypeConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
}
