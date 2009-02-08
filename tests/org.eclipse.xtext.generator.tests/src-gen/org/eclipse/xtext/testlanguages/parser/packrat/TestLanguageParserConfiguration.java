/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageEntryRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageChoiceRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageReducibleRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageTerminalRuleConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class TestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private TestLanguageEntryRuleConsumer entryRuleConsumer;
    private TestLanguageAbstractRuleConsumer abstractRuleConsumer;
    private TestLanguageChoiceRuleConsumer choiceRuleConsumer;
    private TestLanguageReducibleRuleConsumer reducibleRuleConsumer;
    private TestLanguageTerminalRuleConsumer terminalRuleConsumer;

	public TestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public TestLanguageEntryRuleConsumer getRootConsumer() {
		return entryRuleConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		entryRuleConsumer = new TestLanguageEntryRuleConsumer(
    		this, null
    	);
		abstractRuleConsumer = new TestLanguageAbstractRuleConsumer(
    		this, null
    	);
		choiceRuleConsumer = new TestLanguageChoiceRuleConsumer(
    		this, null
    	);
		reducibleRuleConsumer = new TestLanguageReducibleRuleConsumer(
    		this, null
    	);
		terminalRuleConsumer = new TestLanguageTerminalRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getEntryRuleConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());

		getAbstractRuleConsumer().setChoiceRuleConsumer(getChoiceRuleConsumer());
		getAbstractRuleConsumer().setReducibleRuleConsumer(getReducibleRuleConsumer());

		getChoiceRuleConsumer().setIdConsumer(getIdConsumer());

		getReducibleRuleConsumer().setTerminalRuleConsumer(getTerminalRuleConsumer());

		getTerminalRuleConsumer().setStringConsumer(getStringConsumer());

		getChoiceRuleConsumer().setKeyword$3$Delimiter(TestLanguageDelimiters.keyword$14$Delimiter);
		getChoiceRuleConsumer().setKeyword$5$Delimiter(TestLanguageDelimiters.keyword$14$Delimiter);
		getChoiceRuleConsumer().setRuleCall$7$Delimiter(TestLanguageDelimiters.ruleCall$18$Delimiter);
		getReducibleRuleConsumer().setKeyword$3$Delimiter(TestLanguageDelimiters.keyword$14$Delimiter);
		getTerminalRuleConsumer().setRuleCall$2$Delimiter(TestLanguageDelimiters.ruleCall$33$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public TestLanguageEntryRuleConsumer getEntryRuleConsumer() {
    	return entryRuleConsumer;
    }

    public TestLanguageAbstractRuleConsumer getAbstractRuleConsumer() {
    	return abstractRuleConsumer;
    }

    public TestLanguageChoiceRuleConsumer getChoiceRuleConsumer() {
    	return choiceRuleConsumer;
    }

    public TestLanguageReducibleRuleConsumer getReducibleRuleConsumer() {
    	return reducibleRuleConsumer;
    }

    public TestLanguageTerminalRuleConsumer getTerminalRuleConsumer() {
    	return terminalRuleConsumer;
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
