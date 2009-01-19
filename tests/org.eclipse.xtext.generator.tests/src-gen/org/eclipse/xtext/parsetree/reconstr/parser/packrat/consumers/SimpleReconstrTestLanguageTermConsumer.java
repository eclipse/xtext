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
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$8())
			return true;
		if (consumeRuleCall$9())
			return true;
		if (consumeRuleCall$10())
			return true;
		if (consumeRuleCall$11())
			return true;
		if (consumeRuleCall$12())
			return true;
		if (consumeRuleCall$13())
			return true;
		if (consumeRuleCall$14())
			return true;
		if (consumeRuleCall$15())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$8() throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, getRule().ele0000000ParserRuleCallAtom());
	}

	protected boolean consumeRuleCall$9() throws Exception {
		return consumeNonTerminal(twoNumbersConsumer, null, false, false, getRule().ele0000001ParserRuleCallTwoNumbers());
	}

	protected boolean consumeRuleCall$10() throws Exception {
		return consumeNonTerminal(manyStringsConsumer, null, false, false, getRule().ele000001ParserRuleCallManyStrings());
	}

	protected boolean consumeRuleCall$11() throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, getRule().ele00001ParserRuleCallParens());
	}

	protected boolean consumeRuleCall$12() throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, getRule().ele0001ParserRuleCallType());
	}

	protected boolean consumeRuleCall$13() throws Exception {
		return consumeNonTerminal(ref2Consumer, null, false, false, getRule().ele001ParserRuleCallRef2());
	}

	protected boolean consumeRuleCall$14() throws Exception {
		return consumeNonTerminal(spareConsumer, null, false, false, getRule().ele01ParserRuleCallSpare());
	}

	protected boolean consumeRuleCall$15() throws Exception {
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
