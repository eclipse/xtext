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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.ParenthesizedElementElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAlternativesConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageParenthesizedElementConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAlternativesConsumer alternativesConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	public XtextTerminalsTestLanguageParenthesizedElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
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
		if (!consumeRuleCall$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordLeftParenthesis(), null, false, false, getKeyword$3$Delimiter());
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(alternativesConsumer, null, false, false, getRule().ele01ParserRuleCallAlternatives());
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, getKeyword$5$Delimiter());
	}

	public ParenthesizedElementElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prParenthesizedElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAlternativesConsumer(XtextTerminalsTestLanguageAlternativesConsumer alternativesConsumer) {
		this.alternativesConsumer = alternativesConsumer;
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
