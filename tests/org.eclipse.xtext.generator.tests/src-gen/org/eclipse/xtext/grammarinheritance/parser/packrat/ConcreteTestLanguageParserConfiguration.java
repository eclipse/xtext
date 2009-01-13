/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

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

public class ConcreteTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private AbstractTestLanguageParserConfiguration abstractTestLanguageConfiguration; 

    private ConcreteTestLanguageConcreteParserRuleConsumer concreteParserRuleConsumer;

	public ConcreteTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.abstractTestLanguageConfiguration = new AbstractTestLanguageParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public ConcreteTestLanguageConcreteParserRuleConsumer getRootConsumer() {
		return concreteParserRuleConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createNonTerminalConsumers();
		concreteParserRuleConsumer = new ConcreteTestLanguageConcreteParserRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
	}
	
	public void createTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getConcreteParserRuleConsumer().setInheritedParserRuleConsumer(getInheritedParserRuleConsumer());
		getConcreteParserRuleConsumer().setRealConsumer(getRealConsumer());

		getInheritedParserRuleConsumer().setIdConsumer(getIdConsumer());

		getRealConsumer().initFields(this);
		getIdConsumer().initFields(this);
		getIntConsumer().initFields(this);
		getStringConsumer().initFields(this);
		getMlCommentConsumer().initFields(this);
		getSlCommentConsumer().initFields(this);
		getWsConsumer().initFields(this);
		getAnyOtherConsumer().initFields(this);
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
