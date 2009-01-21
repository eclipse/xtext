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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.TerminalTokenElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalTokenElementConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageTerminalTokenConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer;

	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	public XtextTerminalsTestLanguageTerminalTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeRuleCall$2()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(terminalTokenElementConsumer, null, false, false, getRule().ele0ParserRuleCallTerminalTokenElement());
	}

	protected boolean consumeAssignment$3() throws Exception {
		doConsumeAssignment$3();
		return true;
	}

	protected boolean doConsumeAssignment$3() throws Exception {
		if (consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false, getKeyword$6$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false, getKeyword$7$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false, getKeyword$8$Delimiter()))
			return true;
		return false;
	}

	public TerminalTokenElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalTokenElementConsumer(XtextTerminalsTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer) {
		this.terminalTokenElementConsumer = terminalTokenElementConsumer;
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
