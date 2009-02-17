/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.TypeRefElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class DomainmodelTypeRefConsumer extends NonTerminalConsumer {

	private TypeRefElements rule;
	
	private ITerminalConsumer idConsumer;

	private ISequenceMatcher crossReference$2$Delimiter;
	
	public DomainmodelTypeRefConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$2$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		return consumeCrossReference$2(entryPoint);
	}

	protected int consumeCrossReference$2(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "referenced", false, false, getRule().ele0CrossReferenceEStringType(), getCrossReference$2$Delimiter());
	}

	public TypeRefElements getRule() {
		return rule;
	}
	
	public void setRule(TypeRefElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected AbstractRule getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected EClassifier getDefaultType() {
		return getGrammarElement().getType().getType();
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getCrossReference$2$Delimiter() {
		return crossReference$2$Delimiter;
	}
	
	public void setCrossReference$2$Delimiter(ISequenceMatcher matcher) {
		crossReference$2$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
