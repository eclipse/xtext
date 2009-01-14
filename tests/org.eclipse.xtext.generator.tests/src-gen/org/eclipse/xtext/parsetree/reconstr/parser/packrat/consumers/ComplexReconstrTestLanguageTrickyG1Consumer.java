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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyG1Elements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG2Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyG1Consumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer;

	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$3$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyG1Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordLeftSquareBracket(), null, false, false, getKeyword$3$Delimiter());
	}

	protected boolean consumeGroup$4() throws Exception {
		doConsumeGroup$4();
		return true;
	}

	protected boolean doConsumeGroup$4() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeNonTerminal(trickyG2Consumer, "vals", true, false, getRule().ele0100ParserRuleCallTrickyG2()))
			return true;
		return false;
	}

	protected boolean consumeGroup$7() throws Exception {
		while(doConsumeGroup$7()) {}
		return true;
	}

	protected boolean doConsumeGroup$7() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0110KeywordComma(), null, false, false, getKeyword$8$Delimiter());
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(trickyG2Consumer, "vals", true, false, getRule().ele01110ParserRuleCallTrickyG2()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightSquareBracket(), null, false, false, getKeyword$11$Delimiter());
	}

	public TrickyG1Elements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyG1";
	}
	
	public void setTrickyG2Consumer(ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer) {
		this.trickyG2Consumer = trickyG2Consumer;
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
