/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageGrammarConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageReferencedMetamodelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageLexerRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTypeRefConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAlternativesConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalAlternativesConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageGroupConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalGroupConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAssignmentConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageActionConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalTokenElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageUpToTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageWildcardConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCharacterRangeConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageRuleCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageINTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageSTRINGConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageWSConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageANY_OTHERConsumer;

public class XtextTerminalsTestLanguageParserConfiguration extends AbstractParserConfiguration {

    private XtextTerminalsTestLanguageGrammarConsumer grammarConsumer;
    private XtextTerminalsTestLanguageAbstractRuleConsumer abstractRuleConsumer;
    private XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
    private XtextTerminalsTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer;
    private XtextTerminalsTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer;
    private XtextTerminalsTestLanguageLexerRuleConsumer lexerRuleConsumer;
    private XtextTerminalsTestLanguageParserRuleConsumer parserRuleConsumer;
    private XtextTerminalsTestLanguageTerminalRuleConsumer terminalRuleConsumer;
    private XtextTerminalsTestLanguageTypeRefConsumer typeRefConsumer;
    private XtextTerminalsTestLanguageAlternativesConsumer alternativesConsumer;
    private XtextTerminalsTestLanguageTerminalAlternativesConsumer terminalAlternativesConsumer;
    private XtextTerminalsTestLanguageGroupConsumer groupConsumer;
    private XtextTerminalsTestLanguageTerminalGroupConsumer terminalGroupConsumer;
    private XtextTerminalsTestLanguageAbstractTokenConsumer abstractTokenConsumer;
    private XtextTerminalsTestLanguageTerminalTokenConsumer terminalTokenConsumer;
    private XtextTerminalsTestLanguageAssignmentConsumer assignmentConsumer;
    private XtextTerminalsTestLanguageActionConsumer actionConsumer;
    private XtextTerminalsTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
    private XtextTerminalsTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer;
    private XtextTerminalsTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
    private XtextTerminalsTestLanguageNegatedTokenConsumer negatedTokenConsumer;
    private XtextTerminalsTestLanguageUpToTokenConsumer upToTokenConsumer;
    private XtextTerminalsTestLanguageWildcardConsumer wildcardConsumer;
    private XtextTerminalsTestLanguageCharacterRangeConsumer characterRangeConsumer;
    private XtextTerminalsTestLanguageCrossReferenceConsumer crossReferenceConsumer;
    private XtextTerminalsTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
    private XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
    private XtextTerminalsTestLanguageKeywordConsumer keywordConsumer;
    private XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer;
    private XtextTerminalsTestLanguageIDConsumer idConsumer;
    private XtextTerminalsTestLanguageINTConsumer intConsumer;
    private XtextTerminalsTestLanguageSTRINGConsumer stringConsumer;
    private XtextTerminalsTestLanguageML_COMMENTConsumer mlCommentConsumer;
    private XtextTerminalsTestLanguageSL_COMMENTConsumer slCommentConsumer;
    private XtextTerminalsTestLanguageWSConsumer wsConsumer;
    private XtextTerminalsTestLanguageANY_OTHERConsumer anyOtherConsumer;

	public XtextTerminalsTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public XtextTerminalsTestLanguageGrammarConsumer getRootConsumer() {
		return grammarConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		grammarConsumer = new XtextTerminalsTestLanguageGrammarConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		abstractRuleConsumer = new XtextTerminalsTestLanguageAbstractRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractMetamodelDeclarationConsumer = new XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		generatedMetamodelConsumer = new XtextTerminalsTestLanguageGeneratedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		referencedMetamodelConsumer = new XtextTerminalsTestLanguageReferencedMetamodelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		lexerRuleConsumer = new XtextTerminalsTestLanguageLexerRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parserRuleConsumer = new XtextTerminalsTestLanguageParserRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalRuleConsumer = new XtextTerminalsTestLanguageTerminalRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeRefConsumer = new XtextTerminalsTestLanguageTypeRefConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		alternativesConsumer = new XtextTerminalsTestLanguageAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalAlternativesConsumer = new XtextTerminalsTestLanguageTerminalAlternativesConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		groupConsumer = new XtextTerminalsTestLanguageGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalGroupConsumer = new XtextTerminalsTestLanguageTerminalGroupConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTokenConsumer = new XtextTerminalsTestLanguageAbstractTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalTokenConsumer = new XtextTerminalsTestLanguageTerminalTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		assignmentConsumer = new XtextTerminalsTestLanguageAssignmentConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		actionConsumer = new XtextTerminalsTestLanguageActionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractTerminalConsumer = new XtextTerminalsTestLanguageAbstractTerminalConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		terminalTokenElementConsumer = new XtextTerminalsTestLanguageTerminalTokenElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractNegatedTokenConsumer = new XtextTerminalsTestLanguageAbstractNegatedTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		negatedTokenConsumer = new XtextTerminalsTestLanguageNegatedTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		upToTokenConsumer = new XtextTerminalsTestLanguageUpToTokenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		wildcardConsumer = new XtextTerminalsTestLanguageWildcardConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		characterRangeConsumer = new XtextTerminalsTestLanguageCharacterRangeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		crossReferenceConsumer = new XtextTerminalsTestLanguageCrossReferenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedElementConsumer = new XtextTerminalsTestLanguageParenthesizedElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parenthesizedTerminalElementConsumer = new XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		keywordConsumer = new XtextTerminalsTestLanguageKeywordConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		ruleCallConsumer = new XtextTerminalsTestLanguageRuleCallConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		idConsumer = new XtextTerminalsTestLanguageIDConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		intConsumer = new XtextTerminalsTestLanguageINTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		stringConsumer = new XtextTerminalsTestLanguageSTRINGConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		mlCommentConsumer = new XtextTerminalsTestLanguageML_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		slCommentConsumer = new XtextTerminalsTestLanguageSL_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		wsConsumer = new XtextTerminalsTestLanguageWSConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		anyOtherConsumer = new XtextTerminalsTestLanguageANY_OTHERConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
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

		getGrammarConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$9$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$13$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getGrammarConsumer().setKeyword$18$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$22$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getGrammarConsumer().setRuleCall$11$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$15$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$20$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getGrammarConsumer().setRuleCall$24$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getGeneratedMetamodelConsumer().setCrossReference$8$Delimiter(XtextTerminalsTestLanguageDelimiters.crossReference$53$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$4$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$11$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$6$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$13$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getReferencedMetamodelConsumer().setCrossReference$5$Delimiter(XtextTerminalsTestLanguageDelimiters.crossReference$53$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$3$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setRuleCall$10$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getLexerRuleConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$12$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$15$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getLexerRuleConsumer().setKeyword$18$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getLexerRuleConsumer().setRuleCall$10$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getLexerRuleConsumer().setRuleCall$17$Delimiter(XtextTerminalsTestLanguageDelimiters.crossReference$53$Delimiter);
		getParserRuleConsumer().setCrossReference$20$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getParserRuleConsumer().setCrossReference$25$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getParserRuleConsumer().setKeyword$9$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$17$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$18$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$23$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$27$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$28$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setKeyword$31$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParserRuleConsumer().setRuleCall$7$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getTerminalRuleConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$11$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$14$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalRuleConsumer().setKeyword$17$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalRuleConsumer().setRuleCall$9$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setCrossReference$4$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setCrossReference$8$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getTypeRefConsumer().setKeyword$6$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAlternativesConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalAlternativesConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$10$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$11$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAbstractTokenConsumer().setKeyword$12$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$6$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getTerminalTokenConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$9$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setKeyword$10$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getAssignmentConsumer().setRuleCall$4$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getActionConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$10$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$11$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$14$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$19$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$20$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setKeyword$21$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$22$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getActionConsumer().setRuleCall$16$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getNegatedTokenConsumer().setKeyword$2$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getUpToTokenConsumer().setKeyword$2$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getWildcardConsumer().setKeyword$2$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getCharacterRangeConsumer().setKeyword$7$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setCrossReference$10$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
		getCrossReferenceConsumer().setKeyword$4$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setKeyword$8$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getCrossReferenceConsumer().setKeyword$12$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParenthesizedElementConsumer().setKeyword$3$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParenthesizedElementConsumer().setKeyword$5$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$3$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$5$Delimiter(XtextTerminalsTestLanguageDelimiters.keyword$16$Delimiter);
		getKeywordConsumer().setRuleCall$2$Delimiter(XtextTerminalsTestLanguageDelimiters.crossReference$53$Delimiter);
		getRuleCallConsumer().setCrossReference$2$Delimiter(XtextTerminalsTestLanguageDelimiters.ruleCall$14$Delimiter);
	}
	
    public XtextTerminalsTestLanguageGrammarConsumer getGrammarConsumer() {
    	return grammarConsumer;
    }

    public XtextTerminalsTestLanguageAbstractRuleConsumer getAbstractRuleConsumer() {
    	return abstractRuleConsumer;
    }

    public XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer getAbstractMetamodelDeclarationConsumer() {
    	return abstractMetamodelDeclarationConsumer;
    }

    public XtextTerminalsTestLanguageGeneratedMetamodelConsumer getGeneratedMetamodelConsumer() {
    	return generatedMetamodelConsumer;
    }

    public XtextTerminalsTestLanguageReferencedMetamodelConsumer getReferencedMetamodelConsumer() {
    	return referencedMetamodelConsumer;
    }

    public XtextTerminalsTestLanguageLexerRuleConsumer getLexerRuleConsumer() {
    	return lexerRuleConsumer;
    }

    public XtextTerminalsTestLanguageParserRuleConsumer getParserRuleConsumer() {
    	return parserRuleConsumer;
    }

    public XtextTerminalsTestLanguageTerminalRuleConsumer getTerminalRuleConsumer() {
    	return terminalRuleConsumer;
    }

    public XtextTerminalsTestLanguageTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }

    public XtextTerminalsTestLanguageAlternativesConsumer getAlternativesConsumer() {
    	return alternativesConsumer;
    }

    public XtextTerminalsTestLanguageTerminalAlternativesConsumer getTerminalAlternativesConsumer() {
    	return terminalAlternativesConsumer;
    }

    public XtextTerminalsTestLanguageGroupConsumer getGroupConsumer() {
    	return groupConsumer;
    }

    public XtextTerminalsTestLanguageTerminalGroupConsumer getTerminalGroupConsumer() {
    	return terminalGroupConsumer;
    }

    public XtextTerminalsTestLanguageAbstractTokenConsumer getAbstractTokenConsumer() {
    	return abstractTokenConsumer;
    }

    public XtextTerminalsTestLanguageTerminalTokenConsumer getTerminalTokenConsumer() {
    	return terminalTokenConsumer;
    }

    public XtextTerminalsTestLanguageAssignmentConsumer getAssignmentConsumer() {
    	return assignmentConsumer;
    }

    public XtextTerminalsTestLanguageActionConsumer getActionConsumer() {
    	return actionConsumer;
    }

    public XtextTerminalsTestLanguageAbstractTerminalConsumer getAbstractTerminalConsumer() {
    	return abstractTerminalConsumer;
    }

    public XtextTerminalsTestLanguageTerminalTokenElementConsumer getTerminalTokenElementConsumer() {
    	return terminalTokenElementConsumer;
    }

    public XtextTerminalsTestLanguageAbstractNegatedTokenConsumer getAbstractNegatedTokenConsumer() {
    	return abstractNegatedTokenConsumer;
    }

    public XtextTerminalsTestLanguageNegatedTokenConsumer getNegatedTokenConsumer() {
    	return negatedTokenConsumer;
    }

    public XtextTerminalsTestLanguageUpToTokenConsumer getUpToTokenConsumer() {
    	return upToTokenConsumer;
    }

    public XtextTerminalsTestLanguageWildcardConsumer getWildcardConsumer() {
    	return wildcardConsumer;
    }

    public XtextTerminalsTestLanguageCharacterRangeConsumer getCharacterRangeConsumer() {
    	return characterRangeConsumer;
    }

    public XtextTerminalsTestLanguageCrossReferenceConsumer getCrossReferenceConsumer() {
    	return crossReferenceConsumer;
    }

    public XtextTerminalsTestLanguageParenthesizedElementConsumer getParenthesizedElementConsumer() {
    	return parenthesizedElementConsumer;
    }

    public XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer getParenthesizedTerminalElementConsumer() {
    	return parenthesizedTerminalElementConsumer;
    }

    public XtextTerminalsTestLanguageKeywordConsumer getKeywordConsumer() {
    	return keywordConsumer;
    }

    public XtextTerminalsTestLanguageRuleCallConsumer getRuleCallConsumer() {
    	return ruleCallConsumer;
    }

    public XtextTerminalsTestLanguageIDConsumer getIdConsumer() {
    	return idConsumer;
    }

    public XtextTerminalsTestLanguageINTConsumer getIntConsumer() {
    	return intConsumer;
    }

    public XtextTerminalsTestLanguageSTRINGConsumer getStringConsumer() {
    	return stringConsumer;
    }

    public XtextTerminalsTestLanguageML_COMMENTConsumer getMlCommentConsumer() {
    	return mlCommentConsumer;
    }

    public XtextTerminalsTestLanguageSL_COMMENTConsumer getSlCommentConsumer() {
    	return slCommentConsumer;
    }

    public XtextTerminalsTestLanguageWSConsumer getWsConsumer() {
    	return wsConsumer;
    }

    public XtextTerminalsTestLanguageANY_OTHERConsumer getAnyOtherConsumer() {
    	return anyOtherConsumer;
    }


}
