/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractMetamodelDeclarationElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageReferencedMetamodelConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer generatedMetamodelConsumer;
	private INonTerminalConsumer referencedMetamodelConsumer;

	public XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
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
		return consumeNonTerminal(generatedMetamodelConsumer, null, false, false, false, getRule().ele0ParserRuleCallGeneratedMetamodel());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(referencedMetamodelConsumer, null, false, false, false, getRule().ele1ParserRuleCallReferencedMetamodel());
	}

	public AbstractMetamodelDeclarationElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractMetamodelDeclaration";
	}
	
	public void setGeneratedMetamodelConsumer(INonTerminalConsumer generatedMetamodelConsumer) {
		this.generatedMetamodelConsumer = generatedMetamodelConsumer;
	}
	
	public void setReferencedMetamodelConsumer(INonTerminalConsumer referencedMetamodelConsumer) {
		this.referencedMetamodelConsumer = referencedMetamodelConsumer;
	}
	
}
