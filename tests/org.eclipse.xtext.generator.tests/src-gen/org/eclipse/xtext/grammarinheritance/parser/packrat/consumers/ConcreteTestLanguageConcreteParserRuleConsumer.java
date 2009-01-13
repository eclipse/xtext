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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.ConcreteParserRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.ConcreteTestLanguageDelimiters;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageInheritedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageREALConsumer;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageConcreteParserRuleConsumer extends NonTerminalConsumer {

	private AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer;
	private AbstractTestLanguageREALConsumer realConsumer;

	public ConcreteTestLanguageConcreteParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordModel(), null, false, false, ConcreteTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(realConsumer, "magicNumber", false, false, getRule().ele0010LexerRuleCallREAL(), ConcreteTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele01KeywordColon(), null, false, false, ConcreteTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$8() throws Exception {
		while(doConsumeAssignment$8()) {}
		return true;
	}

	protected boolean doConsumeAssignment$8() throws Exception {
		if (consumeNonTerminal(inheritedParserRuleConsumer, "elements", true, false, getRule().ele10ParserRuleCallInheritedParserRule()))
			return true;
		return false;
	}

	public ConcreteParserRuleElements getRule() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ConcreteParserRule";
	}
	
	public void setInheritedParserRuleConsumer(AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer) {
		this.inheritedParserRuleConsumer = inheritedParserRuleConsumer;
	}
	
	public void setRealConsumer(AbstractTestLanguageREALConsumer realConsumer) {
		this.realConsumer = realConsumer;
	}
	
}
