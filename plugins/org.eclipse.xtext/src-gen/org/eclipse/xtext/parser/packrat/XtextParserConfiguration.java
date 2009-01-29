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
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTypeRefConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextActionConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalTokenElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextUpToTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextWildcardConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextCharacterRangeConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedTerminalElementConsumer;
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
    private XtextTerminalRuleConsumer terminalRuleConsumer;
    private XtextTypeRefConsumer typeRefConsumer;
    private XtextAlternativesConsumer alternativesConsumer;
    private XtextTerminalAlternativesConsumer terminalAlternativesConsumer;
    private XtextGroupConsumer groupConsumer;
    private XtextTerminalGroupConsumer terminalGroupConsumer;
    private XtextAbstractTokenConsumer abstractTokenConsumer;
    private XtextTerminalTokenConsumer terminalTokenConsumer;
    private XtextAssignmentConsumer assignmentConsumer;
    private XtextActionConsumer actionConsumer;
    private XtextAbstractTerminalConsumer abstractTerminalConsumer;
    private XtextTerminalTokenElementConsumer terminalTokenElementConsumer;
    private XtextAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
    private XtextNegatedTokenConsumer negatedTokenConsumer;
    private XtextUpToTokenConsumer upToTokenConsumer;
    private XtextWildcardConsumer wildcardConsumer;
    private XtextCharacterRangeConsumer characterRangeConsumer;
    private XtextCrossReferenceConsumer crossReferenceConsumer;
    private XtextParenthesizedElementConsumer parenthesizedElementConsumer;
    private XtextParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
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
		terminalRuleConsumer = new XtextTerminalRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeRefConsumer = new XtextTypeRefConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		alternativesConsumer = new XtextAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalAlternativesConsumer = new XtextTerminalAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		groupConsumer = new XtextGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalGroupConsumer = new XtextTerminalGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTokenConsumer = new XtextAbstractTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalTokenConsumer = new XtextTerminalTokenConsumer(
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
		terminalTokenElementConsumer = new XtextTerminalTokenElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractNegatedTokenConsumer = new XtextAbstractNegatedTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		negatedTokenConsumer = new XtextNegatedTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		upToTokenConsumer = new XtextUpToTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		wildcardConsumer = new XtextWildcardConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		characterRangeConsumer = new XtextCharacterRangeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		crossReferenceConsumer = new XtextCrossReferenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedElementConsumer = new XtextParenthesizedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedTerminalElementConsumer = new XtextParenthesizedTerminalElementConsumer(
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
		getAbstractRuleConsumer().setTerminalRuleConsumer(getTerminalRuleConsumer());

		getAbstractMetamodelDeclarationConsumer().setGeneratedMetamodelConsumer(getGeneratedMetamodelConsumer());
		getAbstractMetamodelDeclarationConsumer().setReferencedMetamodelConsumer(getReferencedMetamodelConsumer());

		getGeneratedMetamodelConsumer().setIdConsumer(getIdConsumer());
		getGeneratedMetamodelConsumer().setStringConsumer(getStringConsumer());

		getReferencedMetamodelConsumer().setIdConsumer(getIdConsumer());
		getReferencedMetamodelConsumer().setStringConsumer(getStringConsumer());

		getLexerRuleConsumer().setIdConsumer(getIdConsumer());
		getLexerRuleConsumer().setStringConsumer(getStringConsumer());
		getLexerRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getParserRuleConsumer().setAlternativesConsumer(getAlternativesConsumer());
		getParserRuleConsumer().setIdConsumer(getIdConsumer());
		getParserRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getTerminalRuleConsumer().setIdConsumer(getIdConsumer());
		getTerminalRuleConsumer().setTerminalAlternativesConsumer(getTerminalAlternativesConsumer());
		getTerminalRuleConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getTypeRefConsumer().setIdConsumer(getIdConsumer());

		getAlternativesConsumer().setGroupConsumer(getGroupConsumer());

		getTerminalAlternativesConsumer().setTerminalGroupConsumer(getTerminalGroupConsumer());

		getGroupConsumer().setAbstractTokenConsumer(getAbstractTokenConsumer());

		getTerminalGroupConsumer().setTerminalTokenConsumer(getTerminalTokenConsumer());

		getAbstractTokenConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAbstractTokenConsumer().setActionConsumer(getActionConsumer());
		getAbstractTokenConsumer().setAssignmentConsumer(getAssignmentConsumer());

		getTerminalTokenConsumer().setTerminalTokenElementConsumer(getTerminalTokenElementConsumer());

		getAssignmentConsumer().setAbstractTerminalConsumer(getAbstractTerminalConsumer());
		getAssignmentConsumer().setIdConsumer(getIdConsumer());

		getActionConsumer().setIdConsumer(getIdConsumer());
		getActionConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getAbstractTerminalConsumer().setCrossReferenceConsumer(getCrossReferenceConsumer());
		getAbstractTerminalConsumer().setKeywordConsumer(getKeywordConsumer());
		getAbstractTerminalConsumer().setParenthesizedElementConsumer(getParenthesizedElementConsumer());
		getAbstractTerminalConsumer().setRuleCallConsumer(getRuleCallConsumer());

		getTerminalTokenElementConsumer().setAbstractNegatedTokenConsumer(getAbstractNegatedTokenConsumer());
		getTerminalTokenElementConsumer().setCharacterRangeConsumer(getCharacterRangeConsumer());
		getTerminalTokenElementConsumer().setParenthesizedTerminalElementConsumer(getParenthesizedTerminalElementConsumer());
		getTerminalTokenElementConsumer().setRuleCallConsumer(getRuleCallConsumer());
		getTerminalTokenElementConsumer().setWildcardConsumer(getWildcardConsumer());

		getAbstractNegatedTokenConsumer().setNegatedTokenConsumer(getNegatedTokenConsumer());
		getAbstractNegatedTokenConsumer().setUpToTokenConsumer(getUpToTokenConsumer());

		getNegatedTokenConsumer().setTerminalTokenElementConsumer(getTerminalTokenElementConsumer());

		getUpToTokenConsumer().setTerminalTokenElementConsumer(getTerminalTokenElementConsumer());

		getCharacterRangeConsumer().setKeywordConsumer(getKeywordConsumer());

		getCrossReferenceConsumer().setIdConsumer(getIdConsumer());
		getCrossReferenceConsumer().setTypeRefConsumer(getTypeRefConsumer());

		getParenthesizedElementConsumer().setAlternativesConsumer(getAlternativesConsumer());

		getParenthesizedTerminalElementConsumer().setTerminalAlternativesConsumer(getTerminalAlternativesConsumer());

		getKeywordConsumer().setStringConsumer(getStringConsumer());

		getRuleCallConsumer().setIdConsumer(getIdConsumer());

		getGrammarConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$13$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getGrammarConsumer().setKeyword$18$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$22$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getGrammarConsumer().setRuleCall$11$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$15$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$20$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$24$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getGeneratedMetamodelConsumer().setCrossReference$8$Delimiter(XtextDelimiters.crossReference$53$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$4$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$6$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$13$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getReferencedMetamodelConsumer().setCrossReference$5$Delimiter(XtextDelimiters.crossReference$53$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setRuleCall$10$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getLexerRuleConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$15$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getLexerRuleConsumer().setKeyword$18$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getLexerRuleConsumer().setRuleCall$10$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getLexerRuleConsumer().setRuleCall$17$Delimiter(XtextDelimiters.crossReference$53$Delimiter);
		getParserRuleConsumer().setCrossReference$20$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getParserRuleConsumer().setCrossReference$25$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getParserRuleConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$16$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$17$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$23$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$27$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$28$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$31$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setRuleCall$7$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getTerminalRuleConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$14$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalRuleConsumer().setKeyword$17$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalRuleConsumer().setRuleCall$9$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setCrossReference$4$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setCrossReference$8$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setKeyword$6$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAlternativesConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalAlternativesConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$6$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setRuleCall$4$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getActionConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$14$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$19$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$20$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$21$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$22$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getActionConsumer().setRuleCall$16$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getNegatedTokenConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getUpToTokenConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getWildcardConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getCharacterRangeConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setCrossReference$10$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
		getCrossReferenceConsumer().setKeyword$4$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParenthesizedElementConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParenthesizedElementConsumer().setKeyword$5$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$5$Delimiter(XtextDelimiters.keyword$16$Delimiter);
		getKeywordConsumer().setRuleCall$2$Delimiter(XtextDelimiters.crossReference$53$Delimiter);
		getRuleCallConsumer().setCrossReference$2$Delimiter(XtextDelimiters.ruleCall$14$Delimiter);
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

    public XtextTerminalRuleConsumer getTerminalRuleConsumer() {
    	return terminalRuleConsumer;
    }

    public XtextTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }

    public XtextAlternativesConsumer getAlternativesConsumer() {
    	return alternativesConsumer;
    }

    public XtextTerminalAlternativesConsumer getTerminalAlternativesConsumer() {
    	return terminalAlternativesConsumer;
    }

    public XtextGroupConsumer getGroupConsumer() {
    	return groupConsumer;
    }

    public XtextTerminalGroupConsumer getTerminalGroupConsumer() {
    	return terminalGroupConsumer;
    }

    public XtextAbstractTokenConsumer getAbstractTokenConsumer() {
    	return abstractTokenConsumer;
    }

    public XtextTerminalTokenConsumer getTerminalTokenConsumer() {
    	return terminalTokenConsumer;
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

    public XtextTerminalTokenElementConsumer getTerminalTokenElementConsumer() {
    	return terminalTokenElementConsumer;
    }

    public XtextAbstractNegatedTokenConsumer getAbstractNegatedTokenConsumer() {
    	return abstractNegatedTokenConsumer;
    }

    public XtextNegatedTokenConsumer getNegatedTokenConsumer() {
    	return negatedTokenConsumer;
    }

    public XtextUpToTokenConsumer getUpToTokenConsumer() {
    	return upToTokenConsumer;
    }

    public XtextWildcardConsumer getWildcardConsumer() {
    	return wildcardConsumer;
    }

    public XtextCharacterRangeConsumer getCharacterRangeConsumer() {
    	return characterRangeConsumer;
    }

    public XtextCrossReferenceConsumer getCrossReferenceConsumer() {
    	return crossReferenceConsumer;
    }

    public XtextParenthesizedElementConsumer getParenthesizedElementConsumer() {
    	return parenthesizedElementConsumer;
    }

    public XtextParenthesizedTerminalElementConsumer getParenthesizedTerminalElementConsumer() {
    	return parenthesizedTerminalElementConsumer;
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
