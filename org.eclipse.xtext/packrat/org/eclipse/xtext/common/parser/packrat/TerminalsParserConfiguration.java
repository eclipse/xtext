/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsIDConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsINTConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsSTRINGConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsML_COMMENTConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsSL_COMMENTConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsWSConsumer;
import org.eclipse.xtext.common.parser.packrat.consumers.TerminalsANY_OTHERConsumer;

public class TerminalsParserConfiguration extends AbstractParserConfiguration {

    private TerminalsIDConsumer idConsumer;
    private TerminalsINTConsumer intConsumer;
    private TerminalsSTRINGConsumer stringConsumer;
    private TerminalsML_COMMENTConsumer mlCommentConsumer;
    private TerminalsSL_COMMENTConsumer slCommentConsumer;
    private TerminalsWSConsumer wsConsumer;
    private TerminalsANY_OTHERConsumer anyOtherConsumer;

	private TerminalsGrammarAccess grammarAccess;

	public TerminalsParserConfiguration(IInternalParserConfiguration configuration, TerminalsGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
	}

	@Override
	public INonTerminalConsumer getRootConsumer() {
		return null;
	} 

	@Override
	public void createNonTerminalConsumers() {
	}
	
	@Override
	public void createTerminalConsumers() {
		idConsumer = new TerminalsIDConsumer(this);
		intConsumer = new TerminalsINTConsumer(this);
		stringConsumer = new TerminalsSTRINGConsumer(this);
		mlCommentConsumer = new TerminalsML_COMMENTConsumer(this);
		slCommentConsumer = new TerminalsSL_COMMENTConsumer(this);
		wsConsumer = new TerminalsWSConsumer(this);
		anyOtherConsumer = new TerminalsANY_OTHERConsumer(this);
	}
	
	@Override
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getIdConsumer().setRule(grammarAccess.getIDRule());
		getIntConsumer().setRule(grammarAccess.getINTRule());
		getStringConsumer().setRule(grammarAccess.getSTRINGRule());
		getMlCommentConsumer().setRule(grammarAccess.getML_COMMENTRule());
		getSlCommentConsumer().setRule(grammarAccess.getSL_COMMENTRule());
		getWsConsumer().setRule(grammarAccess.getWSRule());
		getAnyOtherConsumer().setRule(grammarAccess.getANY_OTHERRule());


	}
	
    public TerminalsIDConsumer getIdConsumer() {
    	return idConsumer;
    }

    public TerminalsINTConsumer getIntConsumer() {
    	return intConsumer;
    }

    public TerminalsSTRINGConsumer getStringConsumer() {
    	return stringConsumer;
    }

    public TerminalsML_COMMENTConsumer getMlCommentConsumer() {
    	return mlCommentConsumer;
    }

    public TerminalsSL_COMMENTConsumer getSlCommentConsumer() {
    	return slCommentConsumer;
    }

    public TerminalsWSConsumer getWsConsumer() {
    	return wsConsumer;
    }

    public TerminalsANY_OTHERConsumer getAnyOtherConsumer() {
    	return anyOtherConsumer;
    }


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() };
	}
	
}
