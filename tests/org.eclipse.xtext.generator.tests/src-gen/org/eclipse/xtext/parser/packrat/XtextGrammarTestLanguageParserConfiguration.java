/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGrammarConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGeneratedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageReferencedMetamodelConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageLexerRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalGroupConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageActionConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalTokenElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageUpToTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageWildcardConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCharacterRangeConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageRuleCallConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class XtextGrammarTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private XtextGrammarTestLanguageGrammarConsumer grammarConsumer;
    private XtextGrammarTestLanguageAbstractRuleConsumer abstractRuleConsumer;
    private XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
    private XtextGrammarTestLanguageGeneratedMetamodelConsumer generatedMetamodelConsumer;
    private XtextGrammarTestLanguageReferencedMetamodelConsumer referencedMetamodelConsumer;
    private XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer;
    private XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer;
    private XtextGrammarTestLanguageTerminalRuleConsumer terminalRuleConsumer;
    private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
    private XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer;
    private XtextGrammarTestLanguageTerminalAlternativesConsumer terminalAlternativesConsumer;
    private XtextGrammarTestLanguageGroupConsumer groupConsumer;
    private XtextGrammarTestLanguageTerminalGroupConsumer terminalGroupConsumer;
    private XtextGrammarTestLanguageAbstractTokenConsumer abstractTokenConsumer;
    private XtextGrammarTestLanguageTerminalTokenConsumer terminalTokenConsumer;
    private XtextGrammarTestLanguageAssignmentConsumer assignmentConsumer;
    private XtextGrammarTestLanguageActionConsumer actionConsumer;
    private XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
    private XtextGrammarTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer;
    private XtextGrammarTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
    private XtextGrammarTestLanguageNegatedTokenConsumer negatedTokenConsumer;
    private XtextGrammarTestLanguageUpToTokenConsumer upToTokenConsumer;
    private XtextGrammarTestLanguageWildcardConsumer wildcardConsumer;
    private XtextGrammarTestLanguageCharacterRangeConsumer characterRangeConsumer;
    private XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer;
    private XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
    private XtextGrammarTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
    private XtextGrammarTestLanguageKeywordConsumer keywordConsumer;
    private XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextGrammarTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public XtextGrammarTestLanguageGrammarConsumer getRootConsumer() {
		return grammarConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		grammarConsumer = new XtextGrammarTestLanguageGrammarConsumer(
    		this, null
    	);
		abstractRuleConsumer = new XtextGrammarTestLanguageAbstractRuleConsumer(
    		this, null
    	);
		abstractMetamodelDeclarationConsumer = new XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer(
    		this, null
    	);
		generatedMetamodelConsumer = new XtextGrammarTestLanguageGeneratedMetamodelConsumer(
    		this, null
    	);
		referencedMetamodelConsumer = new XtextGrammarTestLanguageReferencedMetamodelConsumer(
    		this, null
    	);
		lexerRuleConsumer = new XtextGrammarTestLanguageLexerRuleConsumer(
    		this, null
    	);
		parserRuleConsumer = new XtextGrammarTestLanguageParserRuleConsumer(
    		this, null
    	);
		terminalRuleConsumer = new XtextGrammarTestLanguageTerminalRuleConsumer(
    		this, null
    	);
		typeRefConsumer = new XtextGrammarTestLanguageTypeRefConsumer(
    		this, null
    	);
		alternativesConsumer = new XtextGrammarTestLanguageAlternativesConsumer(
    		this, null
    	);
		terminalAlternativesConsumer = new XtextGrammarTestLanguageTerminalAlternativesConsumer(
    		this, null
    	);
		groupConsumer = new XtextGrammarTestLanguageGroupConsumer(
    		this, null
    	);
		terminalGroupConsumer = new XtextGrammarTestLanguageTerminalGroupConsumer(
    		this, null
    	);
		abstractTokenConsumer = new XtextGrammarTestLanguageAbstractTokenConsumer(
    		this, null
    	);
		terminalTokenConsumer = new XtextGrammarTestLanguageTerminalTokenConsumer(
    		this, null
    	);
		assignmentConsumer = new XtextGrammarTestLanguageAssignmentConsumer(
    		this, null
    	);
		actionConsumer = new XtextGrammarTestLanguageActionConsumer(
    		this, null
    	);
		abstractTerminalConsumer = new XtextGrammarTestLanguageAbstractTerminalConsumer(
    		this, null
    	);
		terminalTokenElementConsumer = new XtextGrammarTestLanguageTerminalTokenElementConsumer(
    		this, null
    	);
		abstractNegatedTokenConsumer = new XtextGrammarTestLanguageAbstractNegatedTokenConsumer(
    		this, null
    	);
		negatedTokenConsumer = new XtextGrammarTestLanguageNegatedTokenConsumer(
    		this, null
    	);
		upToTokenConsumer = new XtextGrammarTestLanguageUpToTokenConsumer(
    		this, null
    	);
		wildcardConsumer = new XtextGrammarTestLanguageWildcardConsumer(
    		this, null
    	);
		characterRangeConsumer = new XtextGrammarTestLanguageCharacterRangeConsumer(
    		this, null
    	);
		crossReferenceConsumer = new XtextGrammarTestLanguageCrossReferenceConsumer(
    		this, null
    	);
		parenthesizedElementConsumer = new XtextGrammarTestLanguageParenthesizedElementConsumer(
    		this, null
    	);
		parenthesizedTerminalElementConsumer = new XtextGrammarTestLanguageParenthesizedTerminalElementConsumer(
    		this, null
    	);
		keywordConsumer = new XtextGrammarTestLanguageKeywordConsumer(
    		this, null
    	);
		ruleCallConsumer = new XtextGrammarTestLanguageRuleCallConsumer(
    		this, null
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

		getGrammarConsumer().setCrossReference$34$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGrammarConsumer().setCrossReference$39$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGrammarConsumer().setKeyword$9$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGrammarConsumer().setKeyword$10$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGrammarConsumer().setKeyword$14$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getGrammarConsumer().setKeyword$19$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGrammarConsumer().setKeyword$23$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getGrammarConsumer().setKeyword$30$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGrammarConsumer().setKeyword$31$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getGrammarConsumer().setKeyword$37$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getGrammarConsumer().setKeyword$41$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getGrammarConsumer().setRuleCall$12$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGrammarConsumer().setRuleCall$16$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGrammarConsumer().setRuleCall$21$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGrammarConsumer().setRuleCall$25$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGeneratedMetamodelConsumer().setCrossReference$8$Delimiter(XtextGrammarTestLanguageDelimiters.crossReference$70$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$4$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$11$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$6$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$13$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getReferencedMetamodelConsumer().setCrossReference$5$Delimiter(XtextGrammarTestLanguageDelimiters.crossReference$70$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$3$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getReferencedMetamodelConsumer().setRuleCall$10$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getLexerRuleConsumer().setKeyword$12$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getLexerRuleConsumer().setKeyword$15$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getLexerRuleConsumer().setKeyword$18$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getLexerRuleConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getLexerRuleConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getLexerRuleConsumer().setRuleCall$17$Delimiter(XtextGrammarTestLanguageDelimiters.crossReference$70$Delimiter);
		getLexerRuleConsumer().setRuleCall$10$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getParserRuleConsumer().setCrossReference$20$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getParserRuleConsumer().setCrossReference$25$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getParserRuleConsumer().setKeyword$9$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getParserRuleConsumer().setKeyword$16$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getParserRuleConsumer().setKeyword$17$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParserRuleConsumer().setKeyword$23$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParserRuleConsumer().setKeyword$27$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParserRuleConsumer().setKeyword$28$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParserRuleConsumer().setKeyword$31$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParserRuleConsumer().setRuleCall$7$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getTerminalRuleConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getTerminalRuleConsumer().setKeyword$11$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getTerminalRuleConsumer().setKeyword$14$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalRuleConsumer().setKeyword$17$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalRuleConsumer().setRuleCall$9$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getTypeRefConsumer().setCrossReference$4$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getTypeRefConsumer().setCrossReference$8$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getTypeRefConsumer().setKeyword$6$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAlternativesConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalAlternativesConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAbstractTokenConsumer().setKeyword$10$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAbstractTokenConsumer().setKeyword$11$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAbstractTokenConsumer().setKeyword$12$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalTokenConsumer().setKeyword$6$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalTokenConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getTerminalTokenConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAssignmentConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAssignmentConsumer().setKeyword$9$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAssignmentConsumer().setKeyword$10$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getAssignmentConsumer().setRuleCall$4$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getActionConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setKeyword$10$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getActionConsumer().setKeyword$11$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setKeyword$14$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setKeyword$19$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setKeyword$20$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setKeyword$21$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$12$Delimiter);
		getActionConsumer().setKeyword$22$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getActionConsumer().setRuleCall$16$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getNegatedTokenConsumer().setKeyword$2$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getUpToTokenConsumer().setKeyword$2$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getWildcardConsumer().setKeyword$2$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getCharacterRangeConsumer().setKeyword$7$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getCrossReferenceConsumer().setCrossReference$10$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
		getCrossReferenceConsumer().setKeyword$4$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getCrossReferenceConsumer().setKeyword$8$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getCrossReferenceConsumer().setKeyword$12$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParenthesizedElementConsumer().setKeyword$3$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParenthesizedElementConsumer().setKeyword$5$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$3$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$5$Delimiter(XtextGrammarTestLanguageDelimiters.keyword$17$Delimiter);
		getKeywordConsumer().setRuleCall$2$Delimiter(XtextGrammarTestLanguageDelimiters.crossReference$70$Delimiter);
		getRuleCallConsumer().setCrossReference$2$Delimiter(XtextGrammarTestLanguageDelimiters.ruleCall$15$Delimiter);
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

    public XtextGrammarTestLanguageTerminalRuleConsumer getTerminalRuleConsumer() {
    	return terminalRuleConsumer;
    }

    public XtextGrammarTestLanguageTypeRefConsumer getTypeRefConsumer() {
    	return typeRefConsumer;
    }

    public XtextGrammarTestLanguageAlternativesConsumer getAlternativesConsumer() {
    	return alternativesConsumer;
    }

    public XtextGrammarTestLanguageTerminalAlternativesConsumer getTerminalAlternativesConsumer() {
    	return terminalAlternativesConsumer;
    }

    public XtextGrammarTestLanguageGroupConsumer getGroupConsumer() {
    	return groupConsumer;
    }

    public XtextGrammarTestLanguageTerminalGroupConsumer getTerminalGroupConsumer() {
    	return terminalGroupConsumer;
    }

    public XtextGrammarTestLanguageAbstractTokenConsumer getAbstractTokenConsumer() {
    	return abstractTokenConsumer;
    }

    public XtextGrammarTestLanguageTerminalTokenConsumer getTerminalTokenConsumer() {
    	return terminalTokenConsumer;
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

    public XtextGrammarTestLanguageTerminalTokenElementConsumer getTerminalTokenElementConsumer() {
    	return terminalTokenElementConsumer;
    }

    public XtextGrammarTestLanguageAbstractNegatedTokenConsumer getAbstractNegatedTokenConsumer() {
    	return abstractNegatedTokenConsumer;
    }

    public XtextGrammarTestLanguageNegatedTokenConsumer getNegatedTokenConsumer() {
    	return negatedTokenConsumer;
    }

    public XtextGrammarTestLanguageUpToTokenConsumer getUpToTokenConsumer() {
    	return upToTokenConsumer;
    }

    public XtextGrammarTestLanguageWildcardConsumer getWildcardConsumer() {
    	return wildcardConsumer;
    }

    public XtextGrammarTestLanguageCharacterRangeConsumer getCharacterRangeConsumer() {
    	return characterRangeConsumer;
    }

    public XtextGrammarTestLanguageCrossReferenceConsumer getCrossReferenceConsumer() {
    	return crossReferenceConsumer;
    }

    public XtextGrammarTestLanguageParenthesizedElementConsumer getParenthesizedElementConsumer() {
    	return parenthesizedElementConsumer;
    }

    public XtextGrammarTestLanguageParenthesizedTerminalElementConsumer getParenthesizedTerminalElementConsumer() {
    	return parenthesizedTerminalElementConsumer;
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


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getXtextBuiltinConfiguration().getInitialHiddenTerminals();
	}
	
}
