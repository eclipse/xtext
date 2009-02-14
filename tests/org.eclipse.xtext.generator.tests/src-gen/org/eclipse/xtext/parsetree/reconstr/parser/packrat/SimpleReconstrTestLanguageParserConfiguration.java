/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageOpConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTermConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageParensConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTwoNumbersConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageManyStringsConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTypeConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageRef2Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageSpareConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageBooleanConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class SimpleReconstrTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private SimpleReconstrTestLanguageOpConsumer opConsumer;
    private SimpleReconstrTestLanguageTermConsumer termConsumer;
    private SimpleReconstrTestLanguageAtomConsumer atomConsumer;
    private SimpleReconstrTestLanguageParensConsumer parensConsumer;
    private SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer;
    private SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer;
    private SimpleReconstrTestLanguageTypeConsumer typeConsumer;
    private SimpleReconstrTestLanguageRef2Consumer ref2Consumer;
    private SimpleReconstrTestLanguageSpareConsumer spareConsumer;
    private SimpleReconstrTestLanguageBooleanConsumer booleanConsumer;

	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;

	public SimpleReconstrTestLanguageParserConfiguration(IInternalParserConfiguration configuration, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public SimpleReconstrTestLanguageOpConsumer getRootConsumer() {
		return opConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		opConsumer = new SimpleReconstrTestLanguageOpConsumer(
    		this, null
    	);
		termConsumer = new SimpleReconstrTestLanguageTermConsumer(
    		this, null
    	);
		atomConsumer = new SimpleReconstrTestLanguageAtomConsumer(
    		this, null
    	);
		parensConsumer = new SimpleReconstrTestLanguageParensConsumer(
    		this, null
    	);
		twoNumbersConsumer = new SimpleReconstrTestLanguageTwoNumbersConsumer(
    		this, null
    	);
		manyStringsConsumer = new SimpleReconstrTestLanguageManyStringsConsumer(
    		this, null
    	);
		typeConsumer = new SimpleReconstrTestLanguageTypeConsumer(
    		this, null
    	);
		ref2Consumer = new SimpleReconstrTestLanguageRef2Consumer(
    		this, null
    	);
		spareConsumer = new SimpleReconstrTestLanguageSpareConsumer(
    		this, null
    	);
		booleanConsumer = new SimpleReconstrTestLanguageBooleanConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getOpConsumer().setRule(grammarAccess.prOp());
		getTermConsumer().setRule(grammarAccess.prTerm());
		getAtomConsumer().setRule(grammarAccess.prAtom());
		getParensConsumer().setRule(grammarAccess.prParens());
		getTwoNumbersConsumer().setRule(grammarAccess.prTwoNumbers());
		getManyStringsConsumer().setRule(grammarAccess.prManyStrings());
		getTypeConsumer().setRule(grammarAccess.prType());
		getRef2Consumer().setRule(grammarAccess.prRef2());
		getSpareConsumer().setRule(grammarAccess.prSpare());
		getBooleanConsumer().setRule(grammarAccess.prBoolean());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getOpConsumer().setTermConsumer(getTermConsumer());

		getTermConsumer().setAtomConsumer(getAtomConsumer());
		getTermConsumer().setBooleanConsumer(getBooleanConsumer());
		getTermConsumer().setManyStringsConsumer(getManyStringsConsumer());
		getTermConsumer().setParensConsumer(getParensConsumer());
		getTermConsumer().setRef2Consumer(getRef2Consumer());
		getTermConsumer().setSpareConsumer(getSpareConsumer());
		getTermConsumer().setTwoNumbersConsumer(getTwoNumbersConsumer());
		getTermConsumer().setTypeConsumer(getTypeConsumer());

		getAtomConsumer().setIdConsumer(getIdConsumer());

		getParensConsumer().setOpConsumer(getOpConsumer());

		getTwoNumbersConsumer().setIntConsumer(getIntConsumer());

		getManyStringsConsumer().setStringConsumer(getStringConsumer());

		getTypeConsumer().setIdConsumer(getIdConsumer());

		getRef2Consumer().setStringConsumer(getStringConsumer());

		getSpareConsumer().setIdConsumer(getIdConsumer());

		getBooleanConsumer().setIdConsumer(getIdConsumer());

		getAtomConsumer().setRuleCall$2$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
		getParensConsumer().setKeyword$4$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getParensConsumer().setKeyword$6$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getParensConsumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getTwoNumbersConsumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getTwoNumbersConsumer().setRuleCall$4$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getTwoNumbersConsumer().setRuleCall$6$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getTwoNumbersConsumer().setRuleCall$10$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getManyStringsConsumer().setKeyword$3$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getManyStringsConsumer().setRuleCall$5$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getManyStringsConsumer().setRuleCall$7$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getTypeConsumer().setCrossReference$9$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
		getTypeConsumer().setKeyword$4$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getTypeConsumer().setKeyword$7$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getTypeConsumer().setRuleCall$6$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
		getRef2Consumer().setKeyword$2$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getRef2Consumer().setKeyword$6$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getRef2Consumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getRef2Consumer().setRuleCall$7$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$46$Delimiter);
		getSpareConsumer().setKeyword$3$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getSpareConsumer().setKeyword$7$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getSpareConsumer().setRuleCall$5$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
		getSpareConsumer().setRuleCall$9$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
		getBooleanConsumer().setKeyword$4$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$36$Delimiter);
		getBooleanConsumer().setKeyword$6$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getBooleanConsumer().setKeyword$7$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$67$Delimiter);
		getBooleanConsumer().setRuleCall$9$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$30$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public SimpleReconstrTestLanguageOpConsumer getOpConsumer() {
    	return opConsumer;
    }

    public SimpleReconstrTestLanguageTermConsumer getTermConsumer() {
    	return termConsumer;
    }

    public SimpleReconstrTestLanguageAtomConsumer getAtomConsumer() {
    	return atomConsumer;
    }

    public SimpleReconstrTestLanguageParensConsumer getParensConsumer() {
    	return parensConsumer;
    }

    public SimpleReconstrTestLanguageTwoNumbersConsumer getTwoNumbersConsumer() {
    	return twoNumbersConsumer;
    }

    public SimpleReconstrTestLanguageManyStringsConsumer getManyStringsConsumer() {
    	return manyStringsConsumer;
    }

    public SimpleReconstrTestLanguageTypeConsumer getTypeConsumer() {
    	return typeConsumer;
    }

    public SimpleReconstrTestLanguageRef2Consumer getRef2Consumer() {
    	return ref2Consumer;
    }

    public SimpleReconstrTestLanguageSpareConsumer getSpareConsumer() {
    	return spareConsumer;
    }

    public SimpleReconstrTestLanguageBooleanConsumer getBooleanConsumer() {
    	return booleanConsumer;
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
