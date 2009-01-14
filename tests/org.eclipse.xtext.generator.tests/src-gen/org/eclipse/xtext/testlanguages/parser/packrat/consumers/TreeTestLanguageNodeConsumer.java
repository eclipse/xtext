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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess.NodeElements;

import org.eclipse.xtext.testlanguages.parser.packrat.TreeTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TreeTestLanguageNodeConsumer;

@SuppressWarnings("unused")
public final class TreeTestLanguageNodeConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private TreeTestLanguageNodeConsumer nodeConsumer;

	public TreeTestLanguageNodeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0000000LexerRuleCallID(), TreeTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLeftParenthesis(), null, false, false, TreeTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeTerminal(stringConsumer, "attrib", false, false, getRule().ele000010LexerRuleCallSTRING(), TreeTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordRightParenthesis(), null, false, false, TreeTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, TreeTestLanguageDelimiters.ANY_OTHER_DELIMITER);
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
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracketSemicolon(), null, false, false, TreeTestLanguageDelimiters.ANY_OTHER_DELIMITER);
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
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setNodeConsumer(TreeTestLanguageNodeConsumer nodeConsumer) {
		this.nodeConsumer = nodeConsumer;
	}
	
}
