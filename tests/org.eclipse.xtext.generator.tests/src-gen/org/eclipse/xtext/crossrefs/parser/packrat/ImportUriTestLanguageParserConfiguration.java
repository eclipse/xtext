/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageMainConsumer;
import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageImportConsumer;
import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageTypeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class ImportUriTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private ImportUriTestLanguageMainConsumer mainConsumer;
    private ImportUriTestLanguageImportConsumer importConsumer;
    private ImportUriTestLanguageTypeConsumer typeConsumer;

	private ImportUriTestLanguageGrammarAccess grammarAccess;

	public ImportUriTestLanguageParserConfiguration(IInternalParserConfiguration configuration, ImportUriTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public ImportUriTestLanguageMainConsumer getRootConsumer() {
		return mainConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		mainConsumer = new ImportUriTestLanguageMainConsumer(
    		this, null
    	);
		importConsumer = new ImportUriTestLanguageImportConsumer(
    		this, null
    	);
		typeConsumer = new ImportUriTestLanguageTypeConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getMainConsumer().setRule(grammarAccess.prMain());
		getImportConsumer().setRule(grammarAccess.prImport());
		getTypeConsumer().setRule(grammarAccess.prType());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getMainConsumer().setImportConsumer(getImportConsumer());
		getMainConsumer().setTypeConsumer(getTypeConsumer());

		getImportConsumer().setStringConsumer(getStringConsumer());

		getTypeConsumer().setIdConsumer(getIdConsumer());

		getImportConsumer().setKeyword$2$Delimiter(ImportUriTestLanguageDelimiters.keyword$11$Delimiter);
		getImportConsumer().setRuleCall$4$Delimiter(ImportUriTestLanguageDelimiters.ruleCall$13$Delimiter);
		getTypeConsumer().setCrossReference$9$Delimiter(ImportUriTestLanguageDelimiters.ruleCall$21$Delimiter);
		getTypeConsumer().setKeyword$4$Delimiter(ImportUriTestLanguageDelimiters.keyword$11$Delimiter);
		getTypeConsumer().setKeyword$7$Delimiter(ImportUriTestLanguageDelimiters.keyword$11$Delimiter);
		getTypeConsumer().setRuleCall$6$Delimiter(ImportUriTestLanguageDelimiters.ruleCall$21$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public ImportUriTestLanguageMainConsumer getMainConsumer() {
    	return mainConsumer;
    }

    public ImportUriTestLanguageImportConsumer getImportConsumer() {
    	return importConsumer;
    }

    public ImportUriTestLanguageTypeConsumer getTypeConsumer() {
    	return typeConsumer;
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
