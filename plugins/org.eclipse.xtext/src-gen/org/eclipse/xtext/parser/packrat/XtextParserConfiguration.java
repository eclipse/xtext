/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextReferencedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextLexerRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTypeRefConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextActionConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextRuleCallConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class XtextParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private XtextGrammarConsumer grammarConsumer;
    private XtextAbstractRuleConsumer abstractRuleConsumer;
    private XtextAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
    private XtextGeneratedMetamodelConsumer generatedMetamodelConsumer;
    private XtextReferencedMetamodelConsumer referencedMetamodelConsumer;
    private XtextLexerRuleConsumer lexerRuleConsumer;
    private XtextParserRuleConsumer parserRuleConsumer;
    private XtextTypeRefConsumer typeRefConsumer;
    private XtextAlternativesConsumer alternativesConsumer;
    private XtextGroupConsumer groupConsumer;
    private XtextAbstractTokenConsumer abstractTokenConsumer;
    private XtextAssignmentConsumer assignmentConsumer;
    private XtextActionConsumer actionConsumer;
    private XtextAbstractTerminalConsumer abstractTerminalConsumer;
    private XtextCrossReferenceConsumer crossReferenceConsumer;
    private XtextParenthesizedElementConsumer parenthesizedElementConsumer;
    private XtextKeywordConsumer keywordConsumer;
    private XtextRuleCallConsumer ruleCallConsumer;

	public XtextParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public XtextGrammarConsumer getRootConsumer() {
		return grammarConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		grammarConsumer = new XtextGrammarConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		abstractRuleConsumer = new XtextAbstractRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractMetamodelDeclarationConsumer = new XtextAbstractMetamodelDeclarationConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		generatedMetamodelConsumer = new XtextGeneratedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		referencedMetamodelConsumer = new XtextReferencedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		lexerRuleConsumer = new XtextLexerRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parserRuleConsumer = new XtextParserRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeRefConsumer = new XtextTypeRefConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		alternativesConsumer = new XtextAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		groupConsumer = new XtextGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTokenConsumer = new XtextAbstractTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		assignmentConsumer = new XtextAssignmentConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		actionConsumer = new XtextActionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTerminalConsumer = new XtextAbstractTerminalConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		crossReferenceConsumer = new XtextCrossReferenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedElementConsumer = new XtextParenthesizedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		keywordConsumer = new XtextKeywordConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		ruleCallConsumer = new XtextRuleCallConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getGrammarConsumer().setAbstractMetamodelDeclarationConsumer(getAbstractMetamodelDeclarationConsumer());
		getGrammarConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());
		getGrammarConsumer().setIdConsumer(getIdConsumer());

		getAbstractRuleConsumer().setLexerRuleConsumer(getLexerRuleConsumer());
		getAbstractRuleConsumer().setParserRuleConsumer(getParserRuleConsumer());

		getAbstractMetamodelDeclarationConsumer().setGeneratedMetamodelConsumer(getGeneratedMetamodelConsumer());
		getAbstractMetamodelDeclarationConsumer().setReferencedMetamodelConsumer(getReferencedMetamodelConsumer());

		getGeneratedMetamodelConsumer().setIdConsumer(getIdConsumer());
		getGeneratedMetamodelConsumer().setStringConsumer(getStringConsumer());

		getReferencedMetamodelConsumer().setIdConsumer(getIdConsumer());
		getReferencedMetamodelConsumer().setStringConsumer(getStringConsumer());

		getLexerRuleConsumer().setIdConsumer(getIdConsumer());
		getLexerRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getLexerRuleConsumer().setStringConsumer(getStringConsumer());

		getParserRuleConsumer().setIdConsumer(getIdConsumer());
		getParserRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getParserRuleConsumer().setAlternativesConsumer(getAlternativesConsumer());

		getTypeRefConsumer().setIdConsumer(getIdConsumer());

		getAlternativesConsumer().setGroupConsumer(getGroupConsumer());

		getGroupConsumer().setAbstractTokenConsumer(getAbstractTokenConsumer());

		getAbstractTokenConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAbstractTokenConsumer().setAssignmentConsumer(getAssignmentConsumer());
		getAbstractTokenConsumer().setActionConsumer(getActionConsumer());

		getAssignmentConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAssignmentConsumer().setIdConsumer(getIdConsumer());

		getActionConsumer().setIdConsumer(getIdConsumer());
		getActionConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getAbstractTerminalConsumer().setKeywordConsumer(getKeywordConsumer());
		getAbstractTerminalConsumer().setCrossReferenceConsumer(getCrossReferenceConsumer());
		getAbstractTerminalConsumer().setParenthesizedElementConsumer(getParenthesizedElementConsumer());
		getAbstractTerminalConsumer().setRuleCallConsumer(getRuleCallConsumer());

		getCrossReferenceConsumer().setIdConsumer(getIdConsumer());
		getCrossReferenceConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getParenthesizedElementConsumer().setAlternativesConsumer(getAlternativesConsumer());

		getKeywordConsumer().setStringConsumer(getStringConsumer());

		getRuleCallConsumer().setIdConsumer(getIdConsumer());

		getIdConsumer().initFields(this);
		getIntConsumer().initFields(this);
		getStringConsumer().initFields(this);
		getMlCommentConsumer().initFields(this);
		getSlCommentConsumer().initFields(this);
		getWsConsumer().initFields(this);
		getAnyOtherConsumer().initFields(this);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public XtextGrammarConsumer getGrammarConsumer() {
    	return grammarConsumer;
    }


    public XtextAbstractRuleConsumer getAbstractRuleConsumer() {
    	return abstractRuleConsumer;
    }


    public XtextAbstractMetamodelDeclarationConsumer getAbstractMetamodelDeclarationConsumer() {
    	return abstractMetamodelDeclarationConsumer;
    }


    public XtextGeneratedMetamodelConsumer getGeneratedMetamodelConsumer() {
    	return generatedMetamodelConsumer;
    }


    public XtextReferencedMetamodelConsumer getReferencedMetamodelConsumer() {
    	return referencedMetamodelConsumer;
    }


    public XtextLexerRuleConsumer getLexerRuleConsumer() {
    	return lexerRuleConsumer;
    }


    public XtextParserRuleConsumer getParserRuleConsumer() {
    	return parserRuleConsumer;
    }


    public XtextTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }


    public XtextAlternativesConsumer getAlternativesConsumer() {
    	return alternativesConsumer;
    }


    public XtextGroupConsumer getGroupConsumer() {
    	return groupConsumer;
    }


    public XtextAbstractTokenConsumer getAbstractTokenConsumer() {
    	return abstractTokenConsumer;
    }


    public XtextAssignmentConsumer getAssignmentConsumer() {
    	return assignmentConsumer;
    }


    public XtextActionConsumer getActionConsumer() {
    	return actionConsumer;
    }


    public XtextAbstractTerminalConsumer getAbstractTerminalConsumer() {
    	return abstractTerminalConsumer;
    }


    public XtextCrossReferenceConsumer getCrossReferenceConsumer() {
    	return crossReferenceConsumer;
    }


    public XtextParenthesizedElementConsumer getParenthesizedElementConsumer() {
    	return parenthesizedElementConsumer;
    }


    public XtextKeywordConsumer getKeywordConsumer() {
    	return keywordConsumer;
    }


    public XtextRuleCallConsumer getRuleCallConsumer() {
    	return ruleCallConsumer;
    }


    public XtextBuiltinIDConsumer getIdConsumer() {
    	return getXtextBuiltinConfiguration().getIdConsumer();
    }


    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getXtextBuiltinConfiguration().getIntConsumer();
    }


    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getXtextBuiltinConfiguration().getStringConsumer();
    }


    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getMlCommentConsumer();
    }


    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getSlCommentConsumer();
    }


    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getXtextBuiltinConfiguration().getWsConsumer();
    }


    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getXtextBuiltinConfiguration().getAnyOtherConsumer();
    }



}
