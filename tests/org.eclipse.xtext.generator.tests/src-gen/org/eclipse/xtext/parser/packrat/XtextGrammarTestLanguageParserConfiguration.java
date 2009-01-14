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

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGrammarConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageReferencedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageLexerRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageActionConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageRuleCallConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class XtextGrammarTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private XtextGrammarTestLanguageGrammarConsumer grammarConsumer;
    private XtextGrammarTestLanguageAbstractRuleConsumer abstractRuleConsumer;
    private XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
    private XtextGrammarTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer;
    private XtextGrammarTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer;
    private XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer;
    private XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer;
    private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
    private XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer;
    private XtextGrammarTestLanguageGroupConsumer groupConsumer;
    private XtextGrammarTestLanguageAbstractTokenConsumer abstractTokenConsumer;
    private XtextGrammarTestLanguageAssignmentConsumer assignmentConsumer;
    private XtextGrammarTestLanguageActionConsumer actionConsumer;
    private XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
    private XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer;
    private XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
    private XtextGrammarTestLanguageKeywordConsumer keywordConsumer;
    private XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextGrammarTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public XtextGrammarTestLanguageGrammarConsumer getRootConsumer() {
		return grammarConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		grammarConsumer = new XtextGrammarTestLanguageGrammarConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		abstractRuleConsumer = new XtextGrammarTestLanguageAbstractRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractMetamodelDeclarationConsumer = new XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		generatedMetamodelConsumer = new XtextGrammarTestLanguageGeneratedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		referencedMetamodelConsumer = new XtextGrammarTestLanguageReferencedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		lexerRuleConsumer = new XtextGrammarTestLanguageLexerRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parserRuleConsumer = new XtextGrammarTestLanguageParserRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeRefConsumer = new XtextGrammarTestLanguageTypeRefConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		alternativesConsumer = new XtextGrammarTestLanguageAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		groupConsumer = new XtextGrammarTestLanguageGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTokenConsumer = new XtextGrammarTestLanguageAbstractTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		assignmentConsumer = new XtextGrammarTestLanguageAssignmentConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		actionConsumer = new XtextGrammarTestLanguageActionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTerminalConsumer = new XtextGrammarTestLanguageAbstractTerminalConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		crossReferenceConsumer = new XtextGrammarTestLanguageCrossReferenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedElementConsumer = new XtextGrammarTestLanguageParenthesizedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		keywordConsumer = new XtextGrammarTestLanguageKeywordConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		ruleCallConsumer = new XtextGrammarTestLanguageRuleCallConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getGrammarConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());
		getGrammarConsumer().setAbstractMetamodelDeclarationConsumer(getAbstractMetamodelDeclarationConsumer());
		getGrammarConsumer().setIdConsumer(getIdConsumer());

		getAbstractRuleConsumer().setParserRuleConsumer(getParserRuleConsumer());
		getAbstractRuleConsumer().setLexerRuleConsumer(getLexerRuleConsumer());

		getAbstractMetamodelDeclarationConsumer().setGeneratedMetamodelConsumer(getGeneratedMetamodelConsumer());
		getAbstractMetamodelDeclarationConsumer().setReferencedMetamodelConsumer(getReferencedMetamodelConsumer());

		getGeneratedMetamodelConsumer().setStringConsumer(getStringConsumer());
		getGeneratedMetamodelConsumer().setIdConsumer(getIdConsumer());

		getReferencedMetamodelConsumer().setStringConsumer(getStringConsumer());
		getReferencedMetamodelConsumer().setIdConsumer(getIdConsumer());

		getLexerRuleConsumer().setStringConsumer(getStringConsumer());
		getLexerRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getLexerRuleConsumer().setIdConsumer(getIdConsumer());

		getParserRuleConsumer().setAlternativesConsumer(getAlternativesConsumer());
		getParserRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getParserRuleConsumer().setIdConsumer(getIdConsumer());

		getTypeRefConsumer().setIdConsumer(getIdConsumer());

		getAlternativesConsumer().setGroupConsumer(getGroupConsumer());

		getGroupConsumer().setAbstractTokenConsumer(getAbstractTokenConsumer());

		getAbstractTokenConsumer().setActionConsumer(getActionConsumer());
		getAbstractTokenConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAbstractTokenConsumer().setAssignmentConsumer(getAssignmentConsumer());

		getAssignmentConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAssignmentConsumer().setIdConsumer(getIdConsumer());

		getActionConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getActionConsumer().setIdConsumer(getIdConsumer());

		getAbstractTerminalConsumer().setKeywordConsumer(getKeywordConsumer());
		getAbstractTerminalConsumer().setCrossReferenceConsumer(getCrossReferenceConsumer());
		getAbstractTerminalConsumer().setParenthesizedElementConsumer(getParenthesizedElementConsumer());
		getAbstractTerminalConsumer().setRuleCallConsumer(getRuleCallConsumer());

		getCrossReferenceConsumer().setTypeRefConsumer(getTypeRefConsumer());
		getCrossReferenceConsumer().setIdConsumer(getIdConsumer());

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
	
    public XtextGrammarTestLanguageGrammarConsumer getGrammarConsumer() {
    	return grammarConsumer;
    }

    public XtextGrammarTestLanguageAbstractRuleConsumer getAbstractRuleConsumer() {
    	return abstractRuleConsumer;
    }

    public XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer getAbstractMetamodelDeclarationConsumer() {
    	return abstractMetamodelDeclarationConsumer;
    }

    public XtextGrammarTestLanguageGeneratedMetamodelConsumer getGeneratedMetamodelConsumer() {
    	return generatedMetamodelConsumer;
    }

    public XtextGrammarTestLanguageReferencedMetamodelConsumer getReferencedMetamodelConsumer() {
    	return referencedMetamodelConsumer;
    }

    public XtextGrammarTestLanguageLexerRuleConsumer getLexerRuleConsumer() {
    	return lexerRuleConsumer;
    }

    public XtextGrammarTestLanguageParserRuleConsumer getParserRuleConsumer() {
    	return parserRuleConsumer;
    }

    public XtextGrammarTestLanguageTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }

    public XtextGrammarTestLanguageAlternativesConsumer getAlternativesConsumer() {
    	return alternativesConsumer;
    }

    public XtextGrammarTestLanguageGroupConsumer getGroupConsumer() {
    	return groupConsumer;
    }

    public XtextGrammarTestLanguageAbstractTokenConsumer getAbstractTokenConsumer() {
    	return abstractTokenConsumer;
    }

    public XtextGrammarTestLanguageAssignmentConsumer getAssignmentConsumer() {
    	return assignmentConsumer;
    }

    public XtextGrammarTestLanguageActionConsumer getActionConsumer() {
    	return actionConsumer;
    }

    public XtextGrammarTestLanguageAbstractTerminalConsumer getAbstractTerminalConsumer() {
    	return abstractTerminalConsumer;
    }

    public XtextGrammarTestLanguageCrossReferenceConsumer getCrossReferenceConsumer() {
    	return crossReferenceConsumer;
    }

    public XtextGrammarTestLanguageParenthesizedElementConsumer getParenthesizedElementConsumer() {
    	return parenthesizedElementConsumer;
    }

    public XtextGrammarTestLanguageKeywordConsumer getKeywordConsumer() {
    	return keywordConsumer;
    }

    public XtextGrammarTestLanguageRuleCallConsumer getRuleCallConsumer() {
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
