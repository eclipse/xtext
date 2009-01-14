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

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TermElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageParensConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTermConsumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageAtomConsumer atomConsumer;
	private ComplexReconstrTestLanguageParensConsumer parensConsumer;

	public ComplexReconstrTestLanguageTermConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, getRule().ele0ParserRuleCallAtom());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, getRule().ele1ParserRuleCallParens());
	}

	public TermElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTerm();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAtomConsumer(ComplexReconstrTestLanguageAtomConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setParensConsumer(ComplexReconstrTestLanguageParensConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	
}
