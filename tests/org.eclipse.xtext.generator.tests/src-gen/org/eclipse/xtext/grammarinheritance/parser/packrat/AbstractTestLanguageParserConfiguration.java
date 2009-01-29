/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageInheritedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageREALConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class AbstractTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer;
    private AbstractTestLanguageREALConsumer realConsumer;
    private AbstractTestLanguageIDConsumer idConsumer;

	public AbstractTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public AbstractTestLanguageInheritedParserRuleConsumer getRootConsumer() {
		return inheritedParserRuleConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		inheritedParserRuleConsumer = new AbstractTestLanguageInheritedParserRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
		realConsumer = new AbstractTestLanguageREALConsumer(this);
		idConsumer = new AbstractTestLanguageIDConsumer(this);
	}
	
	public void configureConsumers() {
		getInheritedParserRuleConsumer().setIdConsumer(getIdConsumer());

		getInheritedParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getInheritedParserRuleConsumer().setRuleCall$4$Delimiter(AbstractTestLanguageDelimiters.ruleCall$7$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public AbstractTestLanguageInheritedParserRuleConsumer getInheritedParserRuleConsumer() {
    	return inheritedParserRuleConsumer;
    }

    public AbstractTestLanguageREALConsumer getRealConsumer() {
    	return realConsumer;
    }

    public AbstractTestLanguageIDConsumer getIdConsumer() {
    	return idConsumer;
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
