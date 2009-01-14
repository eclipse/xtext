/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

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

import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.InheritedParserRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class AbstractTestLanguageInheritedParserRuleConsumer extends NonTerminalConsumer {

	private AbstractTestLanguageIDConsumer idConsumer;

	private ISequenceMatcher ruleCall$4$Delimiter;
	
	private ICharacterClass keyword$2$Delimiter;
	
	public AbstractTestLanguageInheritedParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordElement(), null, false, false, getKeyword$2$Delimiter());
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele10LexerRuleCallID(), getRuleCall$4$Delimiter()))
			return true;
		return false;
	}

	public InheritedParserRuleElements getRule() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.prInheritedParserRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AType";
	}
	
	public void setIdConsumer(AbstractTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getRuleCall$4$Delimiter() {
		return ruleCall$4$Delimiter;
	}
	
	public void setRuleCall$4$Delimiter(ISequenceMatcher matcher) {
		ruleCall$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
