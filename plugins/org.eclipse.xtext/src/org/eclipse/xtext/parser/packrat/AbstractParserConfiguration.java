/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.KeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.RecoveryStateHolder;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserConfiguration implements 
	IParserConfiguration,
	ITerminalConsumerConfiguration, 
	INonTerminalConsumerConfiguration {

	public interface IInternalParserConfiguration {

		ICharSequenceWithOffset getInput();

		IMarkerFactory getMarkerFactory();

		IParsedTokenAcceptor getTokenAcceptor();

		IHiddenTokenHandler getHiddenTokenHandler();

		IConsumerUtility getConsumerUtil();

		RecoveryStateHolder getRecoveryStateHolder();

	}
	
	private final ICharSequenceWithOffset input;
	private final IMarkerFactory markerFactory;
	private final IParsedTokenAcceptor tokenAcceptor;
	private final IHiddenTokenHandler hiddenTokenHandler;
	private final IConsumerUtility consumerUtil;
	private final RecoveryStateHolder recoveryStateHolder;

	protected AbstractParserConfiguration(IInternalParserConfiguration configuration) {
		this.input = configuration.getInput();
		this.markerFactory = configuration.getMarkerFactory();
		this.tokenAcceptor = configuration.getTokenAcceptor();
		this.hiddenTokenHandler = configuration.getHiddenTokenHandler();
		this.consumerUtil = configuration.getConsumerUtil();
		this.recoveryStateHolder = configuration.getRecoveryStateHolder();
	}
	
	protected AbstractParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory, 
			IParsedTokenAcceptor tokenAcceptor,	IHiddenTokenHandler hiddenTokenHandler,
			IConsumerUtility consumerUtil, RecoveryStateHolder recoveryStateHandler) {
		this.input = input;
		this.markerFactory = markerFactory;
		this.tokenAcceptor = tokenAcceptor;
		this.hiddenTokenHandler = hiddenTokenHandler;
		this.consumerUtil = consumerUtil;
		this.recoveryStateHolder = recoveryStateHandler;
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

	public RecoveryStateHolder getRecoveryStateHolder() {
		return recoveryStateHolder;
	}

	public KeywordConsumer createKeywordConsumer() {
		return new KeywordConsumer(this);
	}
}

