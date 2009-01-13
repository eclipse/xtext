/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserConfiguration implements IParserConfiguration {

	private final ICharSequenceWithOffset input;
	private final IMarkerFactory markerFactory;
	private final IParsedTokenAcceptor tokenAcceptor;
	private final IHiddenTokenHandler hiddenTokenHandler;
	private final IConsumerUtility consumerUtil;

	protected AbstractParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory, 
			IParsedTokenAcceptor tokenAcceptor,	IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil) {
		this.input = input;
		this.markerFactory = markerFactory;
		this.tokenAcceptor = tokenAcceptor;
		this.hiddenTokenHandler = hiddenTokenHandler;
		this.consumerUtil = consumerUtil;
	}
	
	public ICharSequenceWithOffset getInput() {
		return input;
	}

	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	public IParsedTokenAcceptor getTokenAcceptor() {
		return tokenAcceptor;
	}

	public IHiddenTokenHandler getHiddenTokenHandler() {
		return hiddenTokenHandler;
	}

	public IConsumerUtility getConsumerUtil() {
		return consumerUtil;
	}
}
