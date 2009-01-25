/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.ParameterElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeRefConsumer;

@SuppressWarnings("unused")
public final class DomainmodelParameterConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private DomainmodelTypeRefConsumer typeRefConsumer;

	private ISequenceMatcher ruleCall$3$Delimiter;
	
	public DomainmodelParameterConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$3$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAssignment$2(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0AssignmentName());
			marker.commit();
			return result;
		}
		result = consumeAssignment$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentType());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAssignment$2() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele00LexerRuleCallID(), getRuleCall$3$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$4() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele10ParserRuleCallTypeRef());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public ParameterElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prParameter();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Parameter";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(DomainmodelTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ISequenceMatcher getRuleCall$3$Delimiter() {
		return ruleCall$3$Delimiter;
	}
	
	public void setRuleCall$3$Delimiter(ISequenceMatcher matcher) {
		ruleCall$3$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
