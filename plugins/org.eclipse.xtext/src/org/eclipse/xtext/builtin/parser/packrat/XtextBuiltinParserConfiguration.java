/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builtin.parser.packrat;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextBuiltinParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinML_COMMENTConsumer mlCommentConsumer;
	private XtextBuiltinSL_COMMENTConsumer slCommentConsumer;
	private XtextBuiltinWSConsumer wsConsumer;
	private XtextBuiltinANY_OTHERConsumer anyOtherConsumer;

	public XtextBuiltinParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public void configureConsumers() {
	}

	public void createNonTerminalConsumers() {
	}

	public void createTerminalConsumers() {
		idConsumer = new XtextBuiltinIDConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		intConsumer = new XtextBuiltinINTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		stringConsumer = new XtextBuiltinSTRINGConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		mlCommentConsumer = new XtextBuiltinML_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		slCommentConsumer = new XtextBuiltinSL_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		wsConsumer = new XtextBuiltinWSConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		anyOtherConsumer = new XtextBuiltinANY_OTHERConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
	}

	public INonTerminalConsumer getRootConsumer() {
		throw new UnsupportedOperationException("Unexpected call to getRootConsumer");
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

}
