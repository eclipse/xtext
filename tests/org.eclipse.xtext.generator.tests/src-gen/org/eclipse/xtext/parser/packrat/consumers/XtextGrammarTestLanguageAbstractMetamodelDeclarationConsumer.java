/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

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

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractMetamodelDeclarationElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageReferencedMetamodelConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer;
	private XtextGrammarTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer;

	public XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(generatedMetamodelConsumer, null, false, false, getRule().ele0ParserRuleCallGeneratedMetamodel());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(referencedMetamodelConsumer, null, false, false, getRule().ele1ParserRuleCallReferencedMetamodel());
	}

	public AbstractMetamodelDeclarationElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractMetamodelDeclaration();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractMetamodelDeclaration";
	}
	
	public void setGeneratedMetamodelConsumer(XtextGrammarTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer) {
		this.generatedMetamodelConsumer = generatedMetamodelConsumer;
	}
	
	public void setReferencedMetamodelConsumer(XtextGrammarTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer) {
		this.referencedMetamodelConsumer = referencedMetamodelConsumer;
	}
	
}
