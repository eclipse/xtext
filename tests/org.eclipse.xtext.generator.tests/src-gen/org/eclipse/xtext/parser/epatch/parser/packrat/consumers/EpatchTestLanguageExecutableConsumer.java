/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ExecutableElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageExpressionExecutableConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageJavaExecutableConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageExecutableConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageExpressionExecutableConsumer expressionExecutableConsumer;
	private EpatchTestLanguageJavaExecutableConsumer javaExecutableConsumer;

	public EpatchTestLanguageExecutableConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(javaExecutableConsumer, null, false, false, getRule().ele0ParserRuleCallJavaExecutable());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(expressionExecutableConsumer, null, false, false, getRule().ele1ParserRuleCallExpressionExecutable());
	}

	public ExecutableElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExecutable();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Executable";
	}
	
	public void setExpressionExecutableConsumer(EpatchTestLanguageExpressionExecutableConsumer expressionExecutableConsumer) {
		this.expressionExecutableConsumer = expressionExecutableConsumer;
	}
	
	public void setJavaExecutableConsumer(EpatchTestLanguageJavaExecutableConsumer javaExecutableConsumer) {
		this.javaExecutableConsumer = javaExecutableConsumer;
	}
	
}
