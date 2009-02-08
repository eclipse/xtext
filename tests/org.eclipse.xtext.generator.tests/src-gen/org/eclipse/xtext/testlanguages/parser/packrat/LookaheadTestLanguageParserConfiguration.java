/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageEntryConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageAltsConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead0Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead1Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead2Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead3Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead4Consumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class LookaheadTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private LookaheadTestLanguageEntryConsumer entryConsumer;
    private LookaheadTestLanguageAltsConsumer altsConsumer;
    private LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer;
    private LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer;
    private LookaheadTestLanguageLookAhead2Consumer lookAhead2Consumer;
    private LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer;
    private LookaheadTestLanguageLookAhead4Consumer lookAhead4Consumer;

	public LookaheadTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public LookaheadTestLanguageEntryConsumer getRootConsumer() {
		return entryConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		entryConsumer = new LookaheadTestLanguageEntryConsumer(
    		this, null
    	);
		altsConsumer = new LookaheadTestLanguageAltsConsumer(
    		this, null
    	);
		lookAhead0Consumer = new LookaheadTestLanguageLookAhead0Consumer(
    		this, null
    	);
		lookAhead1Consumer = new LookaheadTestLanguageLookAhead1Consumer(
    		this, null
    	);
		lookAhead2Consumer = new LookaheadTestLanguageLookAhead2Consumer(
    		this, null
    	);
		lookAhead3Consumer = new LookaheadTestLanguageLookAhead3Consumer(
    		this, null
    	);
		lookAhead4Consumer = new LookaheadTestLanguageLookAhead4Consumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getEntryConsumer().setAltsConsumer(getAltsConsumer());

		getAltsConsumer().setLookAhead0Consumer(getLookAhead0Consumer());
		getAltsConsumer().setLookAhead1Consumer(getLookAhead1Consumer());
		getAltsConsumer().setLookAhead3Consumer(getLookAhead3Consumer());

		getLookAhead1Consumer().setLookAhead2Consumer(getLookAhead2Consumer());

		getLookAhead3Consumer().setLookAhead4Consumer(getLookAhead4Consumer());

		getLookAhead0Consumer().setKeyword$2$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead0Consumer().setKeyword$4$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead1Consumer().setKeyword$4$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead1Consumer().setKeyword$8$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead1Consumer().setKeyword$10$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead2Consumer().setKeyword$4$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead2Consumer().setKeyword$6$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead2Consumer().setKeyword$7$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead3Consumer().setKeyword$4$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead3Consumer().setKeyword$5$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead3Consumer().setKeyword$7$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead4Consumer().setKeyword$3$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
		getLookAhead4Consumer().setKeyword$5$Delimiter(LookaheadTestLanguageDelimiters.keyword$15$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public LookaheadTestLanguageEntryConsumer getEntryConsumer() {
    	return entryConsumer;
    }

    public LookaheadTestLanguageAltsConsumer getAltsConsumer() {
    	return altsConsumer;
    }

    public LookaheadTestLanguageLookAhead0Consumer getLookAhead0Consumer() {
    	return lookAhead0Consumer;
    }

    public LookaheadTestLanguageLookAhead1Consumer getLookAhead1Consumer() {
    	return lookAhead1Consumer;
    }

    public LookaheadTestLanguageLookAhead2Consumer getLookAhead2Consumer() {
    	return lookAhead2Consumer;
    }

    public LookaheadTestLanguageLookAhead3Consumer getLookAhead3Consumer() {
    	return lookAhead3Consumer;
    }

    public LookaheadTestLanguageLookAhead4Consumer getLookAhead4Consumer() {
    	return lookAhead4Consumer;
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
