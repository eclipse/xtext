/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
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

	private XtextTerminalsTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer;
	private XtextTerminalsTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer;

	public XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected int consumeAlternatives$1() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$2(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$3(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
		return result;
	}

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(generatedMetamodelConsumer, null, false, false, getRule().ele0ParserRuleCallGeneratedMetamodel());
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(referencedMetamodelConsumer, null, false, false, getRule().ele1ParserRuleCallReferencedMetamodel());
	}

	public AbstractMetamodelDeclarationElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractMetamodelDeclaration";
	}
	
	public void setGeneratedMetamodelConsumer(XtextTerminalsTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer) {
		this.generatedMetamodelConsumer = generatedMetamodelConsumer;
	}
	
	public void setReferencedMetamodelConsumer(XtextTerminalsTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer) {
		this.referencedMetamodelConsumer = referencedMetamodelConsumer;
	}
	
}
