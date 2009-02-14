/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers.MetamodelRefTestLanguageFooConsumer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers.MetamodelRefTestLanguageNameRefConsumer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers.MetamodelRefTestLanguageMyRuleConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class MetamodelRefTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private MetamodelRefTestLanguageFooConsumer fooConsumer;
    private MetamodelRefTestLanguageNameRefConsumer nameRefConsumer;
    private MetamodelRefTestLanguageMyRuleConsumer myRuleConsumer;

	private MetamodelRefTestLanguageGrammarAccess grammarAccess;

	public MetamodelRefTestLanguageParserConfiguration(IInternalParserConfiguration configuration, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public MetamodelRefTestLanguageFooConsumer getRootConsumer() {
		return fooConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		fooConsumer = new MetamodelRefTestLanguageFooConsumer(
    		this, null
    	);
		nameRefConsumer = new MetamodelRefTestLanguageNameRefConsumer(
    		this, null
    	);
		myRuleConsumer = new MetamodelRefTestLanguageMyRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getFooConsumer().setRule(grammarAccess.prFoo());
		getNameRefConsumer().setRule(grammarAccess.prNameRef());
		getMyRuleConsumer().setRule(grammarAccess.prMyRule());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getFooConsumer().setIdConsumer(getIdConsumer());
		getFooConsumer().setNameRefConsumer(getNameRefConsumer());

		getNameRefConsumer().setIdConsumer(getIdConsumer());

		getMyRuleConsumer().setIdConsumer(getIdConsumer());

		getFooConsumer().setRuleCall$3$Delimiter(MetamodelRefTestLanguageDelimiters.ruleCall$6$Delimiter);
		getNameRefConsumer().setCrossReference$2$Delimiter(MetamodelRefTestLanguageDelimiters.ruleCall$6$Delimiter);
		getMyRuleConsumer().setRuleCall$2$Delimiter(MetamodelRefTestLanguageDelimiters.ruleCall$6$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public MetamodelRefTestLanguageFooConsumer getFooConsumer() {
    	return fooConsumer;
    }

    public MetamodelRefTestLanguageNameRefConsumer getNameRefConsumer() {
    	return nameRefConsumer;
    }

    public MetamodelRefTestLanguageMyRuleConsumer getMyRuleConsumer() {
    	return myRuleConsumer;
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
