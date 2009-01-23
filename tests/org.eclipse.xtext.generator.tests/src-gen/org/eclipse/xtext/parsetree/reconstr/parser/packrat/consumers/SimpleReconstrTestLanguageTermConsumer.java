/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

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

	public SimpleReconstrTestLanguageTermConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$8(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$9(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$10(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$11(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$12(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$13(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$14(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$15(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		bestMarker.release();
		return result;
	}

	protected int consumeRuleCall$8() throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, getRule().ele0000000ParserRuleCallAtom());
	}

	protected int consumeRuleCall$9() throws Exception {
		return consumeNonTerminal(twoNumbersConsumer, null, false, false, getRule().ele0000001ParserRuleCallTwoNumbers());
	}

	protected int consumeRuleCall$10() throws Exception {
		return consumeNonTerminal(manyStringsConsumer, null, false, false, getRule().ele000001ParserRuleCallManyStrings());
	}

	protected int consumeRuleCall$11() throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, getRule().ele00001ParserRuleCallParens());
	}

	protected int consumeRuleCall$12() throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, getRule().ele0001ParserRuleCallType());
	}

	protected int consumeRuleCall$13() throws Exception {
		return consumeNonTerminal(ref2Consumer, null, false, false, getRule().ele001ParserRuleCallRef2());
	}

	protected int consumeRuleCall$14() throws Exception {
		return consumeNonTerminal(spareConsumer, null, false, false, getRule().ele01ParserRuleCallSpare());
	}

	protected int consumeRuleCall$15() throws Exception {
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
