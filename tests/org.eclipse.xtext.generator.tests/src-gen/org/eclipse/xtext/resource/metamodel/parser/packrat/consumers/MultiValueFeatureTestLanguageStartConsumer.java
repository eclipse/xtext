/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.parser.packrat.consumers;

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

import org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageGrammarAccess;
import org.eclipse.xtext.resource.metamodel.services.MultiValueFeatureTestLanguageGrammarAccess.StartElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class MultiValueFeatureTestLanguageStartConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ISequenceMatcher ruleCall$2$Delimiter;
	
	public MultiValueFeatureTestLanguageStartConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$2$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		if (doConsumeAssignment$1()) {
			while(doConsumeAssignment$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$1() throws Exception {
		if (consumeTerminal(idConsumer, "featureA", true, false, getRule().ele0LexerRuleCallID(), getRuleCall$2$Delimiter()))
			return true;
		return false;
	}

	public StartElements getRule() {
		return MultiValueFeatureTestLanguageGrammarAccess.INSTANCE.prStart();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Start";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getRuleCall$2$Delimiter() {
		return ruleCall$2$Delimiter;
	}
	
	public void setRuleCall$2$Delimiter(ISequenceMatcher matcher) {
		ruleCall$2$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
