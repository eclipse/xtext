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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractTokenElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageActionConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAssignmentConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractTokenConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextTerminalsTestLanguageActionConsumer actionConsumer;
	private XtextTerminalsTestLanguageAssignmentConsumer assignmentConsumer;

	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	public XtextTerminalsTestLanguageAbstractTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$2() throws Exception {
		if (consumeRuleCall$4())
			return true;
		if (consumeRuleCall$5())
			return true;
		if (consumeRuleCall$6())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(assignmentConsumer, null, false, false, getRule().ele000ParserRuleCallAssignment());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(actionConsumer, null, false, false, getRule().ele001ParserRuleCallAction());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(abstractTerminalConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractTerminal());
	}

	protected boolean consumeAssignment$7() throws Exception {
		doConsumeAssignment$7();
		return true;
	}

	protected boolean doConsumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false, getKeyword$10$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false, getKeyword$11$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false, getKeyword$12$Delimiter()))
			return true;
		return false;
	}

	public AbstractTokenElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTerminalConsumer(XtextTerminalsTestLanguageAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setActionConsumer(XtextTerminalsTestLanguageActionConsumer actionConsumer) {
		this.actionConsumer = actionConsumer;
	}
	
	public void setAssignmentConsumer(XtextTerminalsTestLanguageAssignmentConsumer assignmentConsumer) {
		this.assignmentConsumer = assignmentConsumer;
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
