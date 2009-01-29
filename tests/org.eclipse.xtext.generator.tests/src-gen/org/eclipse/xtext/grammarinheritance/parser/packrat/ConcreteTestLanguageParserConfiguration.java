/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;

import org.eclipse.xtext.grammarinheritance.parser.packrat.AbstractTestLanguageParserConfiguration; 

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageConcreteParserRuleConsumer;
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
public class ConcreteTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private AbstractTestLanguageParserConfiguration abstractTestLanguageConfiguration; 

    private ConcreteTestLanguageConcreteParserRuleConsumer concreteParserRuleConsumer;

	public ConcreteTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.abstractTestLanguageConfiguration = new AbstractTestLanguageParserConfiguration(configuration);
	}

	public ConcreteTestLanguageConcreteParserRuleConsumer getRootConsumer() {
		return concreteParserRuleConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createNonTerminalConsumers();
		concreteParserRuleConsumer = new ConcreteTestLanguageConcreteParserRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getConcreteParserRuleConsumer().setInheritedParserRuleConsumer(getInheritedParserRuleConsumer());
		getConcreteParserRuleConsumer().setRealConsumer(getRealConsumer());

		getInheritedParserRuleConsumer().setIdConsumer(getIdConsumer());

		getConcreteParserRuleConsumer().setKeyword$4$Delimiter(ConcreteTestLanguageDelimiters.keyword$6$Delimiter);
		getConcreteParserRuleConsumer().setKeyword$7$Delimiter(ConcreteTestLanguageDelimiters.keyword$9$Delimiter);
		getConcreteParserRuleConsumer().setRuleCall$6$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$8$Delimiter);
		getInheritedParserRuleConsumer().setKeyword$2$Delimiter(ConcreteTestLanguageDelimiters.keyword$6$Delimiter);
		getInheritedParserRuleConsumer().setRuleCall$4$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$7$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public AbstractTestLanguageParserConfiguration getAbstractTestLanguageConfiguration() {
		return abstractTestLanguageConfiguration;
	} 
	
    public ConcreteTestLanguageConcreteParserRuleConsumer getConcreteParserRuleConsumer() {
    	return concreteParserRuleConsumer;
    }

    public AbstractTestLanguageInheritedParserRuleConsumer getInheritedParserRuleConsumer() {
    	return getAbstractTestLanguageConfiguration().getInheritedParserRuleConsumer();
    }

    public AbstractTestLanguageREALConsumer getRealConsumer() {
    	return getAbstractTestLanguageConfiguration().getRealConsumer();
    }

    public AbstractTestLanguageIDConsumer getIdConsumer() {
    	return getAbstractTestLanguageConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getAbstractTestLanguageConfiguration().getIntConsumer();
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getAbstractTestLanguageConfiguration().getStringConsumer();
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getAbstractTestLanguageConfiguration().getMlCommentConsumer();
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getAbstractTestLanguageConfiguration().getSlCommentConsumer();
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getAbstractTestLanguageConfiguration().getWsConsumer();
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getAbstractTestLanguageConfiguration().getAnyOtherConsumer();
    }


}
