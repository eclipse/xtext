/*
Generated with Xtext
*/
package org.eclipse.xtext.builtin.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class XtextBuiltinParserConfiguration extends AbstractParserConfiguration {

    private XtextBuiltinIDConsumer idConsumer;
    private XtextBuiltinINTConsumer intConsumer;
    private XtextBuiltinSTRINGConsumer stringConsumer;
    private XtextBuiltinML_COMMENTConsumer mlCommentConsumer;
    private XtextBuiltinSL_COMMENTConsumer slCommentConsumer;
    private XtextBuiltinWSConsumer wsConsumer;
    private XtextBuiltinANY_OTHERConsumer anyOtherConsumer;

	public XtextBuiltinParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
	}

	public INonTerminalConsumer getRootConsumer() {
		return null;
	} 

	public void createNonTerminalConsumers() {
	}
	
	public void createTerminalConsumers() {
		idConsumer = new XtextBuiltinIDConsumer(this);
		intConsumer = new XtextBuiltinINTConsumer(this);
		stringConsumer = new XtextBuiltinSTRINGConsumer(this);
		mlCommentConsumer = new XtextBuiltinML_COMMENTConsumer(this);
		slCommentConsumer = new XtextBuiltinSL_COMMENTConsumer(this);
		wsConsumer = new XtextBuiltinWSConsumer(this);
		anyOtherConsumer = new XtextBuiltinANY_OTHERConsumer(this);
	}
	
	public void configureConsumers() {
	}
	
    public XtextBuiltinIDConsumer getIdConsumer() {
    	return idConsumer;
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return intConsumer;
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return stringConsumer;
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return mlCommentConsumer;
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return slCommentConsumer;
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return wsConsumer;
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return anyOtherConsumer;
    }


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() };
	}
	
}
