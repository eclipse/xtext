/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarIDConsumer;
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

@SuppressWarnings("unused")
public class XtextParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private XtextGrammarConsumer grammarConsumer;
    private XtextGrammarIDConsumer grammarIdConsumer;
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

	public XtextParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public XtextGrammarConsumer getRootConsumer() {
		return grammarConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		grammarConsumer = new XtextGrammarConsumer(
    		this, null
    	);
		grammarIdConsumer = new XtextGrammarIDConsumer(
    		this, null
    	);
		abstractRuleConsumer = new XtextAbstractRuleConsumer(
    		this, null
    	);
		abstractMetamodelDeclarationConsumer = new XtextAbstractMetamodelDeclarationConsumer(
    		this, null
    	);
		generatedMetamodelConsumer = new XtextGeneratedMetamodelConsumer(
    		this, null
    	);
		referencedMetamodelConsumer = new XtextReferencedMetamodelConsumer(
    		this, null
    	);
		lexerRuleConsumer = new XtextLexerRuleConsumer(
    		this, null
    	);
		parserRuleConsumer = new XtextParserRuleConsumer(
    		this, null
    	);
		terminalRuleConsumer = new XtextTerminalRuleConsumer(
    		this, null
    	);
		typeRefConsumer = new XtextTypeRefConsumer(
    		this, null
    	);
		alternativesConsumer = new XtextAlternativesConsumer(
    		this, null
    	);
		terminalAlternativesConsumer = new XtextTerminalAlternativesConsumer(
    		this, null
    	);
		groupConsumer = new XtextGroupConsumer(
    		this, null
    	);
		terminalGroupConsumer = new XtextTerminalGroupConsumer(
    		this, null
    	);
		abstractTokenConsumer = new XtextAbstractTokenConsumer(
    		this, null
    	);
		terminalTokenConsumer = new XtextTerminalTokenConsumer(
    		this, null
    	);
		assignmentConsumer = new XtextAssignmentConsumer(
    		this, null
    	);
		actionConsumer = new XtextActionConsumer(
    		this, null
    	);
		abstractTerminalConsumer = new XtextAbstractTerminalConsumer(
    		this, null
    	);
		terminalTokenElementConsumer = new XtextTerminalTokenElementConsumer(
    		this, null
    	);
		abstractNegatedTokenConsumer = new XtextAbstractNegatedTokenConsumer(
    		this, null
    	);
		negatedTokenConsumer = new XtextNegatedTokenConsumer(
    		this, null
    	);
		upToTokenConsumer = new XtextUpToTokenConsumer(
    		this, null
    	);
		wildcardConsumer = new XtextWildcardConsumer(
    		this, null
    	);
		characterRangeConsumer = new XtextCharacterRangeConsumer(
    		this, null
    	);
		crossReferenceConsumer = new XtextCrossReferenceConsumer(
    		this, null
    	);
		parenthesizedElementConsumer = new XtextParenthesizedElementConsumer(
    		this, null
    	);
		parenthesizedTerminalElementConsumer = new XtextParenthesizedTerminalElementConsumer(
    		this, null
    	);
		keywordConsumer = new XtextKeywordConsumer(
    		this, null
    	);
		ruleCallConsumer = new XtextRuleCallConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getGrammarConsumer().setAbstractMetamodelDeclarationConsumer(getAbstractMetamodelDeclarationConsumer());
		getGrammarConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());
		getGrammarConsumer().setGrammarIdConsumer(getGrammarIdConsumer());
		getGrammarConsumer().setIdConsumer(getIdConsumer());

		getGrammarIdConsumer().setIdConsumer(getIdConsumer());

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

		getGrammarConsumer().setCrossReference$24$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getGrammarConsumer().setCrossReference$29$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getGrammarConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$13$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$20$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGrammarConsumer().setKeyword$21$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getGrammarConsumer().setKeyword$27$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getGrammarConsumer().setKeyword$31$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getGrammarIdConsumer().setKeyword$4$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getGrammarIdConsumer().setRuleCall$2$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getGrammarIdConsumer().setRuleCall$5$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getGeneratedMetamodelConsumer().setCrossReference$8$Delimiter(XtextDelimiters.crossReference$67$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$4$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$6$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getGeneratedMetamodelConsumer().setRuleCall$13$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getReferencedMetamodelConsumer().setCrossReference$5$Delimiter(XtextDelimiters.crossReference$67$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getReferencedMetamodelConsumer().setRuleCall$10$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getLexerRuleConsumer().setKeyword$15$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getLexerRuleConsumer().setKeyword$18$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getLexerRuleConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getLexerRuleConsumer().setRuleCall$17$Delimiter(XtextDelimiters.crossReference$67$Delimiter);
		getLexerRuleConsumer().setRuleCall$10$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getParserRuleConsumer().setCrossReference$20$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getParserRuleConsumer().setCrossReference$25$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getParserRuleConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$16$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getParserRuleConsumer().setKeyword$17$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParserRuleConsumer().setKeyword$23$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParserRuleConsumer().setKeyword$27$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParserRuleConsumer().setKeyword$28$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParserRuleConsumer().setKeyword$31$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParserRuleConsumer().setRuleCall$7$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getTerminalRuleConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getTerminalRuleConsumer().setKeyword$14$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalRuleConsumer().setKeyword$17$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalRuleConsumer().setRuleCall$9$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getTypeRefConsumer().setCrossReference$4$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getTypeRefConsumer().setCrossReference$8$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getTypeRefConsumer().setKeyword$6$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAlternativesConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalAlternativesConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAbstractTokenConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAbstractTokenConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAbstractTokenConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalTokenConsumer().setKeyword$6$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalTokenConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getTerminalTokenConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAssignmentConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAssignmentConsumer().setKeyword$9$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAssignmentConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getAssignmentConsumer().setRuleCall$4$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getActionConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setKeyword$10$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$11$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setKeyword$14$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setKeyword$19$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setKeyword$20$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setKeyword$21$Delimiter(XtextDelimiters.keyword$11$Delimiter);
		getActionConsumer().setKeyword$22$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getActionConsumer().setRuleCall$16$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getNegatedTokenConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getUpToTokenConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getWildcardConsumer().setKeyword$2$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getCharacterRangeConsumer().setKeyword$7$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getCrossReferenceConsumer().setCrossReference$10$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
		getCrossReferenceConsumer().setKeyword$4$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getCrossReferenceConsumer().setKeyword$8$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getCrossReferenceConsumer().setKeyword$12$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParenthesizedElementConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParenthesizedElementConsumer().setKeyword$5$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$3$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getParenthesizedTerminalElementConsumer().setKeyword$5$Delimiter(XtextDelimiters.keyword$24$Delimiter);
		getKeywordConsumer().setRuleCall$2$Delimiter(XtextDelimiters.crossReference$67$Delimiter);
		getRuleCallConsumer().setCrossReference$2$Delimiter(XtextDelimiters.crossReference$27$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public XtextGrammarConsumer getGrammarConsumer() {
    	return grammarConsumer;
    }

    public XtextGrammarIDConsumer getGrammarIdConsumer() {
    	return grammarIdConsumer;
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


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getXtextBuiltinConfiguration().getInitialHiddenTerminals();
	}
	
}
