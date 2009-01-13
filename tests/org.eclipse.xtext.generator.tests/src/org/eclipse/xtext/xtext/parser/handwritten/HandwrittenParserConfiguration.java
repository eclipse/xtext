/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.AbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.AbstractRuleConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.GeneratedMetamodelConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.GrammarConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.LexerRuleConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.ParserRuleConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.ReferencedMetamodelConsumer;
import org.eclipse.xtext.xtext.parser.handwritten.consumers.TypeRefConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HandwrittenParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinIDConsumer idConsumer;
	
	private XtextBuiltinINTConsumer intConsumer;
	
	private XtextBuiltinSTRINGConsumer stringConsumer;
	
	private XtextBuiltinML_COMMENTConsumer mlCommentConsumer;
	
	private XtextBuiltinSL_COMMENTConsumer slCommentConsumer;
	
	private XtextBuiltinWSConsumer wsConsumer;
	
	private XtextBuiltinANY_OTHERConsumer anyOtherConsumer;
	
	private GrammarConsumer grammarConsumer;
	
	private AbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
	
	private GeneratedMetamodelConsumer generatedMetamodelConsumer;
	
	private ReferencedMetamodelConsumer referencedMetamodelConsumer;
	
	private AbstractRuleConsumer abstractRuleConsumer;
	
	private LexerRuleConsumer lexerRuleConsumer;
	
	private ParserRuleConsumer parserRuleConsumer;
	
	private TypeRefConsumer typeRefConsumer;
	
	public HandwrittenParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public void createNonTerminalConsumers() {
		grammarConsumer = new GrammarConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), new ITerminalConsumer[]{ 
					getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() });
		abstractMetamodelDeclarationConsumer = new AbstractMetamodelDeclarationConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		generatedMetamodelConsumer = new GeneratedMetamodelConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		referencedMetamodelConsumer = new ReferencedMetamodelConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		abstractRuleConsumer = new AbstractRuleConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		lexerRuleConsumer = new LexerRuleConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		parserRuleConsumer = new ParserRuleConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
		typeRefConsumer = new TypeRefConsumer(
				getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null);
	}

	public void createTerminalConsumers() {
		idConsumer = new XtextBuiltinIDConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		intConsumer = new XtextBuiltinINTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		stringConsumer = new XtextBuiltinSTRINGConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		mlCommentConsumer = new XtextBuiltinML_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		slCommentConsumer = new XtextBuiltinSL_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		wsConsumer = new XtextBuiltinWSConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		anyOtherConsumer = new XtextBuiltinANY_OTHERConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
	}
	
	public void configureConsumers() {
		grammarConsumer.setAbstractMetamodelDeclarationConsumer(getAbstractMetamodelDeclarationConsumer());
		grammarConsumer.setIdConsumer(getIdConsumer());
		grammarConsumer.setAbstractRuleConsumer(getAbstractRuleConsumer());
		
		abstractMetamodelDeclarationConsumer.setGeneratedMetamodelConsumer(getGeneratedMetamodelConsumer());
		abstractMetamodelDeclarationConsumer.setReferencedMetamodelConsumer(getReferencedMetamodelConsumer());
		
		generatedMetamodelConsumer.setIdConsumer(getIdConsumer());
		generatedMetamodelConsumer.setStringConsumer(getStringConsumer());
		
		referencedMetamodelConsumer.setIdConsumer(getIdConsumer());
		referencedMetamodelConsumer.setStringConsumer(getStringConsumer());
		
		abstractRuleConsumer.setLexerRuleConsumer(getLexerRuleConsumer());
		abstractRuleConsumer.setParserRuleConsumer(getParserRuleConsumer());
		
		lexerRuleConsumer.setIdConsumer(getIdConsumer());
		lexerRuleConsumer.setStringConsumer(getStringConsumer());
		lexerRuleConsumer.setTypeRefConsumer(getTypeRefConsumer());

		typeRefConsumer.setIdConsumer(getIdConsumer());
	}

	public INonTerminalConsumer getRootConsumer() {
		return grammarConsumer;
	}

	public XtextBuiltinIDConsumer getIdConsumer() {
		return idConsumer;
	}

	public XtextBuiltinINTConsumer getIntConsumer() {
		return intConsumer;
	}

	public XtextBuiltinSTRINGConsumer getStringConsumer() {
		return stringConsumer;
	}

	public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
		return mlCommentConsumer;
	}

	public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
		return slCommentConsumer;
	}

	public XtextBuiltinWSConsumer getWsConsumer() {
		return wsConsumer;
	}

	public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
		return anyOtherConsumer;
	}

	public GrammarConsumer getGrammarConsumer() {
		return grammarConsumer;
	}

	public AbstractMetamodelDeclarationConsumer getAbstractMetamodelDeclarationConsumer() {
		return abstractMetamodelDeclarationConsumer;
	}

	public GeneratedMetamodelConsumer getGeneratedMetamodelConsumer() {
		return generatedMetamodelConsumer;
	}

	public ReferencedMetamodelConsumer getReferencedMetamodelConsumer() {
		return referencedMetamodelConsumer;
	}

	public AbstractRuleConsumer getAbstractRuleConsumer() {
		return abstractRuleConsumer;
	}

	public LexerRuleConsumer getLexerRuleConsumer() {
		return lexerRuleConsumer;
	}

	public ParserRuleConsumer getParserRuleConsumer() {
		return parserRuleConsumer;
	}

	public TypeRefConsumer getTypeRefConsumer() {
		return typeRefConsumer;
	}
	
}
