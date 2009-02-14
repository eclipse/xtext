/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestRootConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class TransientValuesTestParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private TransientValuesTestRootConsumer rootConsumer;
    private TransientValuesTestTestRequiredConsumer testRequiredConsumer;
    private TransientValuesTestTestOptionalConsumer testOptionalConsumer;
    private TransientValuesTestTestListConsumer testListConsumer;

	private TransientValuesTestGrammarAccess grammarAccess;

	public TransientValuesTestParserConfiguration(IInternalParserConfiguration configuration, TransientValuesTestGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public TransientValuesTestRootConsumer getRootConsumer() {
		return rootConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		rootConsumer = new TransientValuesTestRootConsumer(
    		this, null
    	);
		testRequiredConsumer = new TransientValuesTestTestRequiredConsumer(
    		this, null
    	);
		testOptionalConsumer = new TransientValuesTestTestOptionalConsumer(
    		this, null
    	);
		testListConsumer = new TransientValuesTestTestListConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getRootConsumer().setRule(grammarAccess.prRoot());
		getTestRequiredConsumer().setRule(grammarAccess.prTestRequired());
		getTestOptionalConsumer().setRule(grammarAccess.prTestOptional());
		getTestListConsumer().setRule(grammarAccess.prTestList());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getRootConsumer$().setTestListConsumer(getTestListConsumer());
		getRootConsumer$().setTestOptionalConsumer(getTestOptionalConsumer());
		getRootConsumer$().setTestRequiredConsumer(getTestRequiredConsumer());

		getTestRequiredConsumer().setIntConsumer(getIntConsumer());

		getTestOptionalConsumer().setIntConsumer(getIntConsumer());

		getTestListConsumer().setIntConsumer(getIntConsumer());

		getRootConsumer().setKeyword$2$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestRequiredConsumer().setKeyword$3$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestRequiredConsumer().setRuleCall$5$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestRequiredConsumer().setRuleCall$7$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestOptionalConsumer().setKeyword$3$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestOptionalConsumer().setKeyword$7$Delimiter(TransientValuesTestDelimiters.keyword$27$Delimiter);
		getTestOptionalConsumer().setRuleCall$5$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestOptionalConsumer().setRuleCall$9$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestListConsumer().setKeyword$2$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestListConsumer().setRuleCall$4$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
	public TransientValuesTestRootConsumer getRootConsumer$() {
    	return rootConsumer;
    }

    public TransientValuesTestTestRequiredConsumer getTestRequiredConsumer() {
    	return testRequiredConsumer;
    }

    public TransientValuesTestTestOptionalConsumer getTestOptionalConsumer() {
    	return testOptionalConsumer;
    }

    public TransientValuesTestTestListConsumer getTestListConsumer() {
    	return testListConsumer;
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
