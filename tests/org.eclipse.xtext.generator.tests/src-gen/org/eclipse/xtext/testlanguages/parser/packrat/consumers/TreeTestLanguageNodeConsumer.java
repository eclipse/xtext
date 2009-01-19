/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

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

import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess.NodeElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TreeTestLanguageNodeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class TreeTestLanguageNodeConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private TreeTestLanguageNodeConsumer nodeConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$11$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	public TreeTestLanguageNodeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0000000LexerRuleCallID(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLeftParenthesis(), null, false, false, getKeyword$9$Delimiter());
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeTerminal(stringConsumer, "attrib", false, false, getRule().ele000010LexerRuleCallSTRING(), getRuleCall$11$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordRightParenthesis(), null, false, false, getKeyword$12$Delimiter());
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, getKeyword$13$Delimiter());
	}

	protected boolean consumeAssignment$14() throws Exception {
		while(doConsumeAssignment$14()) {}
		return true;
	}

	protected boolean doConsumeAssignment$14() throws Exception {
		if (consumeNonTerminal(nodeConsumer, "children", true, false, getRule().ele010ParserRuleCallNode()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracketSemicolon(), null, false, false, getKeyword$16$Delimiter());
	}

	public NodeElements getRule() {
		return TreeTestLanguageGrammarAccess.INSTANCE.prNode();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Node";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNodeConsumer(TreeTestLanguageNodeConsumer nodeConsumer) {
		this.nodeConsumer = nodeConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$11$Delimiter() {
		return ruleCall$11$Delimiter;
	}
	
	public void setRuleCall$11$Delimiter(ISequenceMatcher matcher) {
		ruleCall$11$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
