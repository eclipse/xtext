/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313ModelConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313DatatypeConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313NestedDatatypeConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313ChildConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313Child1Consumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313Child2Consumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class Bug250313ParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private Bug250313ModelConsumer modelConsumer;
    private Bug250313DatatypeConsumer datatypeConsumer;
    private Bug250313NestedDatatypeConsumer nestedDatatypeConsumer;
    private Bug250313ChildConsumer childConsumer;
    private Bug250313Child1Consumer child1Consumer;
    private Bug250313Child2Consumer child2Consumer;

	private Bug250313GrammarAccess grammarAccess;

	public Bug250313ParserConfiguration(IInternalParserConfiguration configuration, Bug250313GrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public Bug250313ModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		modelConsumer = new Bug250313ModelConsumer(
    		this, null
    	);
		datatypeConsumer = new Bug250313DatatypeConsumer(
    		this, null
    	);
		nestedDatatypeConsumer = new Bug250313NestedDatatypeConsumer(
    		this, null
    	);
		childConsumer = new Bug250313ChildConsumer(
    		this, null
    	);
		child1Consumer = new Bug250313Child1Consumer(
    		this, null
    	);
		child2Consumer = new Bug250313Child2Consumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getModelConsumer().setRule(grammarAccess.prModel());
		getDatatypeConsumer().setRule(grammarAccess.prDatatype());
		getNestedDatatypeConsumer().setRule(grammarAccess.prNestedDatatype());
		getChildConsumer().setRule(grammarAccess.prChild());
		getChild1Consumer().setRule(grammarAccess.prChild1());
		getChild2Consumer().setRule(grammarAccess.prChild2());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getModelConsumer().setChildConsumer(getChildConsumer());
		getModelConsumer().setDatatypeConsumer(getDatatypeConsumer());
		getModelConsumer().setIdConsumer(getIdConsumer());
		getModelConsumer().setNestedDatatypeConsumer(getNestedDatatypeConsumer());
		getModelConsumer().setStringConsumer(getStringConsumer());

		getDatatypeConsumer().setIdConsumer(getIdConsumer());

		getNestedDatatypeConsumer().setDatatypeConsumer(getDatatypeConsumer());
		getNestedDatatypeConsumer().setIdConsumer(getIdConsumer());

		getChildConsumer().setChild1Consumer(getChild1Consumer());
		getChildConsumer().setChild2Consumer(getChild2Consumer());

		getChild1Consumer().setIdConsumer(getIdConsumer());

		getChild2Consumer().setStringConsumer(getStringConsumer());

		getModelConsumer().setCrossReference$66$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
		getModelConsumer().setCrossReference$68$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getModelConsumer().setKeyword$10$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$16$Delimiter(Bug250313Delimiters.keyword$18$Delimiter);
		getModelConsumer().setKeyword$22$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$28$Delimiter(Bug250313Delimiters.keyword$18$Delimiter);
		getModelConsumer().setKeyword$34$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$38$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$42$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$46$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$50$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$54$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getModelConsumer().setKeyword$59$Delimiter(Bug250313Delimiters.keyword$18$Delimiter);
		getModelConsumer().setKeyword$63$Delimiter(Bug250313Delimiters.keyword$18$Delimiter);
		getModelConsumer().setRuleCall$17$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
		getModelConsumer().setRuleCall$20$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getModelConsumer().setRuleCall$29$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
		getModelConsumer().setRuleCall$32$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getModelConsumer().setRuleCall$36$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
		getModelConsumer().setRuleCall$40$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
		getDatatypeConsumer().setKeyword$4$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getDatatypeConsumer().setRuleCall$3$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getDatatypeConsumer().setRuleCall$5$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getNestedDatatypeConsumer().setKeyword$4$Delimiter(Bug250313Delimiters.keyword$12$Delimiter);
		getNestedDatatypeConsumer().setRuleCall$3$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getChild1Consumer().setRuleCall$2$Delimiter(Bug250313Delimiters.ruleCall$22$Delimiter);
		getChild2Consumer().setRuleCall$2$Delimiter(Bug250313Delimiters.ruleCall$19$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public Bug250313ModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public Bug250313DatatypeConsumer getDatatypeConsumer() {
    	return datatypeConsumer;
    }

    public Bug250313NestedDatatypeConsumer getNestedDatatypeConsumer() {
    	return nestedDatatypeConsumer;
    }

    public Bug250313ChildConsumer getChildConsumer() {
    	return childConsumer;
    }

    public Bug250313Child1Consumer getChild1Consumer() {
    	return child1Consumer;
    }

    public Bug250313Child2Consumer getChild2Consumer() {
    	return child2Consumer;
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
